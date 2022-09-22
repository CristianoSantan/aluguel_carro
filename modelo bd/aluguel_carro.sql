create database aluguel_carro;

use aluguel_carro;

CREATE TABLE cliente (
nome_cliente VARCHAR(80),
id_cliente INTEGER PRIMARY KEY auto_increment,
cidade_cliente VARCHAR(80),
cpf_cliente VARCHAR(11)
);

CREATE TABLE carro (
modelo_carro VARCHAR(20),
placa_carro VARCHAR(7),
id_carro INTEGER PRIMARY KEY auto_increment,
valor_aluguel_carro DECIMAL(5,2)
);

CREATE TABLE aluga (
data_retirada DATETIME,
data_devolucao DATETIME,
valor_aluguel DECIMAL(5,2),
id_aluguel INTEGER PRIMARY KEY auto_increment,
id_cliente INTEGER,
id_carro INTEGER,
FOREIGN KEY(id_cliente) REFERENCES cliente (id_cliente),
FOREIGN KEY(id_carro) REFERENCES carro (id_carro)
);

insert into cliente (nome_cliente, cidade_cliente, cpf_cliente) values 
('João Silva', 'Campinas', '12345678910'),
('Maria Siqueira', 'Suzano', '98765432110');

insert into carro (modelo_carro, placa_carro, valor_aluguel_carro) values 
('compass', 'lkj1234', 25),
('ka', 'poi4321', 12);

insert into aluga (data_retirada, data_devolucao, valor_aluguel, id_cliente, id_carro) values 
('2022-09-10','2022-09-15', 75, 1, 2),
('2022-09-14','2022-09-15', 50, 2, 1);

select * from cliente;
select * from carro;
select * from aluga;

select * from cliente where cidade_cliente = 'Campinas';

select * from aluga a, 
cliente cli, 
carro ca 
where a.id_cliente = cli.id_cliente 
and a.id_carro = ca.id_carro;
