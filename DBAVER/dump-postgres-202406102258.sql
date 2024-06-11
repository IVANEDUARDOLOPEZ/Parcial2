PGDMP  *    :        
        |            postgres    16.2 (Debian 16.2-1.pgdg120+2)    16.3     1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            4           1262    5    postgres    DATABASE     s   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE postgres;
                postgres    false            5           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3380                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            6           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    16389    alumno    TABLE     ~   CREATE TABLE public.alumno (
    id integer NOT NULL,
    nombre character varying(100),
    carnet character varying(100)
);
    DROP TABLE public.alumno;
       public         heap    postgres    false    4            �            1259    16388    alumno_id_seq    SEQUENCE     �   CREATE SEQUENCE public.alumno_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.alumno_id_seq;
       public          postgres    false    4    216            7           0    0    alumno_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.alumno_id_seq OWNED BY public.alumno.id;
          public          postgres    false    215            �            1259    24591    inscripcion    TABLE     �   CREATE TABLE public.inscripcion (
    id integer NOT NULL,
    alumno_id integer NOT NULL,
    materia_id integer NOT NULL,
    ciclo character varying(50),
    anio integer,
    fecha_inscripcion date
);
    DROP TABLE public.inscripcion;
       public         heap    postgres    false    4            �            1259    24590    inscripciones_id_seq    SEQUENCE     �   CREATE SEQUENCE public.inscripciones_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.inscripciones_id_seq;
       public          postgres    false    4    220            8           0    0    inscripciones_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.inscripciones_id_seq OWNED BY public.inscripcion.id;
          public          postgres    false    219            �            1259    24577    materia    TABLE     �   CREATE TABLE public.materia (
    id integer NOT NULL,
    nombremat character varying(255) NOT NULL,
    descripcion text,
    codigo_materia character varying(50) NOT NULL
);
    DROP TABLE public.materia;
       public         heap    postgres    false    4            �            1259    24576    materia_id_seq    SEQUENCE     �   CREATE SEQUENCE public.materia_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.materia_id_seq;
       public          postgres    false    4    218            9           0    0    materia_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.materia_id_seq OWNED BY public.materia.id;
          public          postgres    false    217            �           2604    16392 	   alumno id    DEFAULT     f   ALTER TABLE ONLY public.alumno ALTER COLUMN id SET DEFAULT nextval('public.alumno_id_seq'::regclass);
 8   ALTER TABLE public.alumno ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216            �           2604    24594    inscripcion id    DEFAULT     r   ALTER TABLE ONLY public.inscripcion ALTER COLUMN id SET DEFAULT nextval('public.inscripciones_id_seq'::regclass);
 =   ALTER TABLE public.inscripcion ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    220    220            �           2604    24580 
   materia id    DEFAULT     h   ALTER TABLE ONLY public.materia ALTER COLUMN id SET DEFAULT nextval('public.materia_id_seq'::regclass);
 9   ALTER TABLE public.materia ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    218    218            *          0    16389    alumno 
   TABLE DATA           4   COPY public.alumno (id, nombre, carnet) FROM stdin;
    public          postgres    false    216   r        .          0    24591    inscripcion 
   TABLE DATA           `   COPY public.inscripcion (id, alumno_id, materia_id, ciclo, anio, fecha_inscripcion) FROM stdin;
    public          postgres    false    220   �        ,          0    24577    materia 
   TABLE DATA           M   COPY public.materia (id, nombremat, descripcion, codigo_materia) FROM stdin;
    public          postgres    false    218   !       :           0    0    alumno_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.alumno_id_seq', 25, true);
          public          postgres    false    215            ;           0    0    inscripciones_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.inscripciones_id_seq', 1, true);
          public          postgres    false    219            <           0    0    materia_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.materia_id_seq', 19, true);
          public          postgres    false    217            �           2606    16394    alumno alumno_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.alumno DROP CONSTRAINT alumno_pkey;
       public            postgres    false    216            �           2606    24596    inscripcion inscripciones_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT inscripciones_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.inscripcion DROP CONSTRAINT inscripciones_pkey;
       public            postgres    false    220            �           2606    24586 "   materia materia_codigo_materia_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.materia
    ADD CONSTRAINT materia_codigo_materia_key UNIQUE (codigo_materia);
 L   ALTER TABLE ONLY public.materia DROP CONSTRAINT materia_codigo_materia_key;
       public            postgres    false    218            �           2606    24584    materia materia_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.materia
    ADD CONSTRAINT materia_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.materia DROP CONSTRAINT materia_pkey;
       public            postgres    false    218            �           2606    24597    inscripcion fk_alumno    FK CONSTRAINT     w   ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT fk_alumno FOREIGN KEY (alumno_id) REFERENCES public.alumno(id);
 ?   ALTER TABLE ONLY public.inscripcion DROP CONSTRAINT fk_alumno;
       public          postgres    false    216    3217    220            �           2606    24602    inscripcion fk_materia    FK CONSTRAINT     z   ALTER TABLE ONLY public.inscripcion
    ADD CONSTRAINT fk_materia FOREIGN KEY (materia_id) REFERENCES public.materia(id);
 @   ALTER TABLE ONLY public.inscripcion DROP CONSTRAINT fk_materia;
       public          postgres    false    3221    218    220            *   M   x�3��,K�S��/H���	12220��2�t�I�J�K)JT�M��L����r�r�e&g�tYZXZq��qqq 3G<      .   8   x�3�4B���|CN##0�k`�kh�eh�i�6��H[r�⑏���� ��t      ,   B   x�3�t��K̫J,��M,I-�LL*M�K�tsts�2��v	���K�SH�I��+��44A�=... SIU     