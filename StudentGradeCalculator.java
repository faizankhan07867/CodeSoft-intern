import java.util.Scanner;
import java.text.DecimalFormat;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("=== Student Grade Calculator ===");
        System.out.print("Enter number of subjects: ");
        int n;
        while (!sc.hasNextInt()) { System.out.print("Enter a valid integer: "); sc.next(); }
        n = sc.nextInt();
        while (n <= 0) { System.out.print("Must be > 0. Enter again: "); n = sc.nextInt(); }

        double total = 0;
        for (int i = 1; i <= n; i++) {
            int mark;
            do {
                System.out.print("Enter marks for subject " + i + " (0-100): ");
                while (!sc.hasNextInt()) { System.out.print("Enter an integer 0-100: "); sc.next(); }
                mark = sc.nextInt();
            } while (mark < 0 || mark > 100);
            total += mark;
        }

        double average = total / n;
        String grade;
        if (average >= 90) grade = "A+";
        else if (average >= 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + (int) total + " out of " + (100 * n));
        System.out.println("Average: " + df.format(average) + "%");
        System.out.println("Grade: " + grade);
        sc.close();
    }
}