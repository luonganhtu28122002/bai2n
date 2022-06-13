package com.example;

import com.example.entity.Student;
import com.google.gson.Gson;
import filedemo.Employee;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StudentList<A extends AbstractList<E>> {
    private ArrayList<Student> list = new ArrayList<Student>();

    private int length;

    public StudentList(){
        list.add(new Student(1,"Nguyen","Hoang",9.1)) ;
        list.add(new Student(2,"Nguyen","Duc",8.1)) ;
        list.add(new Student(3,"Vu","Hoang",8.8)) ;
        list.add(new Student(4,"Nguyen","Phuc",9.2)) ;
        list.add(new Student(5,"Nguyen","Tuyen",7.1)) ;
        list.add(new Student(6,"Nguyen","Anh",8.9)) ;
        list.add(new Student(7,"Nguyen","Hai",8.4)) ;
        list.add(new Student(8,"Tran","Hoang",7.1)) ;
        list.add(new Student(9,"Le","Tu",8.6)) ;
        list.add(new Student(10,"Nguyen","Hoa",8.7)) ;
        list.add(new Student(11,"Nguyen","Ly",8.4)) ;
        list.add(new Student(12,"Nguyen","Hoang1",8.1)) ;
    }
    public void getEmployee() throws IOException{
        Gson gson= new Gson() ;
        FileReader reader = new FileReader("employee.json");
        Employee[] Student;
        Student = gson.fromJson(reader, new StudentList<ArrayList<Student>>() {}.getType());
        for (Employee c : Student){
            System.out.println(c);
        }
        reader.close();
    }
    public ArrayList<Student> findByName(String name){
        boolean found = false;
        ArrayList<Student> matches = new ArrayList<>();
        for(Student s :list){
            String fullName = new String(s.getFirstName() + "" + s.getLastName()).toLowerCase();
            if(fullName.matches("(.*)" + name.toLowerCase()+ "(.*)")){
                matches.add(s);
                found = true;
            }
        }
        if (found == false){
            System.out.println(" Not found");
        }
        return matches;
    }
    public Student findById(int id){
        for (Student s : list){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public void add(Student s) { list.add(s);}
    public void remove(int id){
        boolean found = false;
        for (Student s: list){
            if(s.getId()==id){
                int choice;
                System.out.println("Are you sure deleting this student? (1.Yes 2.No)");
                choice = new Scanner(System.in).nextInt();
                if(choice == 1)
                    list.remove(s);
                found = true;
            }
        }
        if(found == false){
            System.out.println("Can not find student with id"+ id);
        }
    }
    public void sortByMarks(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) { return new Double(s2.getMark()).compareTo(s1.getMark());}
        });
    }
    public void showList(){
        for(Student s: list){
            s.printInfo();
        }
    }
    public void showList(ArrayList<Student> slist){
        for(Student s:slist){
            s.printInfo();
        }
    }


}
