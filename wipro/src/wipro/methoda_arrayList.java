package wipro;
import java.util.*;
public class methoda_arrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> eg= new ArrayList();
		eg.add(10);
		eg.add(45);
		eg.add(50);
		eg.add(53);
		eg.add(52);
		eg.add(58);
		eg.add(59);
		eg.add(555);
		eg.add(90);
		eg.add(30); //1
		eg.remove(1);//5
		
		
		
		System.out.println(eg); 
		
		System.out.println(eg.get(2)); //2
		
		System.out.println(eg.indexOf(30));//3
		//4
		System.out.println(eg.contains(0));
		System.out.println(eg.contains(90));
		
		//6
		System.out.println(eg.isEmpty() +" 6");
		
		//7
		System.out.println(eg.lastIndexOf(eg));
		

	}

}
