import java.util.Scanner;

public class MarksCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt for the number of subjects
        System.out.print("How many subjects do you have? ");
        int subjectsCount = input.nextInt();

        // Initialize variables to store total marks
        int sumOfMarks = 0;

        // Input marks for all subjects
        System.out.println("Please enter the marks for each subject (out of 100):");
        for (int i = 1; i <= subjectsCount; i++) {
            System.out.print("Marks for Subject " + i + ": ");
            int marks = input.nextInt();
            sumOfMarks += marks; // Add to total marks
        }

        // Calculate the average percentage
        double percentage = (double) sumOfMarks / subjectsCount;

        // Decide the grade based on the percentage
        char resultGrade;
        if (percentage >= 90) {
            resultGrade = 'A';
        } else if (percentage >= 80) {
            resultGrade = 'B';
        } else if (percentage >= 70) {
            resultGrade = 'C';
        } else if (percentage >= 60) {
            resultGrade = 'D';
        } else {
            resultGrade = 'F';
        }

        // Display the results
        System.out.println("\n===== Final Results =====");
        System.out.println("Total Marks Obtained: " + sumOfMarks);
        System.out.println("Overall Percentage: " + percentage + "%");
        System.out.println("Final Grade: " + resultGrade);

        input.close();
    }
}
