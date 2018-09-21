CREATE TABLE user (
    id SERIAL NOT NULL,
    creationtime TIMESTAMP WITHOUT TIME ZONE,
    name VARCHAR(255),
    surname VARCHAR(255),
    born_date TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE users (
    id serial NOT NULL,
    creationtime TIMESTAMP WITHOUT TIME ZONE,
    name character varying(255),
    surname character varying(255),
    email character varying(255) NOT NULL
);