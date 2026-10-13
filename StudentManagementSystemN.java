import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Student> al = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== Student Management System ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You...!!!!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Add Student
    public static void addStudent() {

        System.out.print("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, age, marks);
        al.add(s);

        System.out.println("Student added successfully");
    }

    // Display Students
    public static void displayStudents() {

        if (al.isEmpty()) {
            System.out.println("No student found!");
            return;
        }

        for (Student s : al) {
            s.display();
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.print("Enter Student Id: ");
        int id = sc.nextInt();

        for (Student s : al) {

            if (s.getId() == id) {
                s.display();
                return;
            }
        }

        System.out.println("Student not found");
    }

    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Student Id: ");
        int id = sc.nextInt();

        for (Student s : al) {

            if (s.getId() == id) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new age: ");
                int age = sc.nextInt();

                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setAge(age);
                s.setMarks(marks);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Student Id: ");
        int id = sc.nextInt();

        for (int i = 0; i < al.size(); i++) {

            if (al.get(i).getId() == id) {

                al.remove(i);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}


// Student Class
class Student {

    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void display() {

        System.out.println("-----------------------------");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Marks      : " + marks);
        System.out.println("-----------------------------");
    }
}