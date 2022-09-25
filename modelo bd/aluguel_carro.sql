create database aluguel_carro;

use aluguel_carro;

CREATE TABLE cliente (
id_cliente INTEGER PRIMARY KEY auto_increment,
nome_cliente VARCHAR(80),
cidade_cliente VARCHAR(80),
cpf_cliente VARCHAR(11)
);

CREATE TABLE carro (
id_carro INTEGER PRIMARY KEY auto_increment,
modelo_carro VARCHAR(20),
placa_carro VARCHAR(7),
valor_aluguel_carro DECIMAL(5,2)
);

CREATE TABLE aluga (
id_aluguel INTEGER PRIMARY KEY auto_increment,
data_retirada DATE,
data_devolucao DATE,
valor_aluguel DECIMAL(5,2),
dias_aluguel integer,
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

insert into aluga (data_retirada, data_devolucao, valor_aluguel, dias_aluguel, id_cliente, id_carro) values 
('2022-09-10','2022-09-15', 75, 5, 1, 2),
('2022-09-14','2022-09-15', 50, 1, 2, 1);

create view aluga_cliente_carro as
select 
id_aluguel,
data_retirada,
data_devolucao,
valor_aluguel,
dias_aluguel,
c.*,
ca.*
from aluga a, cliente c, carro ca 
where a.id_cliente = c.id_cliente and a.id_carro = ca.id_carro
order by id_aluguel asc;

select * from cliente;
select * from carro;
select * from aluga;
select * from aluga_cliente_carro;

select * from cliente where cidade_cliente = 'Campinas';


