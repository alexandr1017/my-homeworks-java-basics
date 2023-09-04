
public class Manager implements Employee {


    private double incomeOfSales;
    protected Company company;

    public Manager(Company company) {
        this.company = company;
        incomeOfSales = incomeGenerator();
    }

    @Override
    public double getMonthSalary() {
        return Math.round((company.bonusOfSalesManagerCoefficient * incomeOfSales + company.fixManagerSalary) * 100.0) / 100.0;
    }
    public double getIncomeOfSales() {
        return incomeOfSales;
    }

    private double incomeGenerator() {
        return (int) (Math.random() * (140000 - 115000 + 1) + 115000);
    }


    @Override
    public int compareTo(Employee e) {
        return Double.compare(this.getMonthSalary(), e.getMonthSalary());
    }

    @Override
    public String toString() {
        return "Менеджер с зарплатой " + getMonthSalary() + " руб.";
    }
}
