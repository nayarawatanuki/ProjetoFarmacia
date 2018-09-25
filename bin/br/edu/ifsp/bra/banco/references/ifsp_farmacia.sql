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
(2, 'Atendente', 'Rua João Pedro Veloso, 1046', '(11) 99411-2210',  '123.456.789-01', '1990-09-09'),
(3, 'Gerente', 'Avenida João Inácio, 940', '(11) 2477-1756',  '123.456.789-01', '1990-09-09');

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

create table tipo_medicamento (
	tipo_id int not null auto_increment primary key,
    descricao varchar(50) not null
);

insert into tipo_medicamento values
(1, 'Pílula'),
(2, 'Cápsula'),
(3, 'Drágea');

create table medicamento (
	medicamento_id int not null auto_increment primary key,
    tipo_id int not null,
    codigo varchar(50) not null,
    descricao varchar(150) not null,
    preco double not null,
    estoque int not null default 0,
    foreign key (tipo_id) references tipo_medicamento(tipo_id)
);

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
    total double not null,
    data datetime not null default now(),
    foreign key (caixa_id) references caixa(caixa_id)
);

create table itens_pedido (
	pedido_id int not null,
    produto_id int not null,
    quantidade int not null,
    total double not null,
    primary key (pedido_id, produto_id),
    foreign key (pedido_id) references pedido(pedido_id),
    foreign key (produto_id) references produto(produto_id)
);

create table pagamento (
	pagamento_id int not null auto_increment primary key,
    pedido_id int not null,
    desconto double not null,
    total double,
    foreign key (pedido_id) references pedido(pedido_id)
);

create table pagamento_cartao (
	pagamento_id int not null primary key references pagamento(pagamento_id),
    conta varchar(50) not null,
    agencia varchar(50) not null
);

create table pagamento_dinheiro (
	pagamento_id int not null primary key references pagamento(pagamento_id),
    pago double not null,
    troco double not null
);