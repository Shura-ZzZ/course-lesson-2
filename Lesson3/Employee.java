import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee> {

    String name;
    String position;
    String department;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee(String name, String position, String department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }

    @Override
    public int compareTo(Employee o) {
        int positionInt = getImportancePosition();
        int departmentInt = getImportanceDepartment();
        int positionIntOb = o.getImportancePosition();
        int departmentIntOb = o.getImportanceDepartment();

        if (departmentInt == departmentIntOb) {
            if (positionInt == positionIntOb)
                return name.compareTo(o.name);
            return Integer.signum(positionIntOb - positionInt);
        }
        return Integer.signum(departmentIntOb - departmentInt);

    }

    private int getImportancePosition() {
        if (position.equals("руководитель")) return 6;
        if (position.equals("зам. руководителя")) return 5;
        if (position.equals("начальник отдела")) return 4;
        if (position.equals("старший сотрудник")) return 3;
        if (position.equals("сотрудник")) return 2;
        if (position.equals("стажер")) return 1;
        return 0;

    }

    private int getImportanceDepartment() {
        if (department.equals("центральный офис")) return 5;
        if (department.equals("региональный офис")) return 4;
        if (department.equals("областной офис")) return 3;
        if (department.equals("городской офис")) return 2;
        if (department.equals("районный офис")) return 1;
        return 0;

    }

    public static void main(String[] args) {
        List<Employee> l = new ArrayList<>();
        l.add(new Employee("Саша", "сотрудник", "региональный офис"));
        Employee t = new Employee("Саша", "сотрудник", "региональный офис");
        Employee e = new Employee("Катя", "сотрудник", "региональный офис");
        l.add(new Employee("Оля", "зам. руководителя", "городской офис"));
        l.add(new Employee("Сергей", "стажер", "городской офис"));
        l.add(new Employee("Катя", "сотрудник", "региональный офис"));
        l.add(new Employee("Игорь", "руководитель", "региональный офис"));
        Collections.sort(l);
        System.out.println(l);

    }
}

