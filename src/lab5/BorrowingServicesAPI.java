package lab5;

public interface BorrowingServicesAPI {
	// Two methods to manage Member's books 
	public boolean borrowBook(Member member, Book book); 
	public boolean returnBook(Member member, Book book); 
}
