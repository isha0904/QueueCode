package string;

import java.util.*;

public class Initials {

	public static void main(String[] args)
	{
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a String: \n");
		String s1=input.nextLine();
		int len=s1.length();
		System.out.print(s1.charAt(0));
		for(int c=0; c<len; c++)
		{
			if(s1.charAt(c)==' ')
			{
				System.out.print(s1.charAt(c+1));
			}
		}
		
		input.close();
	}

}
