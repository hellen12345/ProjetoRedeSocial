create table usuario(
nome varchar (100),
email varchar (200) unique primary key,
senha varchar (20),
profissao varchar (50),
data_nascimento datestamp
);

create table livro(
nome varchar(100) unique primary key,
autor varchar(100),
resumo varchar(10000),
editora varchar(100),
genero varchar(50),
ano_publicacao int
);