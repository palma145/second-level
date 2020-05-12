--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2 (Debian 12.2-2.pgdg100+1)
-- Dumped by pg_dump version 12.2 (Debian 12.2-2.pgdg100+1)

-- Started on 2020-05-12 09:32:54 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16384)
-- Name: second_level; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA second_level;


ALTER SCHEMA second_level OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16385)
-- Name: users; Type: TABLE; Schema: second_level; Owner: postgres
--

CREATE TABLE second_level.users (
    username character varying(25) NOT NULL,
    password character varying(25) NOT NULL
);


ALTER TABLE second_level.users OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 16385)
-- Dependencies: 203
-- Data for Name: users; Type: TABLE DATA; Schema: second_level; Owner: postgres
--

INSERT INTO second_level.users VALUES ('admin', 'admin');
INSERT INTO second_level.users VALUES ('user1', 'user1');
INSERT INTO second_level.users VALUES ('user2', 'user2');


-- Completed on 2020-05-12 09:32:54 UTC

--
-- PostgreSQL database dump complete
--

