import java.util.*;

public class Company {


    private double income;
    protected double bonusTopManagerCoefficient;
    protected double fixTopManagerSalary;
    protected double fixOperatorSalary;
    protected double bonusOfSalesManagerCoefficient;
    protected double fixManagerSalary;


    private final ArrayList<Employee> listOfEmployee = new ArrayList<>();


    public Company(
            double fixOperatorSalary,
            double fixTopManagerSalary,
            double fixManagerSalary,
            double bonusTopManagerCoefficient,
            double bonusOfSalesManagerCoefficient
    ) {
        this.bonusTopManagerCoefficient = bonusTopManagerCoefficient;
        this.fixOperatorSalary = fixOperatorSalary;
        this.fixTopManagerSalary = fixTopManagerSalary;
        this.fixManagerSalary = fixManagerSalary;
        this.bonusOfSalesManagerCoefficient = bonusOfSalesManagerCoefficient;
    }


    public void hire(Employee employee) {
        listOfEmployee.add(employee);
    }

    public void hireAll(Collection<Employee> employes) {
        listOfEmployee.addAll(employes);

    }

    public void fire(Employee employee) {
        listOfEmployee.remove(employee);
        incomeCalculate();

    }

    public void fireOfPercent(int percent) {
        ListIterator<Employee> iterator = listOfEmployee.listIterator();
        int convertCount = listOfEmployee.size() * percent / 100;
        int i = 0;
        while (i < convertCount) {
            iterator.next();
            iterator.remove();
            i++;
        }
        incomeCalculate();
    }


    private double incomeCalculate() {
        income = 0;
        for (Employee employee : listOfEmployee) {
            if (employee instanceof Manager) {
                income += ((Manager) employee).getIncomeOfSales();
            }
        }
        return income;
    }

    public int getCountEmployee() {
        return listOfEmployee.size();
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(listOfEmployee);
        return getListOfCount(count);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(listOfEmployee, Collections.reverseOrder());
        return getListOfCount(count);
    }

    private List<Employee> getListOfCount(int count) {
        if (count <= 0) {
            System.out.println("Ошибка. Передано неверное значенине");
            return Collections.EMPTY_LIST;
        }

        if (count >= listOfEmployee.size()) {
            count = listOfEmployee.size();
        }

        ArrayList<Employee> sortedList = new ArrayList<>();

        for (int i = 0; i <= count; i++) {
            sortedList.add(listOfEmployee.get(i));
        }
        return sortedList;
    }

    public long getIncome() {
        incomeCalculate();
        return (long) income;
    }


    public void printTopSalary(int count) {
        System.out.println("Самые высокие зарплаты в компании:");
        print(getTopSalaryStaff(count));
    }

    public void printLowestSalary(int count) {
        System.out.println("Самые низкие зарплаты в компании:");
        print(getLowestSalaryStaff(count));
    }

    private void print(List<Employee> list) {
        for (Employee e : list) {
            System.out.println(e);
        }
    }


    public double getBonusTopManagerCoefficient() {
        return bonusTopManagerCoefficient;
    }

    public double getFixTopManagerSalary() {
        return fixTopManagerSalary;
    }

    public double getFixOperatorSalary() {
        return fixOperatorSalary;
    }

    public double getBonusOfSalesManagerCoefficient() {
        return bonusOfSalesManagerCoefficient;
    }

    public double getFixManagerSalary() {
        return fixManagerSalary;
    }

    public ArrayList<Employee> getListOfEmployee() {
        return new ArrayList<>(listOfEmployee);
    }

}
