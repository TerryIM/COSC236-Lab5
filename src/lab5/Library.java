package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
	private ArrayList<Book> catalog; // Book dependency
	private ArrayList<Member> members; // Member dependency

	public Library() {
		catalog = new ArrayList<>();
		members = new ArrayList<>();
	}

	Library(ArrayList<Book> catalog, ArrayList<Member> members) {
		this.catalog = catalog;
		this.members = members;
	}

	public Member findMemberByName(String name) {
		for (Member member : members) {
			if (member.getName().equals(name)) {
				return member; // Return the found member
			}
		}
		return null; // Return null if not found
	}

	public Book findBookByTitle(String title) {
		for (Book book : catalog) {
			if (book.getTitle().equals(title)) {
				return book; // Return the found book
			}
		}
		return null; // Return null if not found
	}

	public void addMember(Member member) {
		members.add(member);
		System.out.println(member.getName() + " has been added.");
	}

	public void addBook(Book book) {
		catalog.add(book);
		System.out.println(book.getTitle() + " has been added to the catalog.");
	}

	public void removeMember(String name) {
		Member member = findMemberByName(name);
		removeMember(member);
	}

	public void removeMember(Member member) {
		if (member != null) {
			member.returnAllBooks(); // return all member's books to the library
			members.remove(member);
		}
	}

	public void removeBook(String title) {
		Book book = findBookByTitle(title);
		removeBook(book);
	}

	public void removeBook(Book book) {
		if (book != null)
			catalog.remove(book); // book stays with the member who has it
		System.out.println(book + " has been removed from the catalog.");
	}

	public void showMembers() {
		Iterator<Member> memberIterator = members.iterator();
		while (memberIterator.hasNext()) {
			Member member = memberIterator.next();
			System.out.println(member);
		}
	}

	public void showBooks() {
		Iterator<Book> bookIterator = catalog.iterator();
		while (bookIterator.hasNext()) {
			Book book = bookIterator.next();
			System.out.println(book); // book.toString()
		}
	}

	public int booksCount() {
		return catalog.size();
	}

	public int membersCount() {
		return members.size();
	}
}
