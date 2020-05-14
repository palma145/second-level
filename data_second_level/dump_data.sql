--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2 (Debian 12.2-2.pgdg100+1)
-- Dumped by pg_dump version 12.2 (Debian 12.2-2.pgdg100+1)

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
-- Name: second_level; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA second_level;


ALTER SCHEMA second_level OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: productos; Type: TABLE; Schema: second_level; Owner: postgres
--

CREATE TABLE second_level.productos (
    id character varying(50) NOT NULL,
    name character varying(100) NOT NULL,
    price character varying(20) NOT NULL
);


ALTER TABLE second_level.productos OWNER TO postgres;

--
-- Data for Name: productos; Type: TABLE DATA; Schema: second_level; Owner: postgres
--

COPY second_level.productos (id, name, price) FROM stdin;
01e196a9-9edc-426f-a8fa-5f3cd87192c4	producto1 actualizado	12
f27800a9-63ca-4b7d-a81c-9a480a5809e5	producto 3 act	12
\.


--
-- PostgreSQL database dump complete
--

