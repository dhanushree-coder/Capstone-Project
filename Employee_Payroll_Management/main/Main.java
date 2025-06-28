
package main;

import model.Employee;


import model.Payroll;
import dao.EmployeeDAO;
import service.PayrollService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Generate Payroll\n4. Update Employee\n5. Delete Employee\n6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                Employee e = new Employee();
                System.out.print("Name: ");
                sc.nextLine();
                e.name = sc.nextLine();
                System.out.print("Email: ");
                e.email = sc.nextLine();
                System.out.print("Designation: ");
                e.designation = sc.nextLine();
                System.out.print("Type (FullTime/PartTime): ");
                e.type = sc.nextLine();
                System.out.print("Basic Salary: ");
                e.basicSalary = sc.nextDouble();
                EmployeeDAO.addEmployee(e);

            } else if (choice == 2) {
                ArrayList<Employee> list = EmployeeDAO.getAllEmployees();
                for (Employee e : list) {
                    System.out.println(e.id + " | " + e.name + " | " + e.designation + " | " + e.type + " | " + e.basicSalary);
                }

            } else if (choice == 3) {
                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                ArrayList<Employee> list = EmployeeDAO.getAllEmployees();
                for (Employee e : list) {
                    if (e.id == id) {
                        Payroll p = PayrollService.generatePayroll(e);
                    }
                }

            } else if (choice == 4) {
                System.out.print("Enter Employee ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                Employee e = new Employee();
                e.id = id;
                System.out.print("New Name: ");
                e.name = sc.nextLine();
                System.out.print("New Email: ");
                e.email = sc.nextLine();
                System.out.print("New Designation: ");
                e.designation = sc.nextLine();
                System.out.print("New Type (FullTime/PartTime): ");
                e.type = sc.nextLine();
                System.out.print("New Basic Salary: ");
                e.basicSalary = sc.nextDouble();
                EmployeeDAO.updateEmployee(e);

            } else if (choice == 5) {
                System.out.print("Enter Employee ID to delete: ");
                int id = sc.nextInt();
                EmployeeDAO.deleteEmployee(id);

            } else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }
}
