package jdk8.functional.design.dayOne;

import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private double gpa;
    private List<String> courses;
    private Student() {
    }

    public static Student of(String n, double g, String... c) {
        Student s = new Student();
        s.name = n;
        s.gpa =g;
        s.courses = Arrays.asList(c);
        return s;
    }
}
