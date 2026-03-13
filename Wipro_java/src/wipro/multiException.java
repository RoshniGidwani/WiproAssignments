package wipro;

public class multiException {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	
		try {
			int arr[]= {10, 20, 30};
			
			System.out.println(arr[5]);
			
			 int num = Integer.parseInt("abc");
			 
			   int a = 10 / 0;
			
			}
			 catch(ArithmeticException e)
			{
			System.out.println(" Arithmetic Exception occurred");
			}
		 
			catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array index out of");
		}
		catch (Exception e)
		{
				System.out.println("Generic Exception");
		}
		}
}

	
