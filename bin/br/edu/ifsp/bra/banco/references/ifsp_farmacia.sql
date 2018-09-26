drop database if exists ifsp_farmacia;
create database ifsp_farmacia;
use ifsp_farmacia;

create table pessoa (
	pessoa_id int not null auto_increment primary key,
	nome varchar(50) not null,
    endereco varchar(150) not null,
    telefone varchar(20) not null,
	cpf varchar(14) not null,
	data_nascimento date not null
);

insert into pessoa values
(1, 'Cliente', 'Rua Fulano Beltrano, 476', '(11) 4033-4909', '123.456.789-01', '1990-09-09'),
(2, 'Atendente', 'Rua Jo√£o Pedro Veloso, 1046', '(11) 99411-2210',  '123.456.789-01', '1990-09-09'),
(3, 'Gerente', 'Avenida Jo√£o In√°cio, 940', '(11) 2477-1756',  '123.456.789-01', '1990-09-09');

create table cliente (
	cliente_id int not null primary key references pessoa(pessoa_id),
    is_ativo boolean not null default true,
	data_cadastro datetime not null default now()
);

insert into cliente values
(1, true, now());

create table tipo_funcionario (
	tipo_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

insert into tipo_funcionario values
(1, 'Atendente'),
(2, 'Gerente');

create table funcionario (
	funcionario_id int not null primary key references funcionario(funcionario_id),
    tipo_id int not null,
    usuario varchar(50) not null,
    senha varchar(256) not null,
    foreign key (tipo_id) references tipo_funcionario(tipo_id)
);

insert into funcionario values
(2, 1, 'atendente', '123'),
(3, 2, 'gerente', '123');

create table caixa (
	caixa_id int not null auto_increment primary key,
    atendente_id int not null,
    is_aberto boolean not null default false,
    data_abertura datetime not null default now(),
    data_fechamento datetime default null,
    foreign key (atendente_id) references funcionario(funcionario_id)
);

insert into caixa values (1, 2, true, '2018-09-10', null);

create table tipo_medicamento (
	tipo_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

insert into tipo_medicamento values
(1, 'PÌlula'),
(2, 'C·psula'),
(3, 'Dr·gea');

create table medicamento (
	medicamento_id int not null auto_increment primary key,
    tipo_id int not null,
    codigo varchar(50) not null,
    descricao varchar(150) not null,
    preco double not null,
    estoque int not null default 0,
    foreign key (tipo_id) references tipo_medicamento(tipo_id)
);

insert into medicamento values (1, 1, '123', 'PÌlula A', 12.0, 20);

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
    total double not null,
    primary key (pedido_id, medicamento_id),
    foreign key (pedido_id) references pedido(pedido_id),
    foreign key (medicamento_id) references medicamento(medicamento_id)
);

insert into itens_pedido values (1, 1, 1, 12.0);

create table tipo_pagamento (
	tipo_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

create table pagamento (
	pagamento_id int not null auto_increment primary key,
    pedido_id int not null,
    desconto double not null,
    total double,
    foreign key (pedido_id) references pedido(pedido_id)
);

insert into pagamento values (1, 1, 0.0, 12.0);

create table pagamento_cartao (
	pagamento_id int not null primary key references pagamento(pagamento_id),
    conta varchar(50) not null,
    agencia varchar(50) not null
);

insert into pagamento_cartao values (1, '123', '123');

create table pagamento_dinheiro (
	pagamento_id int not null primary key references pagamento(pagamento_id),
    pago double not null,
    troco double not null
);