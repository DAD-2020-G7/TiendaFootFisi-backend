--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-02-16 09:52:41

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
-- TOC entry 2941 (class 1262 OID 24597)
-- Name: FootFisi; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "FootFisi" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';


ALTER DATABASE "FootFisi" OWNER TO postgres;

\connect "FootFisi"

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
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 24600)
-- Name: mant_categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mant_categoria (
    id_categoria integer NOT NULL,
    "vMarca" text,
    "vGenero" text,
    "vTipo" text
);


ALTER TABLE public.mant_categoria OWNER TO postgres;

--
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE mant_categoria; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.mant_categoria IS 'Tabla para la categoría de los calzados';


--
-- TOC entry 202 (class 1259 OID 24598)
-- Name: mant_product_categoria_id_categoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mant_product_categoria_id_categoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mant_product_categoria_id_categoria_seq OWNER TO postgres;

--
-- TOC entry 2944 (class 0 OID 0)
-- Dependencies: 202
-- Name: mant_product_categoria_id_categoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mant_product_categoria_id_categoria_seq OWNED BY public.mant_categoria.id_categoria;


--
-- TOC entry 205 (class 1259 OID 24611)
-- Name: mant_talla; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mant_talla (
    id_talla integer NOT NULL,
    "vDescripcion" text
);


ALTER TABLE public.mant_talla OWNER TO postgres;

--
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE mant_talla; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.mant_talla IS 'Tabla para las tallas de los calzados';


--
-- TOC entry 204 (class 1259 OID 24609)
-- Name: mant_product_talla_id_talla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mant_product_talla_id_talla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mant_product_talla_id_talla_seq OWNER TO postgres;

--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 204
-- Name: mant_product_talla_id_talla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mant_product_talla_id_talla_seq OWNED BY public.mant_talla.id_talla;


--
-- TOC entry 207 (class 1259 OID 24622)
-- Name: mant_producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mant_producto (
    id_producto integer NOT NULL,
    "vNombre" text,
    "vDescripcion" text,
    "nPrecioUnitario" numeric,
    "nCantidad" integer,
    id_categoria integer,
    "vFoto" text NOT NULL
);


ALTER TABLE public.mant_producto OWNER TO postgres;

--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 207
-- Name: TABLE mant_producto; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.mant_producto IS 'Tabla destinada a los productos de Foot Fisi';


--
-- TOC entry 206 (class 1259 OID 24620)
-- Name: mant_producto_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mant_producto_id_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mant_producto_id_producto_seq OWNER TO postgres;

--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 206
-- Name: mant_producto_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mant_producto_id_producto_seq OWNED BY public.mant_producto.id_producto;


--
-- TOC entry 218 (class 1259 OID 24895)
-- Name: mant_producto_talla; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mant_producto_talla (
    id_producto integer NOT NULL,
    id_talla integer NOT NULL
);


ALTER TABLE public.mant_producto_talla OWNER TO postgres;

--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE mant_producto_talla; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.mant_producto_talla IS 'Tabla intermedia para los productos y sus tallas disponibles';


--
-- TOC entry 208 (class 1259 OID 24641)
-- Name: mant_tipo_documento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mant_tipo_documento (
    id_tipo_documento text NOT NULL,
    "vDescripcionLarga" text,
    "vDescripcionCorta" text
);


ALTER TABLE public.mant_tipo_documento OWNER TO postgres;

--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE mant_tipo_documento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.mant_tipo_documento IS 'Tabla destinada al registro de tipos de documentos
';


--
-- TOC entry 209 (class 1259 OID 24683)
-- Name: reg_persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reg_persona (
    id_tipo_documento text NOT NULL,
    "vNumeroDocumento" text NOT NULL,
    "vApellidoPaterno" text,
    "vApellidoMaterno" text,
    "vNombres" text
);


ALTER TABLE public.reg_persona OWNER TO postgres;

--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE reg_persona; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.reg_persona IS 'Tabla destinada al registro de las personas';


--
-- TOC entry 210 (class 1259 OID 24740)
-- Name: reg_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reg_cliente (
    "vDireccion" text,
    "vCelular" text,
    "vCorreoElectronico" text
)
INHERITS (public.reg_persona);


ALTER TABLE public.reg_cliente OWNER TO postgres;

--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE reg_cliente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.reg_cliente IS 'Tabla destinada al registro de los clientes';


--
-- TOC entry 217 (class 1259 OID 24871)
-- Name: reg_comprobante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reg_comprobante (
    id_comprobante integer NOT NULL,
    "vTipoComprobante" text,
    "dFecha" date,
    "vEstado" text
);


ALTER TABLE public.reg_comprobante OWNER TO postgres;

--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE reg_comprobante; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.reg_comprobante IS 'Tabla de los registros de los comprobantes';


--
-- TOC entry 216 (class 1259 OID 24869)
-- Name: reg_comprobante_id_comprobante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reg_comprobante_id_comprobante_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reg_comprobante_id_comprobante_seq OWNER TO postgres;

--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 216
-- Name: reg_comprobante_id_comprobante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reg_comprobante_id_comprobante_seq OWNED BY public.reg_comprobante.id_comprobante;


--
-- TOC entry 214 (class 1259 OID 24831)
-- Name: reg_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reg_pedido (
    id_pedido integer NOT NULL,
    "vTipoDocumentoCliente" text NOT NULL,
    "vNumeroDocumentoCliente" text NOT NULL,
    "nPrecioTotal" numeric,
    "dFechaCompra" date,
    "dFechaPago" date,
    "vEstado" text,
    "vTipoDocumentoTrabajador" text,
    "vNumeroDocumentoTrabajador" text,
    id_comprobante integer
);


ALTER TABLE public.reg_pedido OWNER TO postgres;

--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 214
-- Name: TABLE reg_pedido; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.reg_pedido IS 'Tabla destinada a los pedidos de los clientes';


--
-- TOC entry 213 (class 1259 OID 24829)
-- Name: reg_pedido_id_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reg_pedido_id_pedido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reg_pedido_id_pedido_seq OWNER TO postgres;

--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 213
-- Name: reg_pedido_id_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reg_pedido_id_pedido_seq OWNED BY public.reg_pedido.id_pedido;


--
-- TOC entry 215 (class 1259 OID 24851)
-- Name: reg_pedido_producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reg_pedido_producto (
    "id_Pedido" integer NOT NULL,
    "id_Producto" integer NOT NULL,
    "nCantidad" integer,
    "nSubTotal" numeric,
    "nIdTalla" integer
);


ALTER TABLE public.reg_pedido_producto OWNER TO postgres;

--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE reg_pedido_producto; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.reg_pedido_producto IS 'Tabla destinada al detalle del pedido';


--
-- TOC entry 211 (class 1259 OID 24746)
-- Name: reg_trabajador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reg_trabajador (
    "vTipoTrabajador" text
)
INHERITS (public.reg_persona);


ALTER TABLE public.reg_trabajador OWNER TO postgres;

--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 211
-- Name: TABLE reg_trabajador; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.reg_trabajador IS 'Tabla destinada al registro de trabajador';


--
-- TOC entry 212 (class 1259 OID 24783)
-- Name: seg_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seg_usuario (
    id_usuario text NOT NULL,
    id_tipo_documento text NOT NULL,
    "vNumeroDocumento" text NOT NULL,
    "vContrasenia" text
);


ALTER TABLE public.seg_usuario OWNER TO postgres;

--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 212
-- Name: TABLE seg_usuario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.seg_usuario IS 'Tabla destinada a los datos de los usuarios';


--
-- TOC entry 2750 (class 2604 OID 24603)
-- Name: mant_categoria id_categoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_categoria ALTER COLUMN id_categoria SET DEFAULT nextval('public.mant_product_categoria_id_categoria_seq'::regclass);


--
-- TOC entry 2752 (class 2604 OID 24625)
-- Name: mant_producto id_producto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_producto ALTER COLUMN id_producto SET DEFAULT nextval('public.mant_producto_id_producto_seq'::regclass);


--
-- TOC entry 2751 (class 2604 OID 24614)
-- Name: mant_talla id_talla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_talla ALTER COLUMN id_talla SET DEFAULT nextval('public.mant_product_talla_id_talla_seq'::regclass);


--
-- TOC entry 2754 (class 2604 OID 24874)
-- Name: reg_comprobante id_comprobante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_comprobante ALTER COLUMN id_comprobante SET DEFAULT nextval('public.reg_comprobante_id_comprobante_seq'::regclass);


--
-- TOC entry 2753 (class 2604 OID 24834)
-- Name: reg_pedido id_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido ALTER COLUMN id_pedido SET DEFAULT nextval('public.reg_pedido_id_pedido_seq'::regclass);


--
-- TOC entry 2920 (class 0 OID 24600)
-- Dependencies: 203
-- Data for Name: mant_categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.mant_categoria (id_categoria, "vMarca", "vGenero", "vTipo") VALUES (1, 'Adidas', 'Hombre', 'Zapatilla');
INSERT INTO public.mant_categoria (id_categoria, "vMarca", "vGenero", "vTipo") VALUES (2, 'Adidas', 'Mujer', 'Zapatilla');
INSERT INTO public.mant_categoria (id_categoria, "vMarca", "vGenero", "vTipo") VALUES (3, 'Caterpillar', 'Hombre', 'Zapato');
INSERT INTO public.mant_categoria (id_categoria, "vMarca", "vGenero", "vTipo") VALUES (4, 'Caterpillar', 'Mujer', 'Zapato');


--
-- TOC entry 2924 (class 0 OID 24622)
-- Dependencies: 207
-- Data for Name: mant_producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.mant_producto (id_producto, "vNombre", "vDescripcion", "nPrecioUnitario", "nCantidad", id_categoria, "vFoto") VALUES (1, 'Zapatos Mujer Caterpillar', 'Zapatos Mujer Caterpillar Kitson Srx St P304087-0 Miel P304087-0', 429, 100, 4, 'https://mercury.vteximg.com.br/arquivos/ids/747189-1000-1000/image-199ee62032184bfa88ddd62975206a5d.jpg?v=637085717145070000');
INSERT INTO public.mant_producto (id_producto, "vNombre", "vDescripcion", "nPrecioUnitario", "nCantidad", id_categoria, "vFoto") VALUES (2, 'Zapatillas Adidas', 'Zapatillas Adidas DAILY 2.0 F34469 Blanco', 137, 100, 1, 'https://mercury.vteximg.com.br/arquivos/ids/896451-1000-1000/shopStar-0.jpg?v=637134087722500000');


--
-- TOC entry 2935 (class 0 OID 24895)
-- Dependencies: 218
-- Data for Name: mant_producto_talla; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.mant_producto_talla (id_producto, id_talla) VALUES (1, 1);
INSERT INTO public.mant_producto_talla (id_producto, id_talla) VALUES (1, 2);
INSERT INTO public.mant_producto_talla (id_producto, id_talla) VALUES (1, 3);
INSERT INTO public.mant_producto_talla (id_producto, id_talla) VALUES (1, 4);
INSERT INTO public.mant_producto_talla (id_producto, id_talla) VALUES (2, 1);
INSERT INTO public.mant_producto_talla (id_producto, id_talla) VALUES (2, 2);
INSERT INTO public.mant_producto_talla (id_producto, id_talla) VALUES (2, 3);


--
-- TOC entry 2922 (class 0 OID 24611)
-- Dependencies: 205
-- Data for Name: mant_talla; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.mant_talla (id_talla, "vDescripcion") VALUES (1, 'Talla 36');
INSERT INTO public.mant_talla (id_talla, "vDescripcion") VALUES (2, 'Talla 37');
INSERT INTO public.mant_talla (id_talla, "vDescripcion") VALUES (3, 'Talla 38');
INSERT INTO public.mant_talla (id_talla, "vDescripcion") VALUES (4, 'Talla 39');
INSERT INTO public.mant_talla (id_talla, "vDescripcion") VALUES (5, 'Talla 40');
INSERT INTO public.mant_talla (id_talla, "vDescripcion") VALUES (6, 'Talla 41');


--
-- TOC entry 2925 (class 0 OID 24641)
-- Dependencies: 208
-- Data for Name: mant_tipo_documento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.mant_tipo_documento (id_tipo_documento, "vDescripcionLarga", "vDescripcionCorta") VALUES ('01', 'LIBRETA ELECTORAL O DNI', 'L.E / DNI');
INSERT INTO public.mant_tipo_documento (id_tipo_documento, "vDescripcionLarga", "vDescripcionCorta") VALUES ('06', 'REG. UNICO DE CONTRIBUYENTES', 'RUC');
INSERT INTO public.mant_tipo_documento (id_tipo_documento, "vDescripcionLarga", "vDescripcionCorta") VALUES ('07', 'PASAPORTE', 'PASAPORTE');
INSERT INTO public.mant_tipo_documento (id_tipo_documento, "vDescripcionLarga", "vDescripcionCorta") VALUES ('04', 'CARNET DE EXTRANJERIA', 'CARNET EXT.');


--
-- TOC entry 2927 (class 0 OID 24740)
-- Dependencies: 210
-- Data for Name: reg_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2934 (class 0 OID 24871)
-- Dependencies: 217
-- Data for Name: reg_comprobante; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2931 (class 0 OID 24831)
-- Dependencies: 214
-- Data for Name: reg_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2932 (class 0 OID 24851)
-- Dependencies: 215
-- Data for Name: reg_pedido_producto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2926 (class 0 OID 24683)
-- Dependencies: 209
-- Data for Name: reg_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2928 (class 0 OID 24746)
-- Dependencies: 211
-- Data for Name: reg_trabajador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2929 (class 0 OID 24783)
-- Dependencies: 212
-- Data for Name: seg_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 202
-- Name: mant_product_categoria_id_categoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mant_product_categoria_id_categoria_seq', 1, false);


--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 204
-- Name: mant_product_talla_id_talla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mant_product_talla_id_talla_seq', 1, false);


--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 206
-- Name: mant_producto_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mant_producto_id_producto_seq', 1, false);


--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 216
-- Name: reg_comprobante_id_comprobante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reg_comprobante_id_comprobante_seq', 1, false);


--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 213
-- Name: reg_pedido_id_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reg_pedido_id_pedido_seq', 1, false);


--
-- TOC entry 2760 (class 2606 OID 24630)
-- Name: mant_producto Primary_Key_Producto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_producto
    ADD CONSTRAINT "Primary_Key_Producto" PRIMARY KEY (id_producto);


--
-- TOC entry 2778 (class 2606 OID 24858)
-- Name: reg_pedido_producto Primary_Key_detalle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido_producto
    ADD CONSTRAINT "Primary_Key_detalle" PRIMARY KEY ("id_Pedido", "id_Producto");


--
-- TOC entry 2782 (class 2606 OID 24899)
-- Name: mant_producto_talla Primary_key_Producto_Talla; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_producto_talla
    ADD CONSTRAINT "Primary_key_Producto_Talla" PRIMARY KEY (id_producto, id_talla);


--
-- TOC entry 2764 (class 2606 OID 24648)
-- Name: mant_tipo_documento Primary_key_Tipo_Documento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_tipo_documento
    ADD CONSTRAINT "Primary_key_Tipo_Documento" PRIMARY KEY (id_tipo_documento);


--
-- TOC entry 2780 (class 2606 OID 24879)
-- Name: reg_comprobante Primary_key_comprobante; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_comprobante
    ADD CONSTRAINT "Primary_key_comprobante" PRIMARY KEY (id_comprobante);


--
-- TOC entry 2776 (class 2606 OID 24839)
-- Name: reg_pedido Primary_key_pedido; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido
    ADD CONSTRAINT "Primary_key_pedido" PRIMARY KEY (id_pedido);


--
-- TOC entry 2766 (class 2606 OID 24690)
-- Name: reg_persona Primary_key_persona; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_persona
    ADD CONSTRAINT "Primary_key_persona" PRIMARY KEY (id_tipo_documento, "vNumeroDocumento");


--
-- TOC entry 2774 (class 2606 OID 24790)
-- Name: seg_usuario Primary_key_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seg_usuario
    ADD CONSTRAINT "Primary_key_usuario" PRIMARY KEY (id_usuario);


--
-- TOC entry 2770 (class 2606 OID 24841)
-- Name: reg_cliente Unique_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_cliente
    ADD CONSTRAINT "Unique_cliente" UNIQUE (id_tipo_documento, "vNumeroDocumento") INCLUDE (id_tipo_documento, "vNumeroDocumento");


--
-- TOC entry 2768 (class 2606 OID 24772)
-- Name: reg_persona Unique_persona; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_persona
    ADD CONSTRAINT "Unique_persona" UNIQUE (id_tipo_documento, "vNumeroDocumento") INCLUDE (id_tipo_documento, "vNumeroDocumento");


--
-- TOC entry 2762 (class 2606 OID 24850)
-- Name: mant_producto Unique_producto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_producto
    ADD CONSTRAINT "Unique_producto" UNIQUE (id_producto) INCLUDE (id_producto);


--
-- TOC entry 2772 (class 2606 OID 24843)
-- Name: reg_trabajador Unique_trabajador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_trabajador
    ADD CONSTRAINT "Unique_trabajador" UNIQUE (id_tipo_documento, "vNumeroDocumento") INCLUDE (id_tipo_documento, "vNumeroDocumento");


--
-- TOC entry 2756 (class 2606 OID 24608)
-- Name: mant_categoria mant_product_categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_categoria
    ADD CONSTRAINT mant_product_categoria_pkey PRIMARY KEY (id_categoria);


--
-- TOC entry 2758 (class 2606 OID 24619)
-- Name: mant_talla mant_product_talla_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_talla
    ADD CONSTRAINT mant_product_talla_pkey PRIMARY KEY (id_talla);


--
-- TOC entry 2783 (class 2606 OID 24631)
-- Name: mant_producto Foreign_Key_Categoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_producto
    ADD CONSTRAINT "Foreign_Key_Categoria" FOREIGN KEY (id_categoria) REFERENCES public.mant_categoria(id_categoria);


--
-- TOC entry 2789 (class 2606 OID 24859)
-- Name: reg_pedido_producto Foreign_key_pedido; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido_producto
    ADD CONSTRAINT "Foreign_key_pedido" FOREIGN KEY ("id_Pedido") REFERENCES public.reg_pedido(id_pedido);


--
-- TOC entry 2790 (class 2606 OID 24864)
-- Name: reg_pedido_producto Foreign_key_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido_producto
    ADD CONSTRAINT "Foreign_key_producto" FOREIGN KEY ("id_Producto") REFERENCES public.mant_producto(id_producto);


--
-- TOC entry 2791 (class 2606 OID 24900)
-- Name: mant_producto_talla Foreign_key_producto_talla; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_producto_talla
    ADD CONSTRAINT "Foreign_key_producto_talla" FOREIGN KEY (id_producto) REFERENCES public.mant_producto(id_producto);


--
-- TOC entry 2792 (class 2606 OID 24905)
-- Name: mant_producto_talla Foreign_key_talla_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mant_producto_talla
    ADD CONSTRAINT "Foreign_key_talla_producto" FOREIGN KEY (id_talla) REFERENCES public.mant_talla(id_talla);


--
-- TOC entry 2784 (class 2606 OID 24691)
-- Name: reg_persona Foreign_key_tipo_documento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_persona
    ADD CONSTRAINT "Foreign_key_tipo_documento" FOREIGN KEY (id_tipo_documento) REFERENCES public.mant_tipo_documento(id_tipo_documento);


--
-- TOC entry 2787 (class 2606 OID 24885)
-- Name: reg_pedido Foreign_key_trabajador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido
    ADD CONSTRAINT "Foreign_key_trabajador" FOREIGN KEY ("vTipoDocumentoTrabajador", "vNumeroDocumentoTrabajador") REFERENCES public.reg_trabajador(id_tipo_documento, "vNumeroDocumento") NOT VALID;


--
-- TOC entry 2785 (class 2606 OID 24791)
-- Name: seg_usuario Foreign_key_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seg_usuario
    ADD CONSTRAINT "Foreign_key_usuario" FOREIGN KEY (id_tipo_documento, "vNumeroDocumento") REFERENCES public.reg_persona(id_tipo_documento, "vNumeroDocumento");


--
-- TOC entry 2786 (class 2606 OID 24844)
-- Name: reg_pedido Foreing_key_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido
    ADD CONSTRAINT "Foreing_key_cliente" FOREIGN KEY ("vTipoDocumentoCliente", "vNumeroDocumentoCliente") REFERENCES public.reg_cliente(id_tipo_documento, "vNumeroDocumento") NOT VALID;


--
-- TOC entry 2788 (class 2606 OID 24890)
-- Name: reg_pedido Foreing_key_comprobante; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reg_pedido
    ADD CONSTRAINT "Foreing_key_comprobante" FOREIGN KEY (id_comprobante) REFERENCES public.reg_comprobante(id_comprobante) NOT VALID;


-- Completed on 2020-02-16 09:52:42

--
-- PostgreSQL database dump complete
--

