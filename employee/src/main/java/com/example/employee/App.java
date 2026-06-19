package com.example.employee;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int ch;

        do {
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    float salary = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("Enter Joining Date (YYYY-MM-DD): ");
                    String joiningDate = sc.nextLine();

                    Employee emp = new Employee(eid, name, dept, salary, joiningDate);
                    dao.save(emp);

                    System.out.println("Employee Added");
                    break;

                case 2:
                    List<Employee> employees = dao.findAll();

                    if (employees.isEmpty()) {
                        System.out.println("No Employees Found.");
                    } else {
                        System.out.println("\n===== Employee List =====");

                        for (Employee e : employees) {
                            System.out.println(
                                    e.getId() + " | " +
                                    e.getName() + " | " +
                                    e.getdept() + " | " +
                                    e.getsalary() + " | " +
                                    e.getjoiningDate()
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();

                    Employee employee = dao.findById(searchId);

                    if (employee != null) {
                        System.out.println("ID: " + employee.getId());
                        System.out.println("Name: " + employee.getName());
                        System.out.println("Department: " + employee.getdept());
                        System.out.println("Salary: " + employee.getsalary());
                        System.out.println("Joining Date: " + employee.getjoiningDate());
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();

                    Employee ue = dao.findById(updateId);

                    if (ue != null) {
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        ue.setName(sc.nextLine());

                        System.out.print("Enter New Department: ");
                        ue.setdept(sc.nextLine());

                        System.out.print("Enter New Salary: ");
                        ue.setsalary(sc.nextFloat());
                        sc.nextLine(); 

                        System.out.print("Enter New Joining Date (YYYY-MM-DD): ");
                        ue.setjoiningDate(sc.nextLine());

                        dao.update(ue);

                        System.out.println("Employee Updated Successfully!");
                    } else {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    Employee de = dao.findById(deleteId);

                    if (de != null) {
                        dao.delete(deleteId);
                        System.out.println("Employee Deleted Successfully!");
                    } else {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid");
            }

        } while (ch != 6);

        sc.close();
    }
}