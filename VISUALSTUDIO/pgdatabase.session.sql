CREATE TABLE materia (
    id serial PRIMARY KEY,
    nombremat VARCHAR(255) NOT NULL,
    descripcion TEXT,
    codigo_materia VARCHAR(50) NOT NULL UNIQUE
);
