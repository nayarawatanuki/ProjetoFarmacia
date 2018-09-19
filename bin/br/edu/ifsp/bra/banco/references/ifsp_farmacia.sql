drop database if exists ifsp_farmacia;
create database ifsp_farmacia;
use ifsp_farmacia;

create table pessoa (
	pessoa_id int not null auto_increment primary key,
	nome varchar(50) not null,
	cpf varchar(14) not null,
	data_nascimento date not null
);

insert into pessoa values
(1, 'Cliente', '123.456.789-01', '1990-09-09'),
(2, 'Atendente', '123.456.789-01', '1990-09-09'),
(3, 'Gerente', '123.456.789-01', '1990-09-09');

create table cliente (
	cliente_id int not null primary key references pessoa(pessoa_id),
	data_cadastro datetime not null
);

insert into cliente values
(1, now());

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
    login varchar(50) not null,
    senha varchar(256) not null,
    foreign key (tipo_id) references tipo_funcionario(tipo_id)
);

insert into funcionario values
(2, 1, 'atendente', '123'),
(3, 2, 'gerente', '123');