package wipro;
import java.util.Scanner;
import java.util.InputMismatchException;

public class exception_uc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int orgPin = 1234;
		while(true) {
			
		try {		
			System.out.println("Enter your Pin :");
			int pin = sc.nextInt();
		  if(pin == orgPin) {		  
			  System.out.println("Pin Got Matched ");
			  break;
		  }else {
			  System.out.println("Wrong Pin ");		  
		  }
		}catch(InputMismatchException e) {
			System.out.println("Wrong Input  Please try Again" + e);
			sc.next();
		}
		finally{
			System.out.println("Logged Completed");
			
		}

		}}}
