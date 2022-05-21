CREATE TABLE IF NOT EXISTS book
(
    id            SERIAL PRIMARY KEY,
    pub_date      DATE         NOT NULL,
    is_bestseller SMALLINT      NOT NULL,
    slug          VARCHAR(255) NOT NULL,
    title         VARCHAR(255) NOT NULL,
    image         VARCHAR(255),
    description   TEXT,
    price         INT          NOT NULL,
    discount      SMALLINT      NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS author
(
    id          SERIAL PRIMARY KEY,
    photo       VARCHAR(255),
    slug        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS book2author
(
    id        SERIAL PRIMARY KEY,
    book_id   INT NOT NULL,
    author_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS genre
(
    id        SERIAL PRIMARY KEY,
    parent_id INT,
    slug      VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS book2genre
(
    id       SERIAL PRIMARY KEY,
    book_id  INT NOT NULL,
    genre_id INT NOT NULL

);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    hash     VARCHAR(255) NOT NULL,
    reg_time TIMESTAMP     NOT NULL,
    balance  INT          NOT NULL,
    name     VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_contact
(
    id          SERIAL PRIMARY KEY,
    user_id     INT                     NOT NULL,
    type        VARCHAR(10) NOT NULL,
    approved    SMALLINT                 NOT NULL,
    code        VARCHAR(255),
    code_trials INT,
    code_time   TIMESTAMP,
    contact     VARCHAR(255)            NOT NULL
);

CREATE TABLE IF NOT EXISTS book2user
(
    id      SERIAL PRIMARY KEY,
    time    TIMESTAMP NOT NULL,
    type_id INT      NOT NULL,
    book_id INT      NOT NULL,
    user_id INT      NOT NULL
);

CREATE TABLE IF NOT EXISTS book2user_type
(
    id   SERIAL PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS book_review
(
    id      SERIAL PRIMARY KEY,
    book_id INT      NOT NULL,
    user_id INT      NOT NULL,
    time    TIMESTAMP NOT NULL,
    text    TEXT     NOT NULL
);

CREATE TABLE IF NOT EXISTS book_review_like
(
    id        SERIAL PRIMARY KEY,
    review_id INT      NOT NULL,
    user_id   INT      NOT NULL,
    time      TIMESTAMP NOT NULL,
    value     SMALLINT  NOT NULL

);

CREATE TABLE IF NOT EXISTS book_file
(
    id      SERIAL PRIMARY KEY,
    hash    VARCHAR(255) NOT NULL,
    type_id INT          NOT NULL,
    path    VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS book_file_type
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS message
(
    id      SERIAL PRIMARY KEY,
    time    TIMESTAMP     NOT NULL,
    user_id INT,
    email   VARCHAR(255),
    name    VARCHAR(255),
    subject VARCHAR(255) NOT NULL,
    text    TEXT         NOT NULL

);

CREATE TABLE IF NOT EXISTS faq
(
    id         SERIAL PRIMARY KEY,
    sort_index INT          NOT NULL DEFAULT 0,
    question   VARCHAR(255) NOT NULL,
    answer     TEXT         NOT NULL

);

CREATE TABLE IF NOT EXISTS document
(
    id         SERIAL PRIMARY KEY,
    sort_index INT          NOT NULL DEFAULT 0,
    slug       VARCHAR(255) NOT NULL,
    title      VARCHAR(255) NOT NULL,
    text       TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS file_download
(
    id      SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    count   INT NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS balance_transaction
(
    id          SERIAL PRIMARY KEY,
    user_id     INT      NOT NULL,
    time        TIMESTAMP NOT NULL,
    value       INT      NOT NULL DEFAULT 0,
    book_id     INT      NOT NULL,
    description TEXT     NOT NULL
);