PGDMP     )                    z            proyectointegrador    13.7    14.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16413    proyectointegrador    DATABASE     q   CREATE DATABASE proyectointegrador WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
 "   DROP DATABASE proyectointegrador;
                postgres    false            ?            1259    16424    tbl_book    TABLE     ?   CREATE TABLE public.tbl_book (
    "idBook" integer NOT NULL,
    name character varying(40),
    category character varying(40),
    author character varying(40),
    age integer
);
    DROP TABLE public.tbl_book;
       public         heap    postgres    false            ?            1259    16422    tbl_book_idBook_seq    SEQUENCE     ?   CREATE SEQUENCE public."tbl_book_idBook_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public."tbl_book_idBook_seq";
       public          postgres    false    203            ?           0    0    tbl_book_idBook_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public."tbl_book_idBook_seq" OWNED BY public.tbl_book."idBook";
          public          postgres    false    202            ?            1259    16416    usuario    TABLE     ?   CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nombre character varying(45),
    apellido character varying(45),
    identificacion character varying(45),
    fecha_nacimiento character varying(30),
    email character varying(45)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            ?            1259    16414    usuario_id_usuario_seq    SEQUENCE     ?   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public          postgres    false    201            ?           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
          public          postgres    false    200            )           2604    16427    tbl_book idBook    DEFAULT     v   ALTER TABLE ONLY public.tbl_book ALTER COLUMN "idBook" SET DEFAULT nextval('public."tbl_book_idBook_seq"'::regclass);
 @   ALTER TABLE public.tbl_book ALTER COLUMN "idBook" DROP DEFAULT;
       public          postgres    false    203    202    203            (           2604    16419    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public          postgres    false    201    200    201            ?          0    16424    tbl_book 
   TABLE DATA           I   COPY public.tbl_book ("idBook", name, category, author, age) FROM stdin;
    public          postgres    false    203   h       ?          0    16416    usuario 
   TABLE DATA           h   COPY public.usuario (id_usuario, nombre, apellido, identificacion, fecha_nacimiento, email) FROM stdin;
    public          postgres    false    201   ?       ?           0    0    tbl_book_idBook_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public."tbl_book_idBook_seq"', 1, false);
          public          postgres    false    202            ?           0    0    usuario_id_usuario_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, false);
          public          postgres    false    200            -           2606    16429    tbl_book tbl_book_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tbl_book
    ADD CONSTRAINT tbl_book_pkey PRIMARY KEY ("idBook");
 @   ALTER TABLE ONLY public.tbl_book DROP CONSTRAINT tbl_book_pkey;
       public            postgres    false    203            +           2606    16421    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    201            ?      x?????? ? ?      ?      x?????? ? ?     