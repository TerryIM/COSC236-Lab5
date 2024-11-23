package lab5;

public class RareBook extends PaperBook implements Book{
	private String title;
	private boolean isAvailable;
	
	public RareBook(String title) {
		super(title);
	}
	@Override
	public String toString() {
		return "Rare Book: " + title;
	}
}
