drop database if exists library;

create database if not exists library;
use library;

CREATE TABLE IF NOT EXISTS books (
	book_name varchar(120) not null,
    book_id int not null unique,
    description text,
    date_of_publication date not null default "2018-01-01",
    kategory varchar(30) not null,
    isbn varchar(20) not null unique,
    number_of_pages smallint not null,
    author_name varchar(45) not null,
    author_surname varchar(45) not null,
    author_email varchar(100) not null unique,
    author_age int not null,
    author_birthday date not null,
    author_awards text null
    );

insert into books(book_name, book_id, description, date_of_publication, kategory, isbn, number_of_pages, author_name, author_surname, author_email,
author_age, author_birthday, author_awards)
values ("Прелюдія до Фундації", 1, "У творі описується Трантор часів правління Клеона I. Сюжет розгортається із доповіді молодого вченого-математика
Гарі Селдона з планети Гелікон. На науковому конгресі він описує теоретичну можливість математичного моделювання майбутнього — згодом цю науку назвали
психоісторією. Доповіддю молодого математика зацікавилися прем'єр-міністр Імперії Едо Демерзель та Імператор. Гарі Селдона привезли в палац Імператора,
проте математик був змушений розчарувати його, пояснивши суто теоретичну сутність своєї роботи. Однак імператор на це не зважає та бажає використати
працю Селдона, маючи на увазі зробити це за допомогою самовтілюваних пророцтв.", "1988-05-26", "Науково-фантастичний роман", "978-84-8450-044-5", 463,
"Айзек", "Азімов",
"https://en.wikipedia.org/wiki/Isaac_Asimov", 72, "1920-01-02",
"Премія журналу «Локус» :
1976 — за повість «Двохсотлітня людина»;
1981 — в номінації «Related Nonfiction Book» за автобіографію In Joy Still Felt: The Autobiography of Isaac Asimov, 1954—1978;
Премія Неб'юла :
1972 — за роман «Навіть боги»;
1976 — за повість «Двохсотлітня людина»;
Премія Г'юго :
1966 за серію «Фундація» (як «Найкращу НФ серію усіх часів»);
1973 за роман «Навіть боги»;
1977 за повість «Двохсотлітня людина»;
1983 за роман з серії «Фундація» «Межа фундації»;
1994 за автобіографію «А. Азімов: спогади»
Премія «Ґеффен» :
2010 за роман «Isaac Asimov's Collected Short Stories– Vol. I."),
("Як важливо бути серйозним", 2, "Це комедія-фарс, головними героями якого є Джон Вордінг та Алджернон Монкриф. Обоє молодиків по черзі представляються
вигаданим Ернестом Вордінгом, щоб уникнути обтяжливих чи незручних для них соціальних умовностей і зобов'язань, що викликає кумедні непорозуміння.",
"1895-04-15", "Комедія", "978-84-8650-561-2", 417, "Оскар", "Уайльд", "https://en.wikipedia.org/wiki/Oscar_Wilde", 46, "1854-10-16",null),
("Крад́ійка книж́ок", 3, "Книжка гіркого відчаю, неможливості змінити усе довкола, книжка боротьби та втрат. Книжка про силу слів. Книга розповідає про
Голокост часів Другої Світової війни, вплив тоталітарного режиму Гітлера на людей, про Першу світову війну, книги.", "2005-10-14", "Роман",
"0-375-84220-9", 584, "Маркус", "Зузак", "https://en.wikipedia.org/wiki/Markus_Zusak", 44, "1975-06-23",
"Margaret Edwards Awardd (2014);
Zilveren Zoend;
Deutscher Jugendliteraturpreisd (2007);
Kathleen Mitchell Awardd (2006)."),
("П'ятдеся́т відті́нків", 4, "Роман оповідає історію стосунків підприємця Крістіана Грея і студентки Анастасії Стіл; в книзі містяться відверті
сексуальні сцени, що включають елементи такої сексуальної поведінки, як рабство/дисципліна, домінування/підкорення і садизм/мазохізм (БДСМ).",
"2011-07-20","Еротичний роман", "978-617-538-230-1", 514, "Еріка", "Джеймс", "https://en.wikipedia.org/wiki/E._L._James", 57, "1963-03-07",
"2012 — Час 100 за версією журналу Time, «100 найвпливовіших людей у світі»ж
2012 — Publishers Weekly «Видавнича Людина року»ж
2012 — Національна книжкова премія (Велика Британія),
«Популярні Фантастики, Книга року»- П'ятдесят відтінків сірого."),
("Прислуга", 5, " Наріжним каменем сюжету стали історії життя чорношкірих служниць, які у 1960-ті роки працювали на білих людей на півдні США, штат
Міссісіпі.", "2009-01-18", "Художня література", "0-553-29435-17", 496, "Кетрін", "Стокетт", "https://en.wikipedia.org/wiki/Kathryn_Stockett", 51,
"1969-01-02", null),
("Першому гравцеві приготуватися", 6, "2044 рік, через велику рецесію світова економіка перебуває в стані занепаду. Відчувається глобальний дефіцит
ресурсів, тоді як інтернет та ігрова культура досягає чималих висот, отримавши таке творіння, як ОАЗІС — Онтологічний Антропоцентричний Зоровий
Імерсивний Симулятор — багатокористувацька онлайнова рольова гра, створена Джеймсом Галлідеєм і Огденом Морров. Джеймс Галлідей перед смертю залишає
заповіт, який повідомляє, що в грі є три ключі та віртуальне «великоднє яйце».", "2011-08-11", "Науково-фантастичний роман", "978-0307887436", 385,
"Ернест", "Клайн", "https://en.wikipedia.org/wiki/Ernest_Cline", 48, "1972-03-29", null),
("Дівчина у потягу", 7, "Рейчел щодня о 8:04 сідає на той самий потяг і кожен день долає той самий маршрут. День-у-день, через вікно потяга, вона
спостерігає за подружньою парою з будинку №15 та заздрить їхньому щастю. Ще зовсім недавно й вона жила неподалік, на тій самій вулиці, та була
одружена з Томом, який покинув її заради своєї коханки — Анни. Одного дня, Рейчел бачить Меган — «щасливу» мешканку будинку №15 — в обіймах іншого
чоловіка. А невдовзі Меган зникає без сліду.", "1986-09-20", "Психологічний трилер", "978-1-59463-366-9", 395, "	Пола", "Гоукінз",
"https://en.wikipedia.org/wiki/Paula_Hawkins_(author)", 47, "1972-08-26", null),
("Убивство у «Східному експресі»", 8, "Узимку знаменитому бельгійському детективові, який перебуває в Стамбулі, Еркюлю Пуаро, необхідно терміново
виїхати до Англії. Але всі місця в знаменитому «Східному експресі» були зайняті. Утім, директор залізничної компанії, міс'є Бук, давній друг Пуаро,
сам їде в тому ж потязі й знаходить для Пуаро місце. На наступний ранок за сніданком Пуарозауважує, що у вагоні перебувають люди різних національностей,
які випадково зустрілися в цій подорожі.", "1934-01-01", "Детективний роман", "678-966-14-3432-4", 256, "Агата ", "Крісті",
"https://en.wikipedia.org/wiki/Agatha_Christie", 85, "1890-09-15",null),
("Воно", 9, "Події відбуваються в містечку Деррі штату Мейн. Восени 1957 року шестирічний хлопчик Джордж Денбро, граючись газетним корабликом, губить
його в дренажному колодязі. Там він бачить клоуна Пеннівайза, що доброзвичливо балакає, та раптом береться затягувати його всередину. Джорджа кидається
рятувати перехожий, але марно — клоун відриває хлопчику руку і той помирає. Десятирічний брат загиблого, Білл, що страждає на заїкання, тяжко переживає
втрату брата. Батьки винять в цьому його, адже Білл зробив Джорджу кораблика.", "1986-09-15",
"Жахи", "978-963-14-8697-2", 1344, "Стівен", "Кінг", "https://en.wikipedia.org/wiki/Stephen_King", 72, "1947-09-21",
"Національна книжкова преміяd (2003);
Премія Едгара Алана По (2007);
Велика премія уявного (1997);
Премія Брема Стокера (2003);
Премія Брема Стокера (2000);
Премія Брема Стокера (2011);
Премія Брема Стокера за найкращий романd (2006);
Премія Брема Стокера за найкращу не-фантастикуd (2000);
Премія Брема Стокера за найкращий романd (2008);
Премія Брема Стокера за найкращий романd (1996);
Національна медаль мистецтв (2014);
Премія Едгара Алана По (2015);
Премія Едгара Алана По (2016);
Велика премія уявного (2002);
Премія О. Генріd (1996);
Shirley Jackson Award for Single-Author Collectiond (2015)."),
("P.S. Я люблю тебя", 10, "Сюжет роману відкриває сторінки з життя головної героїні - Холлі Кеннеді, яка переживає втрату близької людини, свого
чоловіка Джеррі. Одного разу вона отримує від нього пакет з листами, який дає початок новому етапу в її житті і повертає її в ті моменти, коли вона
була щаслива. Всього 10 послань, кожне з яких закінчується постскриптумом «Я люблю тебе».", "2007-04-15", "Роман" , "0-7892-6164-1",
512, "Ахерн", "Сесилия", "https://en.wikipedia.org/wiki/Cecelia_Ahern", 38, "1981-09-30",
"2004/2005 — «Лучший дебютант» The British Book Awards[5] за роман «P.S. I Love You»;
2005 — «Ирландская литературная премия» (Irish Post Award);
2005 — Corine Literature Prize[6] за роман «Where rainbows end»;
2006 — Fun Fearless Fiction Award от журнала «Космополитен» за роман «If you could see me now»;
2008 — Best New Writer, от женского журнала «GLAMOUR».");