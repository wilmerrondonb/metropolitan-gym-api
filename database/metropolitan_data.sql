--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4 (Debian 17.4-1.pgdg120+2)
-- Dumped by pg_dump version 17.4 (Debian 17.4-1.pgdg120+2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: activity; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.activity (
    id integer NOT NULL,
    name character varying NOT NULL,
    space_id integer NOT NULL
);


ALTER TABLE public.activity OWNER TO admin;

--
-- Name: member; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.member (
    name character varying NOT NULL,
    dni character varying NOT NULL,
    id integer NOT NULL,
    city character varying NOT NULL
);


ALTER TABLE public.member OWNER TO admin;

--
-- Name: space; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.space (
    id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.space OWNER TO admin;

--
-- Name: activity_state; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.activity_state (
    id integer NOT NULL,
    name character varying NOT NULL
);

--
-- Name: activity_state; Type: TABLE; Schema: public; Owner: admin
--

ALTER TABLE public.activity_state OWNER TO admin;

--
-- Name: scheduled_activity; Type: TABLE; Schema: public; Owner: admin
--
CREATE TABLE public.scheduled_activity(
    id                  integer NOT NULL,
    activity_id         integer NOT NULL,
    member_id           integer NOT NULL,
    activity_state_id   integer NOT NULL,
    start_date          date    NOT NULL,
    end_date            date    NOT NULL
);

ALTER TABLE public.scheduled_activity OWNER TO admin;

--
-- Data for Name: activity; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.activity (id, name, space_id) FROM stdin WITH CSV;
1,padel infantil,2
2,zumba,4
3,spinning,3
4,spinning,3
\.


--
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.member (name, dni, id, city) FROM stdin;
Oscar	2456715S	2	Madrid
Luis	3264759F	1	Valencia
\.


--
-- Data for Name: space; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.space (id, name, description) FROM stdin;
1	padel_1	pista de padel principal
2	padel_2	pista de padel secundaria, usar en clases infantiles
3	cycling	aula para clases de cycling/spining
4	open	aula para multiples usos, clases de aerobic, yoga, zumba, etc
\.


--
-- Data for Name: activity_state; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.activity_state (id, name) FROM stdin;
1	reserva
2	cancelar
3	realizado
4	ausente
\.


--
-- Name: activity activity_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.activity
    ADD CONSTRAINT activity_pk PRIMARY KEY (id);


--
-- Name: space spaces_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.space
    ADD CONSTRAINT space_pk PRIMARY KEY (id);


--
-- Name: space space_unique; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.space
    ADD CONSTRAINT space_unique UNIQUE (name);


--
-- Name: space space_unique_1; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.space
    ADD CONSTRAINT space_unique_1 UNIQUE (description);


--
-- Name: activity_state activity_state_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.activity_state
    ADD CONSTRAINT activity_state_pk PRIMARY KEY (id);


--
-- Name: activity_state activity_state_unique; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.activity_state
    ADD CONSTRAINT activity_state_unique UNIQUE (name);


--
-- Name: member user_pk; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- Name: member user_unique; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT user_unique UNIQUE (dni);


--
-- Name: activity activity_spaces_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.activity
    ADD CONSTRAINT activity_space_fk FOREIGN KEY (space_id) REFERENCES public.space(id);


--
-- Name: scheduled_activity
--
ALTER TABLE ONLY public.scheduled_activity
     ADD CONSTRAINT scheduled_activity_pk PRIMARY KEY (id);

ALTER TABLE ONLY public.scheduled_activity
     ADD CONSTRAINT activity_fk FOREIGN KEY (activity_id) REFERENCES public.activity(id);

ALTER TABLE ONLY public.scheduled_activity
     ADD CONSTRAINT member_fk FOREIGN KEY (member_id) REFERENCES public.member(id);

ALTER TABLE ONLY public.scheduled_activity
     ADD CONSTRAINT activity_state_fk FOREIGN KEY (activity_state_id) REFERENCES public.activity_state(id);

--
-- PostgreSQL database dump complete
--

