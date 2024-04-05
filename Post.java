package queuecode;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Comment{
	String createdAt;
	String content;
	
	void newcomment(String content){
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = 
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.createdAt = myDateObj.format(myFormatObj);	
		this.content = content;
	}
}

public class Post {
	String createdBy;
	String createdAt;
	String lyrics;
	String artist;
	String genre;
	String lang;
	int viewsCount;
	int likesCount;


	// reference follower newly from user graph
	private ArrayList<Comment> userComments = new ArrayList<Comment>();
	private ArrayList<String> likes = new ArrayList<String>();
	private ArrayList<String> seen = new ArrayList<String>();
	
	
	void createPost(String username, String lyrics){
		
		createdBy = username;
		this.lyrics = lyrics;
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = 
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.createdAt = myDateObj.format(myFormatObj);		
	}
	
	void seen(String username) {
		if(!seen.contains(username)) {
			//Insert the artist,genre,lang
			seen.add(username);
			viewsCount++;	
		}		
	}
	
	void liked(String username) {
		if(likes.contains(username)) {
			//Insert the artist,genre,lang
//			likes.remove(likes.indexOf(username));
			likes.add(username);
			likesCount++;	
		}
	}
	
	void comment(String username) {
		Comment c=new Comment();
		Scanner sc=new Scanner(System.in);
		String content = sc.nextLine();
		c.newcomment(content);
		userComments.add(c);
	}
	
	
}
