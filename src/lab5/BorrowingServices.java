package lab5;

public class BorrowingServices implements BorrowingServicesAPI {
	private static volatile BorrowingServices instance;	
	private int borrowingLimit;
	private BorrowingServices() {
		borrowingLimit = 3;
	}
	
	public static BorrowingServices getInstance() {
		if (instance == null) {
			synchronized(BorrowingServices.class) {
				if (instance == null) {
					instance = new BorrowingServices();
				}
			}
			
		}
		return instance;
	}
	
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		if (!book.getIsAvailable()) {
			//Book is not available
			String msg = book.getTitle() + " is not currently available";
			return new BorrowingBookResult(false, msg);
		}
		
		if (member.borrowedBooksCount() >= borrowingLimit) {
			//Member cannot borrow the book
			String msg = member.getName() + " has reached the maximum number of books (" + borrowingLimit + " books).";
			return new BorrowingBookResult(false, msg);
		}
		
		String msg = "Borrowing book: " + book; 
		//TODO modify Member class to allow this class to add to its ArrayList of borrowedBooks by creating a setBorrowedBooks(Book) method
		member.getBorrowedBooks().add(book);
		book.setIsAvailable(false);
		return new BorrowingBookResult(true, msg); // Return true for success
	}
	
	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		// Implement logic to handle returning a book 
		
		if (!member.getBorrowedBooks().contains(book)) {
			String msg = member.getName() + " is not currently borrowing the book '" + book.getTitle() + "'.";
			return new BorrowingBookResult(false, msg);
		}
		
		if(book.getIsAvailable() == false) {
			String msg = book.getTitle() + " has already been returned";
			return new BorrowingBookResult(false, msg);
		}
		
		String msg = "Returning book: " + book; 
		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return new BorrowingBookResult(true, msg); // Return true for success
	}
}
