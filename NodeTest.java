package musicapp;
import java.util.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

import musicapp.Node;
import musicapp.MusicGui;

public class NodeTest {
	String songName;
	Node head;
	Node tail;
	ArrayList<String> sName = new ArrayList<String>(
            Arrays.asList("GABBARSINGH","BEASTMODE","NINILLA","GUNDELLONA","VELLIPOMAKEY","ORIDEVUDA","MOWABRO","PILLAPADEYSAVEY","ORIVARI"));
	ArrayList<String> mName = new ArrayList<String>(
    		Arrays.asList("Gabbarsingh","Beast","Tholiprema","OriDevuda","Sahasam","VIP","DAMKI","LoveToday","Dasara"));
	ArrayList<Integer> year = new ArrayList<Integer>(
			Arrays.asList(2012,2020,2018,2022,2017,2020,2022,2023,2023));
	int len= sName.size();
	public void defaultSongs() {
		for(int i=0;i<len;i++) {
			Node node = new Node(sName.get(i),mName.get(i),year.get(i));             
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
	public String addNode()  
	{
		songName=JOptionPane.showInputDialog("Enter Song NAME:");
		String movieName=JOptionPane.showInputDialog("Enter Movie NAME:"); 
		int Year=Integer.parseInt(JOptionPane.showInputDialog("Enter Released Year:") );
		Node node = new Node(songName,movieName,Year); 
	    if(head==null) {
	    	this.head=this.tail=node;
	    	this.head.setPrev(null);
	    	JOptionPane.showMessageDialog(null,"SONG ADDED!..");
	    }
	    else {
	    	this.tail.setNext(node);
	    	node.setPrev(tail);
	    	this.tail=node;
	    	JOptionPane.showMessageDialog(null,"SONG ADDED!..");
	    }
	    sName.add(songName);
		mName.add(movieName);
		year.add(Year);
		return songName;
	}
	public String  delete() {
		songName=JOptionPane.showInputDialog("Enter Song NAME:");
		Node current=find(songName);
		if(head==null){
	    	JOptionPane.showMessageDialog(null,"No songs in your PlayList...");
		}
		else if(head.getNext()==null){
			head=null;
	    	JOptionPane.showMessageDialog(null,"SONG DELETED!..");

		}
		else if(current.getNext()==null) {
			Node last=current.getPrev();
			last.setNext(null);
			tail=last;
			JOptionPane.showMessageDialog(null,"SONG DELETED!..");
		}
		else if(current.getPrev()==null) {
			head=current.getNext();
			current.setNext(null);
			JOptionPane.showMessageDialog(null,"SONG DELETED!..");
		}
		else {
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
			JOptionPane.showMessageDialog(null,"SONG DELETED!..");
		}
		return songName;
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
	public void display() {
		Node temp = head;                       
		while(temp!=null)                       
		{                                       
			System.out.print(temp.getSongName()+"-->");
			temp = temp.getNext();                 
		}  
	}
	public Node Next(String songName){
		Node current = find(songName);
		if(current.getNext()==null)
			current=head;
		else
			current=current.getNext();
			return current;
	}		
	public Node Previous(String songName){
		Node current = find(songName);
		if(current.getPrev()==null)
			current=tail;
		else
			current=current.getPrev();
			return current;
	}
	public Node Play(String songName){
		Node current=find(songName);
		return current;
	}
	public String RenameSong() {
		songName=JOptionPane.showInputDialog("Enter Song NAME:");
		Node current = find(songName);
		if(current!=null) {
			String s1=JOptionPane.showInputDialog("Enter  New Song NAME:");
			current.setSongName(s1);
			JOptionPane.showMessageDialog(null,"Song Renamed Succesfully!...");
			return s1;
		}
		else {
			JOptionPane.showMessageDialog(null,"SONG NOT FOUND!..");		
			}
		return null;
	}
}