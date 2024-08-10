import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display grade boundaries
        System.out.println("Grade Boundaries:");
        System.out.println("S: 90% and above");
        System.out.println("A: 80% - 89%");
        System.out.println("B: 70% - 79%");
        System.out.println("C: 60% - 69%");
        System.out.println("D: 50% - 59%");
        System.out.println("F: Below 50%");
        System.out.println();

        // Input marks from user with validation
        int numSubjects;
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number of subjects.");
                scanner.next(); // Clear invalid input
            }
        }

        double[] marks = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                if (scanner.hasNextDouble()) {
                    double mark = scanner.nextDouble();
                    if (mark >= 0) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Please enter a non-negative number.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid number for marks.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        // Calculate results
        double totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        char grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static double calculateTotalMarks(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculateAveragePercentage(double totalMarks, int numSubjects) {
        return totalMarks / numSubjects;
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'S';
        } else if (averagePercentage >= 80) {
            return 'A';
        } else if (averagePercentage >= 70) {
            return 'B';
        } else if (averagePercentage >= 60) {
            return 'C';
        } else if (averagePercentage >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
