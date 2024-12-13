import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        createStudentsList(students);
        printStudents(students);
        checkStudents(students);
        printStudents(students);
    }

    public static void createStudentsList(List<Student> students) {
        int amount;
        do {
            System.out.print("Input amount of students: ");
            Scanner in = new Scanner(System.in);
            amount = in.nextInt();
        } while(amount <= 0);

        String[] names = new String[]{"Alice", "Don", "Robin", "William", "Maria", "Anna", "John", "Jack", "Andrea"};
        String[] groups = new String[]{"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};

        for(int i = 0; i < amount; ++i) {
            Random rand = new Random();
            String name = names[rand.nextInt(8)];
            String group = groups[rand.nextInt(8)];
            students.add(new Student(name, group, rand.nextInt(5) + 1, List.of(rand.nextInt(6) + 1, rand.nextInt(6) + 1, rand.nextInt(6) + 1)));
        }

    }

    public static void printStudents(List<Student> students) {
        System.out.print("\nList of students:\n");

        for(Student student : students) {
            student.print();
        }

    }

    public static void checkStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while(iterator.hasNext()) {
            Student student = (Student)iterator.next();
            if (student.getAverageGrade() < 3.0F) {
                iterator.remove();
            } else {
                student.promote();
            }
        }

    }
}
