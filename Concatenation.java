package string;
import java.util.*;

public class Concatenation 
{
	public static void main (String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a String: \n");
		String s1=input.nextLine();
		System.out.println("Enter another String: \n");
		String s2=input.nextLine();
		System.out.println("The concatenated string is "+s1+""+s2);
		input.close();
	}
}
