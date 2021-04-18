package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static Lesson9.Student.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Natalia",
                  Arrays.asList(
                          new Course("Finnish"),
                          new Course("English"),
                          new Course("Swedish"),
                          new Course("History"),
                          new Course("Philosophy")
                  )),
                new Student("Artem",
                        Arrays.asList(
                                new Course("Psychology"),
                                new Course("English"),
                                new Course("History"),
                                new Course("Philosophy")
                        )),
                new Student("Anna",
                        Arrays.asList(
                                new Course("China"),
                                new Course("History"),
                                new Course("Philosophy")
                        )),
                new Student("Valentina",
                        Arrays.asList(
                                new Course("History"),
                                new Course("Philosophy")
                        ))
                );
        Course english = new Course("English");

        System.out.println("Список уникальных курсов: " + getUniqueCourses(students));
        System.out.println("Список трёх самых любознательных студентов: "
                + getListOfThirstyForKnowledgeStudent(students, 3));
        System.out.println("Список студентов, посещающих курс \"English\": "
                + getListOfStudentVisitingCourse(students, english));
    }
}

//Имеется следующая структура:
//interface Student {
//String getName();
//List<Course> getAllCourses();
//}
//interface Course {}

//1.Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
//2.Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
// (любознательность определяется количеством курсов).
//3.Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
// которые посещают этот курс.