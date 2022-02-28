create table categoria (codigo int primary key auto_increment not null, nome varchar(100) not null);

create table produto (
  codigo int primary key auto_increment, 
  nome varchar(100) not null,
  preco float(10,2) not null,
  codigo_categoria int not null
);

ALTER TABLE produto
    ADD CONSTRAINT prod_cat_fk FOREIGN KEY ( codigo_categoria )
        REFERENCES categoria ( codigo );