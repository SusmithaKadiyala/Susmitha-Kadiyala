import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCourseInfo() {
        return courseCode + ": " + title + " - " + description + " (" + schedule + ")";
    }
}

class Student {
    String studentID;
    String name;
    List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.capacity > 0) {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println(name + " has successfully registered for " + course.title);
        } else {
            System.out.println("Sorry, " + course.title + " is already full. Unable to register.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.capacity++;
            System.out.println(name + " has successfully dropped " + course.title);
        } else {
            System.out.println(name + " is not registered for " + course.title);
        }
    }

    public void displayRegisteredCourses() {
        System.out.println(name + "'s Registered Courses:");
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course course : registeredCourses) {
                System.out.println("- " + course.getCourseInfo());
            }
        }
    }
}

class CourseRegistrationSystem {
    List<Course> courses;
    List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void displayCourseListing() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseInfo() + " (Available Slots: " + course.capacity + ")");
        }
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void registerStudent(Student student) {
        students.add(student);
    }
}

public class CourseRegistrationApp {
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        Course mathCourse = new Course("MATH101", "Introduction to Calculus", "Basic calculus concepts", 30, "Mon/Wed/Fri 10:00 AM");
        Course historyCourse = new Course("HIST201", "World History", "Overview of world history", 25, "Tue/Thu 2:00 PM");

        system.addCourse(mathCourse);
        system.addCourse(historyCourse);

        Student student1 = new Student("1001", "James");
        Student student2 = new Student("1002", "Bheem");

        system.registerStudent(student1);
        system.registerStudent(student2);

        // Display available courses
        system.displayCourseListing();

        // Register students for courses
        student1.registerCourse(mathCourse);
        student2.registerCourse(historyCourse);

        // Display registered courses for each student
        student1.displayRegisteredCourses();
        student2.displayRegisteredCourses();

        // Drop a course
        student1.dropCourse(mathCourse);

        // Display updated registered courses and available slots
        student1.displayRegisteredCourses();
        system.displayCourseListing();
    }
}
