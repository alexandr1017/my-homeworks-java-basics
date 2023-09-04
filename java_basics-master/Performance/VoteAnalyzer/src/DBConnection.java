import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "testtest";
    private static StringBuilder insertQuery = new StringBuilder();
    private static int count = 0;



    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                                                     "    id INT NOT NULL AUTO_INCREMENT," +
                                                     "    name TINYTEXT NOT NULL," +
                                                     "    birthDate DATE NOT NULL," +
                                                     "    PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException {
        String sql = "INSERT INTO voter_count(name, birthDate) " +
                     "VALUES " + insertQuery.toString();
        DBConnection.getConnection().createStatement().execute(sql);
    }

    public static void countVoter(String name, String birthDay) throws SQLException {

        birthDay = birthDay.replace('.', '-');
        insertQuery.append(insertQuery.length() == 0 ? "" : ",")
                .append("('")
                .append(name)
                .append("', '")
                .append(birthDay)
                .append("')");

        if (insertQuery.length() > 100_000) {
            executeMultiInsert();
            insertQuery = new StringBuilder();
        }

    }

    public static void printVoterCounts() throws SQLException {

        String sql = """
                SELECT name, birthDate, COUNT(name) as visits_count
                FROM voter_count
                GROUP BY name, birthDate having count(*) > 1
                """;
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                               rs.getString("birthDate") + ") - " + rs.getInt("visits_count"));
        }
        rs.close();
    }

    public static int customSelect () throws SQLException {
        String sql = """
                SELECT id FROM voter_count WHERE name='Владимирцев Густав'
                """;
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        if(!rs.next()){
            return -1;
        } else {
            return rs.getInt("id");
        }
    }
    public static void increaseCount(){
        count++;
    }
    public static int getCount() {
        return count;
    }
}
