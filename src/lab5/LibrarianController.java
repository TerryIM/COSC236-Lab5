package lab5;

public class LibrarianController {

	private Library library; // Library dependency
	private BorrowingServices borrowingService; // Singleton

	public LibrarianController() {
		this.library = new Library(); // Constructor injection
		this.borrowingService = BorrowingServices.getInstance();
	}

	public Library getLibrary() {
		return this.library;
	}

	public void showBooks() {
		library.showBooks();
	}

	public void showMembers() {
		library.showMembers();
	}

	public void addBook(BookFactory factory, String title) {
		library.addBook(factory.createBook(title)); // Book type depends on the factory passed in
	}

	public void addPaperBook(String title) {
		PaperBookFactory paperBookFactory = new PaperBookFactory();
		library.addBook(paperBookFactory.createBook(title));
	}

	public void addEBook(String title) {
		EBookFactory eBookFactory = new EBookFactory();
		library.addBook(eBookFactory.createBook(title));
	}

	public void addAudioBook(String title) {
		AudioBookFactory audioBookFactory = new AudioBookFactory();
		library.addBook(audioBookFactory.createBook(title));
	}

	public void addRareBook(String title) {
		RareBookFactory rareBookFactory = new RareBookFactory();
		library.addBook(rareBookFactory.createBook(title));
	}

	public void addMember(String name) {
		// TODO change Member class' Constructor and borrowBook() [Step 7.3]
		library.addMember(new Member(name, borrowingService)); // Member class constructor dependency
	}

	public void removeBook(String title) {
		library.removeBook(title); // remove
	}

	public void removeMember(String name) {
		library.removeMember(name);
	}

	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else
			System.out.println("Member " + name + " not found.");
	}

	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else
			System.out.println("Book " + title + " not found.");
	}

	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else
			System.out.println("Member " + name + " not found.");
	}

	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search
		if (book != null && member != null)
			member.borrowBook(book); // member borrows a book, not library
		else if (!(book != null)) {
			System.out.println(title + " not found.");
		}
		if (!(member != null)) {
			System.out.println("member: " + name + " not found");
		}

	}

	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search
		if (book != null && member != null)
			member.returnBook(book); // members returns book.
		else if (!(book != null)) {
			System.out.println(title + " not found.");
		}
		if (!(member != null)) {
			System.out.println("member: " + name + " not found");
		}
	}

	public void bookList() {
		library.showBooks();
	}

	public void returnAllBooks(String name) {
		Member member = library.findMemberByName(name); // use library for search
		if (member != null)
			member.returnAllBooks(); // member returns all books
		if (!(member != null)) {
			System.out.println("member: " + name + " not found");
		}
	}
}
