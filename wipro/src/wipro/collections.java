package wipro;
import java.util.*;

public class collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     Scanner sc= new Scanner(System.in);
	     //no. of elements
	     int elements=sc.nextInt();
	     
	     //list me dalte hai
	     ArrayList<Integer> a1= new ArrayList<>();
	     for(int i=0; i<elements; i++) {
	    	 a1.add(sc.nextInt());
	     }
	     
	     System.out.println(a1);
	     
	     //no. of queries
	     int q = sc.nextInt();

	        // Process queries
	        for (int i = 0; i < q; i++) {
	            String operation = sc.next();

	            if (operation.equals("Insert")) {
	                int index = sc.nextInt();
	                int value = sc.nextInt();
	                a1.add(index, value);
	            } 
	            else if (operation.equals("Delete")) {
	                int index = sc.nextInt();
	                a1.remove(index);
	            }
	        }

	        
	        for (int num : a1) {
	            System.out.print(num + " ");
	        }


	}

}
