import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}

class Library {
    private List<Book> books;


    public Library(){
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (isBookExists(book)) {
            throw new RuntimeException("Book Already exists");
        } else {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        if (isBookExists(book)) {
            books.remove(book);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }

    public List<Book> searchBook(String searchQuery) {
        List<Book> searchBooks = new ArrayList<>();
        for(Book libBook :books){
            if(libBook.getTitle().contains(searchQuery) ||
                    libBook.getAuthor().contains(searchQuery) ||
                    libBook.getIsbn().contains(searchQuery)){
                searchBooks.add(libBook);
            }
        }
        return searchBooks;
    }

    private boolean isBookExists(Book book) {
        Boolean bookExistsFlag = false;
        for (Book libBook : books) {
            if (libBook.getIsbn().equals(book.getIsbn())) {
                bookExistsFlag = true;
                break;
            }
        }
        return bookExistsFlag;
    }
}
