package seleniumTestNG;

import org.testng.annotations.Test;
public class TestClass {
	
		@Test
		public void test1()
		{
			System.out.println("Test1 - " + Thread.currentThread());	
		}
		@Test
		public void test2()
		{
			System.out.println("Test2 - " + Thread.currentThread());	
		}
		@Test
		public void test3()
		{
			System.out.println("Test3 - " + Thread.currentThread());	
		}
	}


