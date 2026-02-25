package wipro;
import java.util.*;

public class SmartHomeTemperatureApp {
	 
	public static void main(String[] args)
	{
		// Store room temperature(sensor gives double)
ArrayList<Double>temperature = new ArrayList();
 
//Autoboxing: double->Double
temperature.add(26.8);
temperature.add(30.2);
temperature.add(22.8);
temperature.add(29.8);
 
 
// Analyzer temperatures(Unboxing)
System.out.println("Temperature Analysis");
 
for(Double temp:temperature)
{
	if(temp>28.0)					//Unboxing:Double->double
	{
	System.out.println("High temperature alert: " + temp + "celsius");	
	}
	else
	{
		System.out.println("Normal temperature: " + temp + "Celsius");
	}
}
//Convert temerature values to string
System.out.println("\n Temperature Values as String:");
for(Double temp: temperature)
{
	String value=Double.toString(temp);      //Wrapper method
	System.out.println(value);
}
}
}
 
