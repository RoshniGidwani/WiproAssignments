//Problem:
//You are given an ArrayList<Integer>.
//Write a program to count the frequency of each element.
//
//Example:
//Input: [1, 2, 2, 3, 1, 4, 2]
//Output:
//1 → 2 times
//2 → 3 times
//3 → 1 time
//4 → 1 time


package wipro;
import java.util.ArrayList;

public class prob9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             ArrayList<Integer> a1= new ArrayList<>();
             a1.add(1);
             a1.add(2);
             a1.add(2);
             a1.add(3);
             a1.add(1);
             a1.add(4);
             a1.add(2);
             
             int one=0;
             int two =0;
             int three=0;
             int four=0;
             
             for ( int i=0; i<a1.size(); i++) {
            	 if(a1.get(i)==1) {
            		 one++;
            	 }
            	 if(a1.get(i)==2) {
            		 two++;
       
            	 }
            	 if(a1.get(i)==3) {
            		 three++;
            		 
            	 }
            	 if(a1.get(i)==4) {
            		 four++;
            		 
            	 }
             }
             
             System.out.println("1 "+ one+ " time");
             System.out.println("2 "+ two+ " time");
             System.out.println("3 "+ three+ " time");
             System.out.println("4 "+ four+ " time");
             
	}

}
