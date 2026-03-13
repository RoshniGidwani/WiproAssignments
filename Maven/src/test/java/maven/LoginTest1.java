package maven;
import org.testng.annotations.*;

//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
 
public class LoginTest1
{
 
	@BeforeMethod
	public void setup()
	{
		System.out.println("Browser Launch");
	}
	@Test
	public void testLogin()
	{
		System.out.println("Executing Login Test");
	}
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("close Browser");
	}
	
}
 
 