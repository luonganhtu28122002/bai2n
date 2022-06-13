package com.example;


import com.example.entity.Student;
import com.example.model.StudentList;

import java.io.IOException;
import java.util.*;


public class Application {
    private static Scanner input = new Scanner(System.in);
    private static StudentList<AbstractList<E>> list;

    private static void menu(){
        System.out.println("1. Add a new student to the list");
        System.out.println("2. Delete a student from the list");
        System.out.println("3. Search by name");
        System.out.println("4. Search by id");
        System.out.println("5.Print student info in descending order of mark");
        System.out.println("6. Exit");
    }
    public static void main(String[] args) throws IOException{
        list=new StudentList<AbstractList<E>>();
        menu();
        while (true){
            int choice;
            System.out.println("#: ");
            choice=input.nextInt();
            if(choice==1){
                addStudent();
                menu();
            } else if (choice ==2 ) {
                deleteStudent();
                menu();
            } else if (choice ==3) {
                searchByName();
                menu();
            } else if (choice == 4) {
                searchById();
                menu();
            } else if (choice ==5) {
                printSorted();
                menu();
            } else if (choice ==6) {
                System.exit(0);
            }
        }
    }
    public static void addStudent(){
        int id=0;
        String fn;
        String ln;
        double mark;
        System.out.println("Enter student ID: ");
        id = input.nextInt();
        System.out.println("Enter first name: ");
        fn = input.next();
        System.out.println("Enter last name: ");
        ln = input.next();
        System.out.println("Enter mark: ");
        mark= input.nextDouble();
        Student s=new Student(id,fn,ln,mark);
        list.add(s);
    }
    public static void deleteStudent(){
        int id;
        System.out.println("Enter student id: ");
        id = input.nextInt();
        list.remove(id);
    }
    public static void searchByName(){
        String name;
        System.out.println("Enter a name: ");
        name= input.next();
        ArrayList<Student> found = list.findByName(name);
        list.showList();
    }
    public static void searchById(){
        int id;
        System.out.println("Enter an ID: ");
        id= input.nextInt();
        Student s = list.findById(id);
        if(s==null){
            System.out.println("Not found");
        }else {
            s.printInfo();
        }
    }

    /* public static void gsonStudentManager() throws IOException{
         List<Student> students = (List<Student>) Arrays.asList(
                 new Student(1,"Nguyen","Hoang",9.1),
                 new Student(2,"Nguyen","Duc",8.1),
                 new Student(3,"Vu","Hoang",8.8),
                 new Student(4,"Nguyen","Phuc",9.2),
                 new Student(5,"Nguyen","Tuyen",7.1)
         );
         Writer writer = new FileWriter("students.json");
         Gson gson = new Gson();
         gson.toJson(students,writer);
         writer.close();
     }
     public static void mains(String[] args) throws IOException{
         gsonStudentManager();
     }*/
    public static void printSorted(){
        list.sortByMarks();

        list.showList();
    }

}
