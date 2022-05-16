DROP TABLE IF EXISTS book, author, book2author, genre, book2genre;

CREATE TABLE book
(
    id            INT          NOT NULL AUTO_INCREMENT,
    pub_date      DATE         NOT NULL,
    is_bestseller TINYINT      NOT NULL,
    slug          VARCHAR(255) NOT NULL,
    title         VARCHAR(255) NOT NULL,
    image         VARCHAR(255),
    description   TEXT,
    price         INT          NOT NULL,
    discount      TINYINT      NOT NULL DEFAULT 0
);

CREATE TABLE author
(
    id          INT          NOT NULL AUTO_INCREMENT,
    photo       VARCHAR(255),
    slug        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE book2author
(
    id         INT NOT NULL AUTO_INCREMENT,
    book_id    INT NOT NULL,
    author_id  INT NOT NULL
);

CREATE TABLE genre
(
    id        INT          NOT NULL AUTO_INCREMENT,
    parent_id INT,
    slug      VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NOT NULL
);

CREATE TABLE book2genre
(
    id       INT NOT NULL AUTO_INCREMENT,
    book_id  INT NOT NULL,
    genre_id INT NOT NULL

);