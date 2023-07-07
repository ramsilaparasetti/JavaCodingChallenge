import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    Book book1 = new Book("Cricket", "Mark", "S1");
    Book book2 = new Book("Tennis", "Ram", "S2");
    Book book3 = new Book("Badminton", "Sachin", "S3");
    Book book4 = new Book("Soccer", "Virat", "S4");

    Book book5 = new Book("Soccer12", "Mark12", "S34");

    @Before
    public void setup() {
        library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
    }

    @Test
    public void test_addBook_SizeIncreases_AfterAddingNewBook() {
        Book book5 = new Book("Golf", "John", "S5");
        Book book6 = new Book("BaseBall", "Josh", "S6");
        library.addBook(book5);
        library.addBook(book6);
        assertEquals(7, library.getBooks().size());
    }

    @Test
    public void test_addBook_ThrowsException_WhenBookAlreadyExists() {
        Exception exception = assertThrows(RuntimeException.class, () -> library.addBook(new Book("Cricket", "Mark", "S1")));
        assertTrue(exception.getMessage().contains("Book Already exists"));
    }

    @Test
    public void test_removeBook_SizeDecreases_AfterRemovingBook() {
        library.removeBook(book1);
        assertEquals(4, library.getBooks().size());
    }

    @Test
    public void test_removeBook_ThrowsException_WhenBookAlreadyExists() {
        Exception exception = assertThrows(RuntimeException.class, () -> library.removeBook(new Book("Cinema", "Greg", "S8")));
        assertTrue(exception.getMessage().contains("Book does not exist"));
    }

    @Test
    public void test_SearchBook_ReturnsListOfBooks_ForGivenTitleSearchString() {
        List<Book> result = new ArrayList<>();
        result = library.searchBook("Soccer");
        assertEquals(2, result.size());
        assertEquals("Virat", result.get(0).getAuthor());
    }

    @Test
    public void test_SearchBook_ReturnsEmptlyList_ForInvalidSearchString() {
        List<Book> result = new ArrayList<>();
        result = library.searchBook("asdfds");
        assertEquals(0, result.size());
    }
}