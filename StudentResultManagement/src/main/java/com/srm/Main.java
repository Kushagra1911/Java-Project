package com.srm;

import com.srm.dao.*;
import com.srm.model.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO sdao = new StudentDAO();
        ResultDAO rdao = new ResultDAO();

        while (true) {
            System.out.println("\n===== Student Result Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add Result");
            System.out.println("6. View Results");
            System.out.println("7. Delete Result");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            switch (sc.nextInt()) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    sdao.addStudent(new Student(id, name, course));
                    break;

                case 2:
                    sdao.getAll().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String nm = sc.nextLine();
                    System.out.print("New Course: ");
                    String cs = sc.nextLine();
                    sdao.updateStudent(new Student(uid, nm, cs));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    sdao.deleteStudent(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Result ID: ");
                    int rid = sc.nextInt();
                    System.out.print("Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Marks1: ");
                    int m1 = sc.nextInt();
                    System.out.print("Marks2: ");
                    int m2 = sc.nextInt();
                    System.out.print("Marks3: ");
                    int m3 = sc.nextInt();
                    rdao.addResult(new Result(rid, sid, m1, m2, m3));
                    break;

                case 6:
                    rdao.getAll().forEach(System.out::println);
                    break;

                case 7:
                    System.out.print("Enter Result ID to delete: ");
                    rdao.deleteResult(sc.nextInt());
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
