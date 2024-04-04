package string;
import java.util.*;

public class Length 
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a String: \n");
		String s1=input.nextLine();
		int len=s1.length();
		System.out.println("lentgth of the string is "+len);
		input.close();
	}
}
