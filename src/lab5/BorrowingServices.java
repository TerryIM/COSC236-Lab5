package lab5;

import java.util.Iterator;

public class BorrowingServices implements BorrowingServicesAPI {
	private static volatile BorrowingServices instance;
	private int borrowingLimit;

	private BorrowingServices() {
		borrowingLimit = 3;
	}

	public static BorrowingServices getInstance() {
		if (instance == null) {
			synchronized (BorrowingServices.class) {
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
			// Book is not available
			String msg = book.getTitle() + " is not currently available";
			return new BorrowingBookResult(false, msg);
		}
		// if user is borrowing the maximum amount of books
		if (member.borrowedBooksCount() >= borrowingLimit) {
			// Member cannot borrow the book
			String msg = member.getName() + " has reached the maximum number of books (" + borrowingLimit + " books).";
			return new BorrowingBookResult(false, msg);
		}
		// if user is already borrowing the book
		if (member.getBorrowedBooks().contains(book)) {
			return new BorrowingBookResult(false, member.getName() + " is already borrowing " + book.getTitle());
		}
		String msg = member.getName() + " is borrowing book: " + book.getTitle();
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

		if (book.getIsAvailable() == false) {
			String msg = member.getName() + " has already been returned " + book.getTitle();
			return new BorrowingBookResult(false, msg);
		}

		String msg = member.getName() + " is returning book: " + book.getTitle();
		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return new BorrowingBookResult(true, msg); // Return true for success
	}

	public BorrowingBookResult returnAllBooks(Member member) {
		if (member.getBorrowedBooks().isEmpty()) {
			return new BorrowingBookResult(false, member.getName() + " has not borrowed any books.");
		}
		Iterator<Book> bookIterator = member.getBorrowedBooks().iterator();

		while (bookIterator.hasNext()) {
			Book book = bookIterator.next();
			book.setIsAvailable(true);
		}
		member.getBorrowedBooks().clear(); // clear list of borrowed books
		return new BorrowingBookResult(true, member.getName() + " has returned all books");
	}

}
