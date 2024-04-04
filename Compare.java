package string;
import java.util.Scanner;

public class Compare 
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a String: \n");
		String s1=input.nextLine();
		int len=s1.length();
		System.out.println("Enter String to be compared: \n");
		String s2=input.nextLine();
		int len2=s2.length();
		boolean marker=false;
		if(len==len2)
		{
			int j=0;
			for(int i=0; i<len;i++)
			{
				if(s1.charAt(i)==s2.charAt(i))
				{
					j=j+1;
				}
			}
			if (j==len)
			{
				marker=true;
			}
			
		}
		
		if(!marker)
			System.out.println("The strings are different");
		else
			System.out.println("The strings are same");
		input.close();

	}

}
