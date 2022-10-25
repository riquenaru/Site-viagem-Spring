create database site_viagem_com;

use site_viagem_com;

CREATE TABLE Login (
id_login INT(10) PRIMARY KEY AUTO_INCREMENT,
tipo_login VARCHAR(10)
);

CREATE TABLE destino (
destino VARCHAR(10) NOT NULL,
id_destino INT(10) PRIMARY KEY AUTO_INCREMENT,
data_viagem DATETIME
);

CREATE TABLE passagem (
preco DECIMAL (10),
id_passagem INT(10) PRIMARY KEY AUTO_INCREMENT,
id_destino INT(10),
FOREIGN KEY(id_destino) REFERENCES Destino (id_destino)
);

CREATE TABLE carrinho (
id_carrinho INT(10) PRIMARY KEY AUTO_INCREMENT,
qtd_itens INT(10),
total_compra DECIMAL(10),
data_compra DATETIME(6),
passagem VARCHAR(10),
id_passagem INT(10),
cpf_cnpj VARCHAR(18),
FOREIGN KEY(id_passagem) REFERENCES passagem (id_passagem)
);

CREATE TABLE usuario (
senha VARCHAR(10),
email VARCHAR(10),
cpf_cnpj VARCHAR(18) PRIMARY KEY,
id_login INT(10),
FOREIGN KEY(id_login) REFERENCES login (id_login)
);

ALTER TABLE carrinho ADD FOREIGN KEY(cpf_cnpj) REFERENCES usuario (cpf_cnpj);

select * FROM passagem;