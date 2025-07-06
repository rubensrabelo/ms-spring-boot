CREATE TABLE tb_product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    unit_value NUMERIC(10, 2) NOT NULL,
    quantity INTEGER NOT NULL
);