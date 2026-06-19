package com.example.studentdemo;

import java.util.Scanner;
import java.util.List;
public class App {
	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
	    StudentDAO dao = new StudentDAO();

	    while (true) {
	        System.out.println("1. Add Student");
	        System.out.println("2. View Students");
	        System.out.println("3. Update Student");
	        System.out.println("4.Delete Student");
	        System.out.println("5. Exit");
	        System.out.print("Enter Choice:");
	        int ch = sc.nextInt();
	        switch (ch) {

	            case 1: Student s = new Student();
	                System.out.print("Enter Student ID: ");
	                s.setId(sc.nextInt());
	                sc.nextLine();
	                System.out.print("Enter Student Name: ");
	                s.setName(sc.nextLine());
	                System.out.print("Enter Email: ");
	                s.setEmail(sc.nextLine());
	                System.out.print("Enter Course: ");
	                s.setCourse(sc.nextLine());
	                System.out.print("Enter Age: ");
	                s.setAge(sc.nextInt());

	                dao.save(s);
	                System.out.println("Student saved successfully.");
	                break;

	            case 2: List<Student> students = dao.findAll();
	                for (Student st:students) {
	                    System.out.println( st.getId() + " " +st.getName() + " " +st.getEmail() + " " +st.getCourse() + " " +st.getAge());
	                }
	                break;

	            case 3:Student us = new Student();
	                System.out.print("Enter Student ID to update: ");
	                us.setId(sc.nextInt());
	                sc.nextLine();
	                System.out.print("Enter Name: ");
	                us.setName(sc.nextLine());
	                System.out.print("Enter Email: ");
	                us.setEmail(sc.nextLine());
	                System.out.print("Enter Course: ");
	                us.setCourse(sc.nextLine());
	                System.out.print("Enter Age: ");
	                us.setAge(sc.nextInt());

	                dao.update(us);
	                System.out.println("Student updated successfully.");
	                break;
	            case 4:  System.out.print("Enter Student ID to delete: ");
	            		int did=sc.nextInt();
	            		dao.delete(did);
	            		break;
	            case 5: System.out.println("Exiting");
	                sc.close();
	                return;

	            default:
	                System.out.println("Invalid choice");
	        }
	    }
	}
}