drop database if exists ifsp_farmacia;
create database ifsp_farmacia;
use ifsp_farmacia;

create table cliente (
	cliente_id int not null auto_increment primary key,
	nome varchar(50) not null,
    endereco varchar(150) not null,
    telefone varchar(20) not null,
	cpf varchar(14) not null,
	data_nascimento date not null,
	data_cadastro datetime not null default now()
);

INSERT INTO `cliente` VALUES
(1,'Noah Eduardo Arthur Carvalho','Rua Quinze, 213','(53) 3976-6306','524.349.761-40','1996-02-05','2018-11-28 19:13:23'),
(2,'Joaquim Antonio José Almada','Rua Novo Alvorecer, 747','(11) 2890-2584','387.798.265-47','1996-09-07','2018-11-28 19:13:23'),
(3,'Leandro Mário Novaes','Rua Governador Carlos Lacerda, 605','(71) 2676-3401','898.800.112-52','1996-08-06','2018-11-28 19:13:23'),
(4,'Augusto Yago Nelson dos Santos','Travessa Lisboa, 669','(95) 3627-0893','804.320.335-05','1996-05-25','2018-11-28 19:13:23'),
(5,'Raimundo Caleb Gabriel Barros','Rua Corinto Barbosa Lima, 100','(91) 3850-7326','725.995.665-84','1996-04-19','2018-11-28 19:13:23'),
(6,'Caleb Samuel João Drumond','Alameda das Algas, 631','(66) 3597-1085','199.372.867-86','1996-01-22','2018-11-28 19:13:23');

create table tipo_funcionario (
	tipo_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

insert into tipo_funcionario values
(1, 'Atendente'),
(2, 'Gerente');

create table funcionario (
	funcionario_id int not null auto_increment primary key,
    tipo_id int not null,
    usuario varchar(50) not null,
    senha varchar(256) not null,
	nome varchar(50) not null,
    endereco varchar(150) not null,
    telefone varchar(20) not null,
	cpf varchar(14) not null,
	data_nascimento date not null,
    foreign key (tipo_id) references tipo_funcionario(tipo_id)
);

INSERT INTO `funcionario` VALUES (1,1,'sebastiao','123','Sebastião Gael Vinicius Barbosa','Alameda Maridional, 655','(96) 3623-4697','759.555.494-20','1996-05-04'),
(2,2,'monteiro','123','Francisco Gael Raimundo Monteiro','Quadra Quadra 556, 467','(61) 2582-9531','315.967.513-04','1984-02-10');

create table caixa (
	caixa_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

insert into caixa values
(1, 'Caixa 1'),
(2, 'Caixa 2'),
(3, 'Caixa 3'),
(4, 'Caixa 4 (Preferencial)');

create table caixa_historico (
	historico_id int not null auto_increment primary key,
    caixa_id int not null,
    atendente_id int not null,
    valor_abertura double default 0,
    valor_fechamento double default 0,
    data_abertura datetime not null default now(),
    data_fechamento datetime default null,
    foreign key (atendente_id) references funcionario(funcionario_id)
);

insert into caixa_historico values (1, 1, 2, 100, 0, '2018-09-10', null);

create table tipo_medicamento (
	tipo_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

insert into tipo_medicamento values
(1, 'Pilula'),
(2, 'Capsula'),
(3, 'Dragea');

create table medicamento (
	medicamento_id int not null auto_increment primary key,
    tipo_id int not null,
    codigo varchar(50) not null,
    descricao varchar(150) not null,
    preco double not null,
    estoque int not null default 0,
    foreign key (tipo_id) references tipo_medicamento(tipo_id)
);

insert into medicamento values (1, 1, '123', 'Pilula A', 12.0, 20);

create table pedido_status (
	status_id int not null auto_increment primary key,
    `status` varchar(50) not null
);

insert into pedido_status values
(1, 'Aberto'),
(2, 'Finalizado'),
(3, 'Cancelado');

create table pedido (
	pedido_id int not null auto_increment primary key,
    caixa_id int not null,
    status_id int not null,
    total double not null,
    data datetime not null default now(),
    foreign key (caixa_id) references caixa(caixa_id),
    foreign key (status_id) references pedido_status(status_id)
);

insert into pedido values (1, 1, 2, 12, '2018-09-10');

create table itens_pedido (
	pedido_id int not null,
    medicamento_id int not null,
    quantidade int not null,
    valor_pago double not null,
    foreign key (pedido_id) references pedido(pedido_id),
    foreign key (medicamento_id) references medicamento(medicamento_id)
);

insert into itens_pedido values (1, 1, 1, 12.0);

create table tipo_pagamento (
	tipo_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

create table pagamento_cartao (
	pagamento_id int not null auto_increment primary key,
    cliente_id int,
    pedido_id int not null,
    desconto double not null,
    total double,
    conta varchar(50) not null,
    agencia varchar(50) not null,
    foreign key (pedido_id) references pedido(pedido_id)
);

insert into pagamento_cartao values (1, 1, 1, 0.0, 12.0, '123', '123');

create table pagamento_dinheiro (
	pagamento_id int not null auto_increment primary key,
    cliente_id int,
    pedido_id int not null,
    desconto double not null,
    total double,
    pago double not null,
    troco double not null,
    foreign key (pedido_id) references pedido(pedido_id)
);

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PesquisarClientes`(in filtro varchar(40))
BEGIN
 select * from cliente
 where `nome` LIKE CONCAT('%', filtro, '%')
        OR `cpf` LIKE CONCAT('%', filtro, '%');
END ;;
DELIMITER ;
