package queuecode;

import java.util.*;

public class User 
{
	String us;
	String pwd;
	String bio;
	String[] artist;
	String[] lang;
	String[] genre;

	User(String us, String pwd, String bio,String[] artist, String[] lang, String[] genre) {
		this.us = us;
		this.pwd = pwd;
		this.bio = bio;
		this.artist=artist;		
		this.lang = lang;
		this.genre= genre;
	}

	public PriorityQueue <Integer> apqueue= new PriorityQueue<Integer>();
	public PriorityQueue <Integer> lpqueue= new PriorityQueue<Integer>();
	public PriorityQueue <Integer> gpqueue= new PriorityQueue<Integer>();
	public PriorityQueue <Integer> lapqueue= new PriorityQueue<Integer>();
	public PriorityQueue <Integer> llpqueue= new PriorityQueue<Integer>();
	public PriorityQueue <Integer> lgpqueue= new PriorityQueue<Integer>();
	public int compareTo(Artist other)
	{
		return other.likecount*2+other.listencount*3+other.commentcount+other.sharecount;
	}
	public int compareTo(Lang other)
	{
		return other.likecount*2+other.listencount*5;
	}
	public int compareTo(Genre other)
	{
		return other.likecount*2+other.listencount*5;
	}
	public void addartist()
	{
		
		for(int i=0; i< artist.length; i++)
		{
			Artist a= new Artist(artist[i], 1,0, 0,0);
			apqueue.add(a.likecount);
			lapqueue.add(a.listencount);
		}
	}
	public void addgenre()
	{
		
		for(int i=0; i< genre.length; i++)
		{
			Genre g= new Genre(genre[i], 1, 0,0,0);
			gpqueue.add(g.likecount);
			lgpqueue.add(g.listencount);
		}
	}
	public void addlang()
	{
		
		for(int i=0; i< lang.length; i++)
		{
			Lang l= new Lang(lang[i], 1, 0,0,0);
			lpqueue.add(l.likecount);
			llpqueue.add(l.listencount);
		}
	}
	public void showData()
	{
		addartist();
		addlang();
		addgenre();
		int artistlikerate=apqueue.poll()/lapqueue.poll();
		int langlikerate=lpqueue.poll()/llpqueue.poll();
		int genrelikerate=gpqueue.poll()/lgpqueue.poll();
		System.out.println("Artist like rate of most listened to artist= "+ artistlikerate);
		System.out.println("Language like rate of most listened to artist= "+ langlikerate);
		System.out.println("Genre like rate of most listened to artist= "+ genrelikerate);
		
		
		
	}
	
	
}
