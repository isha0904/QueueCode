package queuecode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class Main 
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        
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
	            String[] artist= artist();
	            User data = new User(username, password, bio, artist, lang, genre);
	            data.showData();
	            
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
		}
		else {
			System.out.println("Username invalid!");
			System.out.println("Do you want to try with other username?\nYes = 1\tNo = 0");
			choice = scanner.nextInt();
			scanner.nextLine();
		}
        }while(choice != 0);
     // Object of graph is created.
     		

    }

	private static String bioip() {
		System.out.println("Enter song lyric which best describes you: ");
		String bio = scanner.nextLine();
//    	System.out.println(bio);
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
		System.out.println("Enter any 5 genres you listen to: ");
		String[] gen = new String[5];
		for (int i = 0; i < 5; i++) {
			gen[i] = scanner.nextLine();
		}
		return gen;
	}
	
	private static String[] artist() {
		System.out.println("Enter any 3 Artist you listen to: ");
		String[] art = new String[3];
		for (int i = 0; i < 3; i++) {
			art[i] = scanner.nextLine();
		}

		return art;
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
