package string;
import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		Scanner ch=new Scanner(System.in);
		Scanner ch1=new Scanner(System.in);
		int choice_1;
		System.out.println("Welcome to string operations!");

		do
		{
			int choice;
			String s2,s1;
			System.out.println("Enter a String: \n");
			s1=input.nextLine();
			int len=s1.length();			
			do
			{				
				System.out.println("\nChoose the options:\n 1.Print the String\n 2.Find the length of the string\n 3.Concatenate with another string\n 4.Reverse the string\n 5.Compare the string\n 6.Print 1st and last Characters\n 7.Print the characters in between\n 8.Print uppercase letters\n 9.Print the Initials\n 0.Terminate operations with this string ");
				choice=ch1.nextInt();
				switch(choice)
				{
				case 1:
				System.out.println(s1);
				break;
				
				case 2:
				
				System.out.println("length of the string is "+len);
				break;
				
				case 3:
					System.out.println("Enter another String:");
					s2=ch.nextLine();
					System.out.println("The concatenated string is "+s1+" "+s2);
					break;
					
				case 4:
					for(int i=len-1; i>-1;i--)
					{
						System.out.print(s1.charAt(i));
					}
					break;
					
				case 5:
					System.out.println("Enter String to be compared:");
					String s4=ch.nextLine();
					int len4=s4.length();
					boolean flag=false;
					if(len==len4)
					{
						int j=0,k;
						for(k=0; k<len;k++)
						{
							if(s1.charAt(k)==s4.charAt(k))
							{
								j=j+1;
							}
						}
						if (j==len)
						{
							flag=true;
						}
						
					}
					
					if(!flag)
						System.out.println("The strings are different");
					else
						System.out.println("The strings are same");
					break;
					

				case 6:
					len=s1.length();
					System.out.println("The 1st and the last alphabets of the string are: " +s1.charAt(0)+" and "+s1.charAt(len-1));
					break;
					
				case 7:
					len=s1.length();
					if(len>2)
						System.out.println("The substring is "+s1.substring(1,len-1));
					else
						System.out.println("String is too short");
					break;
				
				case 8:
					int a;
					int b=0;
					len=s1.length();
					System.out.print("Following are the uppercase characters:");
					for(a=0;a<len;a++)
					{
						if (Character.isUpperCase(s1.charAt(a)))
								{
							System.out.print(s1.charAt(a)+" ");
							b+=b;
								}
					}
					if (b==0)
						System.out.print(" None");
					break;
				
				case 9:
					System.out.print("The initials are: ");
					System.out.print(s1.charAt(0));
					for(int c=0; c<len; c++)
					{
						if(s1.charAt(c)==' ')
						{
							System.out.print(s1.charAt(c+1));
						}
					}
					
				case 0:
					break;
				
				default:
					System.out.println("Enter Valid input");
					break;
				}
				
			}
			while(choice!=0);
			System.out.println("Do you wish to continue with a new String?\n If yes, press 1\n If no, press any other number");
			choice_1=ch1.nextInt();
			
			}
		while(choice_1==1);
		input.close();
		ch.close();
		ch1.close();
	}

}
