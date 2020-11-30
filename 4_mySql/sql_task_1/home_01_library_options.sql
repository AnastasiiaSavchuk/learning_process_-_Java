 SELECT * FROM library.books;

select * from books where book_id = 4 or book_id = 7 or book_id = 10;

select * from books where number_of_pages > 350;

select * from books where author_age > 50;

select * from books where author_awards is null;

select author_email from books;

select isbn from books;

select * from books where kategory = "Жахи" or kategory = "Науково-фантастичний роман";

select * from books where number_of_pages > 300 and author_age > 60;

select * from books where kategory = "роман" or kategory = "комедія";

select * from books order by book_name ASC;

select * from books order by author_email ASC;

select * from books order by number_of_pages desc;

select kategory from books;

select author_name from books;

select * from books where date_of_publication > "2000-01-01";

select * from books where date_of_publication < "2010-01-01";