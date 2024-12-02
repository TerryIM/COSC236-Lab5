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
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public boolean getIsAvailable() {
		return isAvailable;
	}
	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
