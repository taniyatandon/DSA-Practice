// Demonstrates Abstraction, Encapsulation, Inheritance, and Polymorphism.

abstract class Employee {
    private String name; // Encapsulation

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstraction
    public abstract double calculateSalary();

    public void display() {
        System.out.println("Employee: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

class Developer extends Employee {
    private double monthlySalary;

    public Developer(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class Intern extends Employee {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculateSalary() {
        return stipend;
    }
}

public class AllOOPPrinciples {
    public static void main(String[] args) {
        // Polymorphism: parent reference refers to different child objects.
        Employee e1 = new Developer("Taniya", 50000);
        Employee e2 = new Intern("Student", 15000);

        e1.display();
        e2.display();
    }
}
