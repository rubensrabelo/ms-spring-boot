CREATE TABLE tb_client (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(50) NOT NULL,
                           cpf VARCHAR(14),
                           email VARCHAR(255) NOT NULL
);