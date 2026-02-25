package wipro;

public class ques6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String input = "java";
	        String reversed = "";

	        for (int i = input.length() - 1; i >= 0; i--) {
	            reversed = reversed + input.charAt(i);
	        }

	        System.out.println( reversed);
	}

}
