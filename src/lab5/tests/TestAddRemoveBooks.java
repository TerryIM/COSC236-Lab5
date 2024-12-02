package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Book;
import lab5.BorrowingServices;
import lab5.Library;
import lab5.PaperBook;
import lab5.RareBook;
import lab5.Member;
import lab5.Ebook;;


class TestAddRemoveBooks {
	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}

	BorrowingServices borrowingServices = BorrowingServices.getInstance();
	AudioBook book1 = new AudioBook("Dune");
	Ebook book2 = new Ebook("1984");
	PaperBook book3 = new PaperBook("Moby Dick");
	RareBook book4 = new RareBook("Dune 2");
	
	Member member = new Member("Grady Booch", borrowingServices);
	
	@Test
	void AddBooks() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		assertEquals(library.booksCount(), 4, "There should be 3 books in the library");
	}
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		
		assertEquals(library.booksCount(), 4, "There should be 3 books in the library");
		library.removeBook(book2);
		library.removeBook(book3);
		assertEquals(library.booksCount(), 2, "There should be only one book left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(library.booksCount(), 4, "There should be 3 books in the library");
		library.removeBook("Dune");
		assertEquals(library.booksCount(), 3, "There should be only two book left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 4, "There should be 3 books in the library");
		
		member.borrowBook(book1);
		assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");
		
		library.removeBook(book1);
		assertEquals(library.booksCount(), 3, "There should be only two book left in the library");
		
		assertEquals(member.borrowedBooksCount(), 1, "The book should stay with member"); // 
		
		Book b = member.getBorrowedBooks().get(0); // the only book
		assertEquals(b, book1,"The owned book should be the removed book");
	}
	
	
}
