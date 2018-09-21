DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS users;

CREATE TABLE user (
    id SERIAL NOT NULL,
    creationtime TIMESTAMP,
    name VARCHAR(255),
    surname VARCHAR(255),
    born_date TIMESTAMP,

    CONSTRAINT user_pk PRIMARY KEY (name, surname)
);

CREATE TABLE users (
    id serial NOT NULL,
    creationtime TIMESTAMP,
    name character varying(255),
    surname character varying(255),
    email character varying(255) NOT NULL,

    CONSTRAINT users_pk PRIMARY KEY (email)
);