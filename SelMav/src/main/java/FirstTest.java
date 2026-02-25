
public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebdriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println("Title :" + driver.getTitle());
		driver.quit();

	}

}
