package wipro;

public class ques3_2 {
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int arr[] = {1, 2, 3, 4};
			
			System.out.println("Before Swapping");
			for(int i = 0 ; i<arr.length;i++) {
				System.out.print(arr[i]);
			}
			
			int start = 0;
			int end = arr.length -1;
				while(start<=end) {
					int temp = arr[start];
				    arr[start]= arr[end];
				    arr[end]= temp;
				    start++;
				    end--;
				}	
				
				System.out.println("  ");
			System.out.println("After Swapping");
		for(int i = 0 ; i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		}	
		}
