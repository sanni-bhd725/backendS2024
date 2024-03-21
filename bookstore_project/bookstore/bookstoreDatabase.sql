DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user_table;

CREATE TABLE category
(categoryid BIGSERIAL PRIMARY KEY
, name VARCHAR(255)
);

INSERT INTO category(name)
VALUES ('Contemporary fiction')
, ('Historical fiction')
, ('Historical non-fiction');

CREATE TABLE book
(id BIGSERIAL PRIMARY KEY
, author VARCHAR(255)
, title VARCHAR(255)
, publication_year INTEGER NOT NULL
, categoryid BIGINT
, isbn VARCHAR(255)
, price FLOAT(53) NOT NULL
, FOREIGN KEY (categoryid) REFERENCES category(categoryid)
);

INSERT INTO book (author, title, publication_year, categoryid, isbn, price)
VALUES ('Kjell Westö', 'Molly & Henry', 2023, 2, '978-951-1-38706-0', 29.95)
, ('Mirja Mäntylä', 'Tampereen kartanot', 2022, 3, '978-952-371-049-8', 47.00)
, ('Johannes Alaranta', 'Armoton pohjanmeri', 2023, 1, '978-952-396-106-7', 25.00)
, ('Henri Nyholm', 'Vajonnut kaupunki', 2024, 1, '978-952-379-293-7', 26.95);

CREATE TABLE user_table
(id BIGSERIAL PRIMARY KEY
, email VARCHAR(255) NOT NULL UNIQUE
, password VARCHAR(255) NOT NULL
, role VARCHAR(255) NOT NULL
, username VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO user_table (email, username, password, role)
VALUES ('user1@example.com', 'user', '$2a$10$AWcRJ2FU4HKu2JQJ2tsLOOLfgqsIT7HTuFQ5x.Co9NS4lnpZXfgoW', 'USER')
, ('user2@example.com', 'admin', '$2a$10$7n.YdPdbIylPNNKsRd6IUexj79M9mGmA0dEp0vOtpM82sbpCA27Z6', 'ADMIN');

SELECT * FROM book;
SELECT * FROM category;
SELECT * FROM user_table;