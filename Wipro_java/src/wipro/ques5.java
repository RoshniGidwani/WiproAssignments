package wipro;

public class ques5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="hello world";
		int count=0;
		for(int i=0; i<a.length(); i++) {
			char ch= a.charAt(i);
			if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
				count++;
			}
					
		}
		System.out.println(count);

	}
}
