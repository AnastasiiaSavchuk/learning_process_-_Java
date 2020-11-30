CREATE DATABASE IF NOT EXISTS library_tables;
USE library_tables;

# One-To-One Connection
CREATE TABLE IF NOT EXISTS book(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    book_name VARCHAR(30) NOT NULL,
    discription TEXT NOT NULL,
    price INT NOT NULL,
    isbn INT NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS genre(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    books_genre VARCHAR(30),
    FOREIGN KEY(id) REFERENCES book(id)
);

# Many-TO-ONE Connection
CREATE TABLE IF NOT EXISTS author(
	author_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(15),
    author_surname VARCHAR(15),
    author_email VARCHAR(15),
    day_of_birth DATE,
    book_id INT NOT NULL,
    FOREIGN KEY(book_id) REFERENCES book(id)
);



Чому   нації занепадають?
Чому нації розвиваються по-різному? Деяким вдається досягти стабільності та успіху, тоді як інші зазнають невдач. Такі
фактори як географічне положення, кліматичні умови, релігія, культурні особливості не визначають рівень розвитку країни. Порівнюючи результати
досліджень різних країн, автори ідентифікують країни зі схожим набором вищезазначених факторів, які в силу певних політичних та інституційних
особливостей стають більш чи менш процвітаючими.
147  97861333   Нон-фікшн
Дарон  Аджемоглу  https://en.wikipedia.org/wiki/Daron_Acemoglu   1967-09-03
Джеймс Робінсон    https://en.wikipedia.org/wiki/James_A._Robinson_(economist)   1960-02-27

Величні за власним вибором.
Джеймс Коллінз та його колега Мортен Т. Гансен перераховують принципи побудови могутнього підприємства в часи
непередбачуваних та швидкоплинних подій. Червоною ниткою в книзі проходить тема нестабільності бізнес-середовища, з яким стикаються лідери сьогодні.
215  97861418   Бізнес
Джим  Коллінз  https://en.wikipedia.org/wiki/James_C._Collins   1958-01-25
Мортен Гансен  https://en.wikipedia.org/wiki/Morten_Hansen   1963-01-01

Воно
Події відбуваються в містечку Деррі штату Мейн. Восени 1957 року шестирічний хлопчик Джордж Денбро, граючись газетним корабликом, губить його в
дренажному колодязі.
300   97896314   Жахи
Стівен  Кінг https://en.wikipedia.org/wiki/Stephen_King  1947-09-21

Фундації
Молодий математик Гаал Дорнік прибуває на планету-місто Трантор, столицю Галактичної Імперії з метою приєднатися до проекту, раніше започаткованого
великим психоісториком Гарі Селдоном. Колись, використовуючи математичні основи психоісторії, Селдон довів майбутнє падіння Трантора внаслідок
«інерції» суспільства, що обрало шлях все більшої спеціалізації Трантора.
155  97861044   Науково-фантастичний роман
Айзек   Азімов  https://en.wikipedia.org/wiki/Isaac_Asimov   1920-01-02

Як важливо бути серйозним
Це комедія-фарс, головними героями якого є Джон Вордінг та Алджернон Монкриф. Обоє молодиків по черзі представляються вигаданим Ернестом Вордінгом,
щоб уникнути обтяжливих чи незручних для них соціальних умовностей і зобовязань, що викликає кумедні непорозуміння.
140   18541016  Комедія
Оскар  Уайльд  https://en.wikipedia.org/wiki/Oscar_Wilde  1854-10-16


