class Employee 
{
    // Attributes
    private String name;
    private int id;
    private double basicSalary;
    private double hra;
    private double allowances;
    private double grossSalary;

    // Constructor
    public Employee(String name, int id, double basicSalary, double hra, double allowances) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.allowances = allowances;
    }

    // Method to calculate gross salary
    public void calculateGrossSalary() {
        grossSalary = basicSalary + hra + allowances;
    }

    // Method to apply a bonus
    public void applyBonus(double bonus) {
        grossSalary += bonus;
    }

    // Method to display salary details
    public void displaySalaryDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("--------------------------------");
    }
}

class EmployeeSalaryManagement 
{
    public static void main(String[] args) 
    {
        Employee emp1 = new Employee("Umer", 101, 30000, 5000, 2000);
        Employee emp2 = new Employee("Ahmed", 102, 40000, 6000, 3000);
        Employee emp3 = new Employee("Zaid", 103, 50000, 8000, 4000);

        // Calculate gross salary for each employee
        emp1.calculateGrossSalary();
        emp2.calculateGrossSalary();
        emp3.calculateGrossSalary();

        // Apply bonus
        emp1.applyBonus(2000);
        emp2.applyBonus(3000);
        emp3.applyBonus(4000);

        // Display updated salary details
        System.out.println("Employee Salary Details:");
        emp1.displaySalaryDetails();
        emp2.displaySalaryDetails();
        emp3.displaySalaryDetails();
    }
}
