public class Main {
    public static void main(String[] args) {
        Company company = new Company(
                40000,
                150000,
                70000,
                1.5,
                0.05);

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager(company));
        }
        for (int i = 0; i < 18; i++) {
            company.hire(new Operator(company));
        }
        for (int i = 0; i < 1; i++) {
            company.hire(new TopManager(company));
        }


        company.printTopSalary(10);
        company.printLowestSalary(5);
        System.out.println("Количество сотрудников: " + company.getCountEmployee());
        System.out.println("Доход компании: " + company.getIncome());
        //увольняем 80%
        company.fireOfPercent(80);
        System.out.println("Уволено 80% сорудников. Количество сотрудников: " + company.getCountEmployee());
        company.printTopSalary(5);
        company.printLowestSalary(5);
        System.out.println("Доход компании: " + company.getIncome());


    }
}