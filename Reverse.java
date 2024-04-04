package string;
import java.util.Scanner;

public class Reverse 
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a String: \n");
		String s1=input.nextLine();
		int len=s1.length();
		for(int i=len-1; i>-1;i--)
		{
			System.out.print(s1.charAt(i));
		}
		input.close();
	}
}
