import exception.AuthorAlreadyCreateException;
import exception.BookAlreadyCreatedException;
import exception.NoSuchAuthorException;
import exception.NoSuchBookException;
import service.AuthorService;
import service.BookService;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;

import java.sql.SQLException;

public class Main {

    private static BookService bookService = new BookServiceImpl();
    private static AuthorService authorService = new AuthorServiceImpl();

    public static void main(String[] args) throws SQLException, BookAlreadyCreatedException, NoSuchBookException, AuthorAlreadyCreateException, NoSuchAuthorException {
        bookService.getAllBooks();
        //bookService.getBookById(1);
        //bookService.createBook(new Book(6,"Філософія Java","Основи програмування мовою JAVA",980,978013187));
        //bookService.updateBook(6, new Book(6, "Thinking in Java", " is a book about the Java programming language", 980, 978013187));
        //bookService.deleteBookById(6);

        //authorService.getAllAuthors().forEach(System.out::println);
        //System.out.println(authorService.getAuthorById(3));
        //authorService.createAuthor(new Author(8, "Брюс", "Еккел", "wiki.Eckel", "1957-07-08", new Book(6, "Філософія Java", "Основи програмування мовою JAVA", 980, 978013187)));
        //authorService.updateAuthor(8,new Author(9,"Bruce","Eckel","wiki.Eckels","1957-07-08", new Book(6, "Thinking in Java", " is a book about the Java programming language", 980, 978013187) ));
        //authorService.deleteAuthorById(8);
    }
}
