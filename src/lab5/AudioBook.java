package lab5;

public class AudioBook implements Book{
	/*
	 * Implement AudioBook Class: Similarly, create a class AudioBook that implements the Book interface and 
	 * models an audio book available at the library. This class should also allow renting and returning by Member 
	 * objects
	 */
	
	private String title;
	private boolean isAvailable;
	
	
	public AudioBook(String title) {
		super(title);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		return "Book: " + title;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
}
