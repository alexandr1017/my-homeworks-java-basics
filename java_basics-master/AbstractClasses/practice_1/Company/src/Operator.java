public class Operator implements Employee {

    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return company.fixOperatorSalary;
    }
    public int compareTo(Employee e) {
        return Double.compare(this.getMonthSalary(), e.getMonthSalary());
    }
    public String toString() {
        return "Оператор с зарплатой " + getMonthSalary() + " руб.";
    }
}
