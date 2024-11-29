package lab5;

public class BorrowingServices implements BorrowingServicesAPI {
	// DONE: Implement methods for borrowing and returning Books 
	@Override
	public boolean borrowBook(Member member, Book book) {
		// TODO Here you can implement logic to check if the book is available to 
		//borrow and if the member can borrow it  
		//(e.g., item limit, member status).  
		
		//TODO determine maxBooks value (100 is just a placeholder for now)
		int maxBooks = 100;
		
		if (!book.getIsAvailable()) {
			//Book is not available
			System.out.println(book.getTitle() + " is not currently available");
			return false;
		}
		
		if (member.borrowedBooksCount() >= maxBooks) {
			//Member cannot borrow the book
			System.out.println(member.getName() + " has reached the maximum number of books (" + maxBooks + " books).");
			return false;
		}
		
		System.out.println("Borrowing book: " + book); 
		//TODO modify Member class to allow this class to add to it's ArrayList of borrowedBooks by creating an setBorrowedBooks(Book) method
		member.setBorrowedBooks(member.getBorrowedBooks().add(book));
		book.setIsAvailable(false);
		return true; // Return true for success
	}
	
	@Override
	public boolean returnBook(Member member, Book book) {
		// Implement logic to handle returning a book 
		
		if (!member.getBorrowedBooks().contains(book)) {
			System.out.println(member.getName() + " is not currently borrowing the book '" + book.getTitle() + "'.");
			return false;
		}
		
		System.out.println("Returning book: " + book); 
		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return true; // Return true for success
	}
}
