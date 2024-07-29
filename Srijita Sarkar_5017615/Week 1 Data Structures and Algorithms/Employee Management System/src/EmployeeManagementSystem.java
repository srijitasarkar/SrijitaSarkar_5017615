class Employee {
    private final String employeeId;
    private final String name;
    private final String position;
    private final double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

class EmployeeManager {
    private final Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added: " + employee);
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    // Method to search for an employee by employeeId
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Method to traverse (print) all employees
    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    // Method to delete an employee by employeeId
    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
            System.out.println("Employee with ID " + employeeId + " deleted.");
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        Employee employee1 = new Employee("E001", "Alex", "Manager", 85000);
        Employee employee2 = new Employee("E002", "Kyle", "Developer", 75000);
        Employee employee3 = new Employee("E003", "Donald", "Analyst", 60000);

        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);

        System.out.println("\nTraversing Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee E002:");
        Employee searchResult = manager.searchEmployee("E002");
        if (searchResult != null) {
            System.out.println("Employee found: " + searchResult);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee E002:");
        manager.deleteEmployee("E002");

        System.out.println("\nTraversing Employees:");
        manager.traverseEmployees();
    }
}