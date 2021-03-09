package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String userHome = System.getProperty("user.home");
        String path = userHome + "/Desktop/in.csv";
        List<Employee> list = new ArrayList<>();

        try (BufferedReader br =  new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                double salary = Double.parseDouble(fields[2]);
                String email = fields[1];
                list.add(new Employee(name, email, salary));
                line = br.readLine();
            }

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Comparator<String> comp = (s1,s2) -> s1.compareToIgnoreCase(s2);

        List<String> lessThanSalary = list.stream()
                .filter(e -> e.getSalary() > salary)
                .map(e -> e.getName())
                .sorted(comp)
                .collect(Collectors.toList());


        System.out.println("People whose salary is greater than " + salary + ":");
        for (String s : lessThanSalary) {
            System.out.println(s);
        }

        System.out.println("Type a letter:");
        String letterStr = sc.next().toUpperCase();
        char letter = letterStr.charAt(0);

        double letterSum = list.stream()
                .filter(emp -> emp.getName().charAt(0) == letter)
                .map(emp -> emp.getSalary())
                .reduce(0.0, (x,y) -> x + y);

        System.out.println("Sum of salary of people whose name starts with '" + letter + "'");
            System.out.println(letterSum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }
}
