package wipro;
import java.util.*;
import java.io.*;

public class map_hr {

		public static void main(String []argh)
		{
			Scanner in = new Scanner(System.in);
			int n=in.nextInt();
			in.nextLine();
	        //map
	        HashMap<String, Integer> a1= new HashMap<>();
			for(int i=0;i<n;i++)
			{
				String name=in.nextLine();
				int phone=in.nextInt();
				in.nextLine();
	            a1.put(name, phone);
	            
			}
			while(in.hasNext())
			{
				String s=in.nextLine();
	            if(a1.containsKey(s)){
	                System.out.println(s+"="+a1.get(s));
	            }
	            else{
	                System.out.println("not found");
	            }
			}
	        in.close();
		}
	}





