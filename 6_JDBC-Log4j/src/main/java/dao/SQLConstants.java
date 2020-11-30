package dao;

public class SQLConstants {

    public static final String GET_ALL_BOOKS = "SELECT * FROM library_tables.book;";
    public static final String GET_BOOK_BY_ID = "SELECT * FROM library_tables.book WHERE id = ?";
    public static final String CREATE_BOOK = "INSERT INTO library_tables.book (id, book_name, discription, price, isbn) VALUES (?, ?, ?, ?, ?);";
    public static final String UPDATE_BOOK = "UPDATE library_tables.book SET id = ?, book_name = ?, discription = ?, price =?, isbn = ?  WHERE (id = ?);";
    public static final String DELETE_BOOK_BY_ID = "DELETE FROM library_tables.book WHERE id = ?";

    public static final String GET_ALL_AUTHORS = "SELECT * FROM library_tables.author";
    public static final String GET_AUTHOR_BY_ID = "SELECT * FROM library_tables.author WHERE author_id = ?";
    public static final String CREATE_AUTHOR = "INSERT INTO library_tables.author (author_id, author_name, author_surname, author_email, day_of_birth, book_id) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_AUTHOR = "UPDATE library_tables.author SET author_id = ?, author_name = ?, author_surname = ?, author_email = ?, day_of_birth = ?, book_id = ? WHERE (author_id = ?)";
    public static final String DELETE_AUTHOR_BY_ID = "DELETE FROM library_tables.author WHERE author_id = ?";
}
