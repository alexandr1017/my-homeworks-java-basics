import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Поиск сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году ")
public class TestFindEmployeeByHighestSalary {

  @Test
  @DisplayName("Входные данные - staff.txt ")
  void getEmployee() throws ParseException {
    List<Employee> staff = Employee.loadStaffFromFile("data/staff.txt");
    LocalDate date = LocalDate.parse("31.01.2017", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            //(new SimpleDateFormat("dd.MM.yyyy")).parse("31.01.2017");
    Employee expectedEmployee = new Employee("Дмитрий Кочергин", 140000, date);
    Employee actualEmployee = Main.findEmployeeWithHighestSalary(staff, 2017);
    assertEquals(expectedEmployee, actualEmployee);
  }

}
