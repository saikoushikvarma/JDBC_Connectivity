package org.example;

public class Student {
    int RollNo;
    String Name;

    Student(int rollNo){
        this.RollNo = rollNo;
    }

    Student(String name){
        this.Name = name;
    }

    Student(int rollNo, String name){
        this.RollNo = rollNo;
        this.Name = name;
    }
}
