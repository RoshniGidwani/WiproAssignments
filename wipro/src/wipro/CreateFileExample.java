package wipro;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;


public class CreateFileExample
{
public static void main(String[] args)
{
//try {
//	File file=new File("Tech.txt");
//	
//	
//	if(file.createNewFile())
//{
//	System.out.println("File created Successfully");
//}
//else
//{
//	System.out.println("File alredy exists");
// 
//}
//	
//
//	
//	//write
//	FileWriter wr= new FileWriter("Tech.txt");
//	wr.write("hello");
//	
//	
//	//append
//	File app= new File("Tech.txt");
//	wr.write(" roshni");
//	wr.close();	
//	
//}
try {
	FileReader r= new FileReader("Tech.txt");
    int ch;
    while((ch= r.read()) != -1) {
    	System.out.print((char)ch);
    }
    r.close();
}


catch(IOException e)
{
	e.printStackTrace();
}
}
 
}
 
 