package lab5;

public class AudioBookFactory {
	public Book createBook(String title) {
		return new AudioBook(title);
	}
}
