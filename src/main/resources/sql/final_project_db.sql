create database final_project_db;

create table Person(
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    full_name varchar(100) NOT NULL,
    year_of_birth int NOT NULL,
    password varchar NOT NULL,
    role varchar not null
);

CREATE TABLE Book (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title varchar(100) NOT NULL,
    author varchar(100) NOT NULL,
    year int NOT NULL,
    person_id int REFERENCES Person(id) ON DELETE SET NULL,
    taken_at timestamp
);

TRUNCATE TABLE Person;

UPDATE Person SET role='ROLE_ADMIN' where id=6;

insert into Book (title, author, year) values ('Историография функций культурно–досуговых учреждений (вторая половина XX — начало XXI вв.)', 'Рябков В.М.', 2010);
insert into Book (title, author, year) values ('Прогулки по рекам и каналам Санкт–Петербурга : путеводитель', 'Бунатян, М.Г.', 2007);
insert into Book (title, author, year) values ('Чарная. — СПб', 'Бунатян, М.Г.', 2007);
insert into Book (title, author, year) values ('История русской литературы XX века : учеб. пособие', 'Кузьмина С.Ф.', 2009);
insert into Book (title, author, year) values ('Студент вуза : технологии и организация обучения : учеб. пособие', 'Резник С.Д.', 2009);
insert into Book (title, author, year) values ('Библиотечные фонды: стратегия развития', 'Гриханов Ю.А.', 2008);
insert into Book (title, author, year) values ('Знаменитые музеи–усадьбы России', 'И.С. Ненарокомова', 2010);
insert into Book (title, author, year) values ('Тайные виды на гору Фудзи', 'Пелевин Владимир', 2018);
insert into Book (title, author, year) values ('Бытие и время', 'Хайдегер Мартин', 1927);
insert into Book (title, author, year) values ('Над пропастью во ржи', 'Сэлигджер Джером', 1951);
insert into Book (title, author, year) values ('Философия Java', 'Экель Брюс', 2018);
insert into Book (title, author, year) values ('Психопатология обыденной жизни', 'Фрейд Зигмунд', 1904);
insert into Book (title, author, year) values ('День опричника', 'Сорокин Владимир', 2006);
insert into Book (title, author, year) values ('Игры в бисер', 'Гессе Герман', 1943);

UPDATE Book SET taken_at='2021-05-07 08:00:00' WHERE id=1;
