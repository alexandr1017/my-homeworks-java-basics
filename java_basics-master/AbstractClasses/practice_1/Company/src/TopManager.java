public class TopManager implements Employee{


    public static final int MIN_INCOME = 10_000_000;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return company.getIncome() > MIN_INCOME ?
                (company.fixTopManagerSalary * company.bonusTopManagerCoefficient) : company.fixTopManagerSalary;
    }
    public int compareTo(Employee e) {
        return Double.compare(this.getMonthSalary(), e.getMonthSalary());
    }
    public String toString() {
        return "Топ-Менеджер с зарплатой " + getMonthSalary() + " руб.";
    }
}
