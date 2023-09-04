import util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
                String sql = """
                        SELECT pl.course_name,COUNT(pl.subscription_date) /
                        (max(month(subscription_date)) - min(month(subscription_date)) + 1) as avg_purchase_per_month
                        FROM purchaselist pl
                        WHERE YEAR(pl.subscription_date) = 2018
                        GROUP BY pl.course_name;
                        """;
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            String courseName = resultSet.getString("course_name");
            String avgPurchase = resultSet.getString("avg_purchase_per_month");
                System.out.println(courseName + " | " + avgPurchase);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
