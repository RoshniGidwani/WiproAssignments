package wipro;

enum Status
{
	SUCCESS(200),
	ERROR(500);
	
	private final int code;
	Status(int code)
	{
		this.code=code;
	}
	public int getCode()
	{
		return code;
	}
}

public class enum_eg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Status status= Status.SUCCESS;
		
		System.out.println(status);
		System.out.println(status.getCode());
		
		

	}

}
