package musicapp;

public class Node {
	private String songName;
	private String movieName;
	private int year;
	private Node next;
	private Node prev;
	public Node(String songName, String movieName, int year) {
		super();
		this.songName = songName;
		this.movieName = movieName;
		this.year = year;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
