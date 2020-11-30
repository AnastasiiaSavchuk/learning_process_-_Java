SELECT * FROM library.books;
use library;

UPDATE books SET author_name = "Isaac ", author_surname = "Asimov" WHERE book_name = "Прелюдія до Фундації";

SELECT COUNT(*) FROM books WHERE author_awards is NOT NULL;

SELECT * FROM books WHERE number_of_pages = (SELECT min(number_of_pages) FROM books);
SELECT * FROM books WHERE number_of_pages = (SELECT max(number_of_pages) FROM books);

ALTER TABLE books ADD book_price DECIMAL(5.2);
SELECT AVG(book_price) FROM books;
SELECT sum(book_price) FROM books WHERE kategory = "Науково-фантастичний роман";

SELECT min(book_price) FROM books;
SELECT * FROM books WHERE book_price = (SELECT min(book_price) FROM books);

SELECT * FROM books  WHERE book_price LIKE "%1%" ORDER BY book_name ASC;

SELECT * FROM books ORDER BY date_of_publication ASC LIMIT 5, 3;

SELECT * FROM books  WHERE book_name LIKE "%л%";
SELECT * FROM books  WHERE description LIKE "%.";
SELECT * FROM books  WHERE kategory LIKE "%роман%";

SELECT * FROM books WHERE book_price BETWEEN 100 AND 150;
SELECT * FROM books WHERE book_price < 200 OR book_price > 600;

DELETE FROM books WHERE id = 2;
DELETE FROM books WHERE book_name = "Прислуга";
DELETE FROM books WHERE isbn = "0-7892-6164-1";

ALTER TABLE books RENAME COLUMN book_name TO book;