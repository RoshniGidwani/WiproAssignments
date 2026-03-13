package wipro;
import java.util.Scanner;
public class weatheranalyser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the temperature");
		float temp=sc.nextFloat();
		System.out.println("enter the city");
		sc.nextLine();
		String city=sc.nextLine();
		
		if(temp>30) {
			System.out.println("city: "+city);
			System.out.println("temperature: "+temp);
			System.out.println("condition: hot day");
		}
		else {
			System.out.println("city: "+city);
			System.out.println("temperature: "+temp);
			System.out.println("condition: normal day");
		}

	}

}
