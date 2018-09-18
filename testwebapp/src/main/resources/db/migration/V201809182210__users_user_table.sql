DROP TABLE IF EXISTS public.user;
DROP TABLE IF EXISTS public.users;

CREATE TABLE public.user (
    id SERIAL NOT NULL,
    creationtime TIMESTAMP WITHOUT TIME ZONE,
    name VARCHAR(255),
    surname VARCHAR(255),
    born_date TIMESTAMP WITHOUT TIME ZONE,

    CONSTRAINT user_pk PRIMARY KEY (name, surname)
);

CREATE TABLE public.users (
    id serial NOT NULL,
    creationtime TIMESTAMP WITHOUT TIME ZONE,
    name character varying(255),
    surname character varying(255),
    email character varying(255) NOT NULL,

    CONSTRAINT users_pk PRIMARY KEY (email)
);