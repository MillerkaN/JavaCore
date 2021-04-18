package Lesson9;

import java.util.List;
import java.util.stream.Collectors;

public class Student {

    private String name;
    private List<Course> courses;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    public static List<Course> getUniqueCourses(List<Student> students){
            List<Course> uniqueCources = students.stream()
                    .map(s -> s.getCourses())
                    .flatMap(c -> c.stream())
                    .distinct()
                    .collect(Collectors.toList());
            return uniqueCources;
    }

    public static List<String> getListOfThirstyForKnowledgeStudent(List<Student> students, int quantity){
        List<String> listOfThirstyForKnowledgeStudent = students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(quantity)
                .map(Student::getName)
                .collect(Collectors.toList());
        return listOfThirstyForKnowledgeStudent;
    }

    public static List<String> getListOfStudentVisitingCourse(List<Student> students, Course course){
        List<String> listOfStudentVisitingCourse = students.stream()
                .filter((s) -> s.getCourses().contains(course))
                .map(Student::getName)
                .collect(Collectors.toList());
        return listOfStudentVisitingCourse;
    }

}
