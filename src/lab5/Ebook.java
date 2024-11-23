package lab5;

public class Ebook extends PaperBook implements Book{
	private String title;
	private boolean isAvailable;
	
	public Ebook(String title) {
		super(title);
	}
	@Override
	public String toString() {
		return "EBook: " + title;
	}
	
}
