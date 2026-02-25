package wipro;
import java.util.Scanner;
public class StudentScore {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		System.out.println("enter the student name: ");
		
		String Student= sc.nextLine();
		
		System.out.println("marks in english: ");
		int eng= sc.nextInt();
		System.out.println("marks in maths: ");
		int maths= sc.nextInt();
		char grade;
		 
		int totalMarks= eng+ maths;
		double percentage= (totalMarks/200.0)*100;
		
		if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 75) {
            grade = 'B';
        } else if (percentage >= 50) {
            grade = 'C';
        } else {
            grade = 'F';
        }
		 System.out.println("Student: " + Student);
	        System.out.println("English: " + eng);
	        System.out.println("Maths: " + maths);
	        System.out.println("Total: " + totalMarks);
	        System.out.println("Percentage: " + percentage + "%");
	        System.out.println("Grade: " + grade);

	}

}
