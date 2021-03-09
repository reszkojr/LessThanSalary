package main;

public class Employee {

    String name;
    String email;
    double salary;

    public Employee(String n, String e, double s) {
        name = n;
        email = e;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + " Email: " + email + " Salary: " + String.format("%.2f", salary);
    }
}
