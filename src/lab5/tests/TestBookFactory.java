package lab5.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import lab5.AudioBookFactory;
import lab5.Book;
import lab5.EBookFactory;
import lab5.PaperBookFactory;
import lab5.RareBookFactory;

public class TestBookFactory {
	PaperBookFactory paper = new PaperBookFactory();
	EBookFactory ebook = new EBookFactory();
	AudioBookFactory audio = new AudioBookFactory();
	RareBookFactory rare = new RareBookFactory();
	@Test
	void paperFactory() {
			Book book = paper.createBook("Dune");
			assertEquals(book.toString(), "Paper Book: Dune");
	}
	@Test
	void audioBookFactory() {
			Book book = ebook.createBook("Dune");
			assertEquals(book.toString(), "EBook: Dune");
	}
	@Test
	void eBookFactory() {
			Book book = audio.createBook("Dune");
			assertEquals(book.toString(), "Audio Book: Dune");
	}
	@Test
	void RareBookFactory() {
			Book book = rare.createBook("Dune");
			assertEquals(book.toString(), "Rare Book: Dune");
	}
}
