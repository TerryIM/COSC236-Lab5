package lab5;

public class Ebook implements Book{
	private String title;
	private boolean isAvailable;
	
	public Ebook(String title) {
		this.title = title;
		this.setAvailable(true);
	}
	@Override
	public String toString() {
		return "EBook: " + title;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setIsAvailable(boolean isAvailable) {
		// TODO Auto-generated method stub
		
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
