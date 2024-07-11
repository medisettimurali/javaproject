package musicapp;

import java.util.Scanner;
import musicapp.Node;

public class MusicPlaylist {
	Node head;
	Node tail;
	Node currentSong;
	String[] sName = {"BeastMode","Ninnila","Gundellona","Vellipomakey","Oridevuda","MowaBro","Pillapadeysavey","Orivari"};
	String[] mName = {"Beast","Tholiprema","OriDevuda","Sahasam","VIP","DAMKI","LoveToday","Dasara"};
	Integer[] year = {2020,2018,2022,2017,2020,2022,2023,2023};
	public void defaultSongs() {
		for(int i=0;i<8;i++) {
			Node node = new Node(sName[i],mName[i],year[i]);             
	    	if(head==null) {
	    		this.head=this.tail=node;
	    		this.head.setPrev(null);
	    	}
	    	else {
	    		this.tail.setNext(node);
	    		node.setPrev(tail);
	    		this.tail=node;
	    	}
		}
	}
	public void addSong()  
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Song name:");
		String songName=sc.nextLine();
		System.out.println("Enter Movie name:");
		String movieName=sc.nextLine();
		System.out.println("Enter Song released year:");
		int year=sc.nextInt();
		Node node = new Node(songName,movieName,year);             
	    if(head==null) {
	    	this.head=this.tail=node;
	    	this.head.setPrev(null);
	    }
	    else {
	    	this.tail.setNext(node);
	    	node.setPrev(tail);
	    	this.tail=node;
	    }
	}
	public void deleteSong() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Song Name To Delete:");
		String songName=sc.nextLine();
		Node current=find(songName);
		if(head==null){
			System.out.println("No songs in your PlayList...");
		}
		else if(current==null){
			System.out.println("NOT FOUND!..");
		}
		else if(head.getNext()==null){
			head=null;
			System.out.println("Deleted");
		}
		else if(current.getNext()==null) {
			Node last=current.getPrev();
			last.setNext(null);
			tail=last;
			System.out.println("Deleted!...");
		}
		else if(current.getPrev()==null) {
			head=current.getNext();
			current.setNext(null);
			head.setPrev(null);
			System.out.println("Deleted!...");
		}
		else {
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
			System.out.println("Deleted!...");
		}
	}
	public void playSong() {
		Node temp=head;
			if(temp!=null) {
				System.out.println("Current song:"+temp.getSongName());
				System.out.println("Movie name:"+temp.getMovieName());
				System.out.println("Year:"+temp.getYear());
				System.out.println("Lyrics:Not Found1!.");
				currentSong=temp;
			}
	}
		
	public Node find(String songName) {
		Node temp = head;
		while(temp!=null) {
			if((temp.getSongName()).equals(songName)) {
				return temp;
			}
			temp=temp.getNext();
		}
		return null;
	}
	public void displayAll() {
		Node temp = head;                       
		while(temp!=null)                       
		{                                       
			System.out.println(temp.getSongName());
			if(temp.getNext()==null)
				break;
			else
				temp = temp.getNext();
		}  
		
	}
	public void Next(String songName){
		Node current = find(songName);
		if(current.getNext()==null)
			current=head;
		else
			current=current.getNext();
		System.out.println("Current Song:"+current.getSongName());
		System.out.println("Movie name:"+current.getMovieName());
		System.out.println("Year:"+current.getYear());
		System.out.println("Lyrics:Not Found1!.");
		currentSong=current;
	}
	public void Previous(String songName){
		Node current = find(songName);
		if(current.getPrev()==null)
			current=tail;
		else
			current=current.getPrev();
		System.out.println("Curent Song:"+current.getSongName());
		System.out.println("Movie name:"+current.getMovieName());
		System.out.println("Year:"+current.getYear());
		System.out.println("Lyrics:Not Found1!.");
		currentSong=current;
	}
	public void RenameSong() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Song Name To Rename:");
		String songName=sc.nextLine();
		Node current = find(songName);
		if(current!=null) {
			System.out.println("Enter New Song Name:");
			String s1 =sc.nextLine();
			current.setSongName(s1);
			System.out.println("Song Renamed Succesfully!...");
		}
		else {
			System.out.println("SONG NOT FOUND");
		}
	}
	public static void main(String[] args) {
		MusicPlaylist MP = new MusicPlaylist();
		Scanner sc =new Scanner(System.in);
		int choice;
		MP.defaultSongs();
		do {
			System.out.println("\n****MUSIC PLAYLIST*****");
			System.out.println("1.Add A Song");
			System.out.println("2.Play A Song");
			System.out.println("3.Play Next Song");
			System.out.println("4.Play Previous Song");
			System.out.println("5.Display All Songs");
			System.out.println("6.Delete A Song");
			System.out.println("7.Rename A Song");
			System.out.println("8.EXIT");
			
			System.out.println("Enter Your Choice:");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				MP.addSong();
				break;
			case 2:
				MP.playSong();
				break;
			case 3:
				MP.Next(MP.currentSong.getSongName());
				break;
			case 4:
				MP.Previous(MP.currentSong.getSongName());
				break;
			case 5:
				MP.displayAll();
				break;
			case 6:
				MP.deleteSong();
				break;
			case 7:
				MP.RenameSong();
				break;
			case 8:
				System.out.println("Exiting the Code!....");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice!..Please Try Again");
			}
		}while(choice!=9);
		sc.close();
	}
}
