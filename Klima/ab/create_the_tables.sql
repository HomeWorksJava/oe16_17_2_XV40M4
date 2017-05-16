--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: keszulekek; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE keszulekek (
    elnevezes character varying(240),
    id integer NOT NULL,
    energiaosztaly character varying(10) NOT NULL,
    futoteljesitmeny double precision NOT NULL,
    garancia character varying(20),
    gyarto character varying(20) NOT NULL,
    hutoteljesitmeny double precision NOT NULL,
    kivitel character varying(20) NOT NULL,
    leiras character varying(250)
);


--
-- Name: megrendelesek; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE megrendelesek (
    id integer NOT NULL,
    keszulek_id integer NOT NULL,
    megrendelescim character varying NOT NULL,
    utolsokarb date,
    rendelesdatum date,
    vevo_id integer
);


--
-- Name: raktar; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE raktar (
    hely character varying(50),
    id integer NOT NULL,
    terulet integer,
    leiras character varying(250)
);


--
-- Name: raktarkeszulekek; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE raktarkeszulekek (
    id integer NOT NULL,
    arres numeric NOT NULL,
    foglaltmennyiseg integer,
    keszulek_id integer NOT NULL,
    mennyiseg integer,
    minimalismennyiseg integer,
    raktar_id integer NOT NULL,
    szabadmennyiseg integer
);


--
-- Name: rendelesraktarra; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE rendelesraktarra (
    id integer NOT NULL,
    foglaltmennyiseg integer,
    keszulek_id integer NOT NULL,
    mennyiseg integer,
    mikorra date,
    raktar_id integer,
    rendeles_datuma date NOT NULL
);


--
-- Name: userroles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE userroles (
    username character varying(255),
    role character varying(32),
    id integer NOT NULL
);


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE users (
    username character varying(255) NOT NULL,
    passwd character varying(255),
    id integer NOT NULL
);


--
-- Name: vevok; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vevok (
    id integer NOT NULL,
    nev character varying(50),
    email character varying(50),
    telefon character varying(14)
);


--
-- Name: keszulekek Keszulekek_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY keszulekek
    ADD CONSTRAINT "Keszulekek_pkey" PRIMARY KEY (id);


--
-- Name: megrendelesek Megrendelesek_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY megrendelesek
    ADD CONSTRAINT "Megrendelesek_pkey" PRIMARY KEY (id);


--
-- Name: raktarkeszulekek RaktarKeszulekek_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY raktarkeszulekek
    ADD CONSTRAINT "RaktarKeszulekek_pkey" PRIMARY KEY (id);


--
-- Name: raktar Raktar_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY raktar
    ADD CONSTRAINT "Raktar_pkey" PRIMARY KEY (id);


--
-- Name: rendelesraktarra RendelesRaktarra_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY rendelesraktarra
    ADD CONSTRAINT "RendelesRaktarra_pkey" PRIMARY KEY (id);


--
-- Name: vevok Vevok_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vevok
    ADD CONSTRAINT "Vevok_pkey" PRIMARY KEY (id);


--
-- Name: userroles userroles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY userroles
    ADD CONSTRAINT userroles_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: raktarkeszulekek F_RK_keszulekek; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY raktarkeszulekek
    ADD CONSTRAINT "F_RK_keszulekek" FOREIGN KEY (keszulek_id) REFERENCES keszulekek(id);


--
-- Name: raktarkeszulekek F_RK_raktar; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY raktarkeszulekek
    ADD CONSTRAINT "F_RK_raktar" FOREIGN KEY (raktar_id) REFERENCES raktar(id);


--
-- Name: rendelesraktarra F_RR_Kesz; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY rendelesraktarra
    ADD CONSTRAINT "F_RR_Kesz" FOREIGN KEY (keszulek_id) REFERENCES keszulekek(id);


--
-- Name: rendelesraktarra F_RR_Rak; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY rendelesraktarra
    ADD CONSTRAINT "F_RR_Rak" FOREIGN KEY (raktar_id) REFERENCES raktar(id);


--
-- Name: megrendelesek F_Vevo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY megrendelesek
    ADD CONSTRAINT "F_Vevo" FOREIGN KEY (vevo_id) REFERENCES vevok(id);


--
-- Name: megrendelesek F_keszulek; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY megrendelesek
    ADD CONSTRAINT "F_keszulek" FOREIGN KEY (keszulek_id) REFERENCES keszulekek(id);


--
-- PostgreSQL database dump complete
--

