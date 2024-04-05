package queuecode2;
//import java.nio.file.Files;
//import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;

class Data {
	String us;
	String pwd;
	String bio;
	String[] lang;
	String[] genre;

	Data(String us, String pwd, String bio, String[] lang, String[] genre) {
		this.us = us;
		this.pwd = pwd;
		this.bio = bio;
		lang = new String[3];
		genre = new String[5];
	}
}
public class SignUp {
	static Scanner scanner = new Scanner(System.in);

	public static Signup newuser() {
      
     // Data data = new Data();
      int choice = 0;
      do {
      System.out.print("Enter username: ");
      String username = scanner.nextLine();
      boolean valid = isValidUsername(username);
      
		if(valid) {
			System.out.print("Enter password: ");
			
	        String password = scanner.nextLine();

	        // Validate the password.
	        boolean validPassword = validatePassword(password);

	        // Check if the username and password are valid.
	        if (validPassword) {
	            System.out.println("Authentication successful!");
	            System.out.println("***WELCOME TO MUSICMATCH***");
//	            takeuserchoice();
	            String bio = bioip();
	            String[] lang = lang();
	            String[] genre = genre();
	            Data data = new Data(username, password, bio, lang,genre);
	            
//	            Path fileName = Path.of("C:/Users/Dell/Desktop/Competitions/QueueCode/DSACraft/Userdata.txt");
//
//	    		// Writing into the file
//	    		Files.writeString(fileName, data);
//
//	    		// Reading the content of the file
//	    		String file_content = Files.readString(fileName);
//
//	    		// Printing the content inside the file
//	    		System.out.println(file_content);
	            
	        } else {
	            System.out.println("Authentication failed.");
	        }
	        break;
	        
	        return data;
		}
		else {
			System.out.println("Username invalid!");
			System.out.println("Do you want to try with other username?\nYes = 1\tNo = 0");
			choice = scanner.nextInt();
			scanner.nextLine();
		}
      }while(choice != 0);

  }

	private static String bioip() {
		System.out.println("Enter song lyric which best describes you: ");
		String bio = scanner.nextLine();
//  	System.out.println(bio);
		return bio;
	}

	private static String[] lang() {
		System.out.println("Languages:\n1. English\n2. Hindi\n3. Marathi\n4. Korean\n5. Thai\n6. Other");
		System.out.println("Enter any 2 languages you listen to: ");
		String[] lang = new String[3];
		for (int i = 0; i < 2; i++) {
			lang[i] = scanner.nextLine();
		}

		return lang;
	}

	private static String[] genre() {
		System.out.println("Genre:\n1. Indie\n2. Rock\n3. Hip Hop\n4. Bollywood\n5. Lo-Fi"
				+ "\n6. Electro\n7. New-age\n8. Jazz\n9. Punk\n10. Desi\n11. Kpop\n12. Pop");
		System.out.println("Enter any 5 languages you listen to: ");
		String[] gen = new String[5];
		for (int i = 0; i < 5; i++) {
			gen[i] = scanner.nextLine();
		}
		return gen;
	}

	private static void takeuserchoice() {
		System.out.println("Enter song lyric which best describes you: ");
		String bio = scanner.nextLine();
		System.out.println(bio);

		System.out.println("Languages:\n1. English\n2. Hindi\n3. Marathi\n4. Korean\n5. Thai\n6. Other");
		System.out.println("Enter any 2 languages you listen to: ");
		String[] lang = new String[3];
		for (int i = 0; i < 2; i++) {
			lang[i] = scanner.nextLine();
		}

		System.out.println("Genre:\n1. Indie\n2. Rock\n3. Hip Hop\n4. Bollywood\n5. Lo-Fi"
				+ "\n6. Electro\n7. New-age\n8. Jazz\n9. Punk\n10. Desi\n11. Kpop\n12. Pop");
		System.out.println("Enter any 5 languages you listen to: ");
		String[] gen = new String[5];
		for (int i = 0; i < 5; i++) {
			gen[i] = scanner.nextLine();
		}
		
		//printing
		for (int i = 0; i < 5; i++) {
			if (i < 2) {
				System.out.println(lang[i]);
			}
			System.out.println(gen[i]);
		}

	}

	private static boolean isValidUsername(String name) {

		// Regex to check valid username.
		String regex = "^[A-Za-z]\\w{5,29}$";

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the username is empty
		// return false
		if (name == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given username
		// and regular expression.
		Matcher m = p.matcher(name);

		// Return if the username
		// matched the ReGex
		return m.matches();
	}

	private static boolean validatePassword(String password) {
		// Check if the password is at least 8 characters long.
		if (password.length() < 8) {
			return false;
		}

		// Check if the password contains at least one uppercase letter.
		boolean hasUppercaseLetter = false;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				hasUppercaseLetter = true;
				break;
			}
		}

		if (!hasUppercaseLetter) {
			return false;
		}

		// Check if the password contains at least one lowercase letter.
		boolean hasLowercaseLetter = false;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				hasLowercaseLetter = true;
				break;
			}
		}

		if (!hasLowercaseLetter) {
			return false;
		}

		// Check if the password contains at least one digit.
		boolean hasDigit = false;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				hasDigit = true;
				break;
			}
		}

		if (!hasDigit) {
			return false;
		}

		// Check if the password contains at least one special character.
		boolean hasSpecialCharacter = false;
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				hasSpecialCharacter = true;
				break;
			}
		}

		if (!hasSpecialCharacter) {
			return false;
		}

		// The password is valid.
		return true;
	}
}