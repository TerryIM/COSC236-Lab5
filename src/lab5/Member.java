package lab5;

import java.util.ArrayList;

public class Member{

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	private BorrowingServices borrowingService;
	
	public Member(String name, BorrowingServices borrowingService) {
		this.name = name;
		this.borrowingService = borrowingService;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setBorrowedBooks(Book book) {
		borrowedBooks.add(book);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(Book book) {
		//borrowingService.borrowBook(this, book);
		System.out.println(borrowingService.borrowBook(this, book).getBorrowingMessage());
	}
	public void returnBook(Book book) {
		//borrowingService.returnBook(this, book);
		System.out.println(borrowingService.returnBook(this, book).getBorrowingMessage());
	}
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		//borrowingService.returnAllBooks(this);
		System.out.println(borrowingService.returnAllBooks(this).getBorrowingMessage());
	}
}
