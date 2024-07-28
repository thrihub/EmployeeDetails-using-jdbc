package com.mysql.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDetailsUsingJdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/Thriveni";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String sql = "INSERT INTO employees (name, age, department, email, salary) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        
            System.out.println("Enter details for employee " );

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, department);
            statement.setString(4, email);
            statement.setDouble(5, salary);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee inserted successfully!");
            }
        

        statement.close();
        connection.close();
        scanner.close();
    }
}