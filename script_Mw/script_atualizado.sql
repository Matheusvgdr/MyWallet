CREATE DATABASE db_myWallet;

use db_myWallet;

CREATE TABLE tb_users(
id int primary key auto_increment,
personName varchar(250),
userName varchar(250) NOT NULL,
cpf varchar(250) NOT NULL,
userPassword varchar(250) NOT NULL
);

CREATE TABLE tb_wallet(
id int primary key auto_increment,
nameWallet varchar(80) NOT NULL,
budget double NOT NULL,
id_user int
);

CREATE TABLE tb_movimentation(
id int primary key auto_increment,
moviDate varchar(50),
money double NOT NULL,
typeMovi varchar(100) NOT NULL,
id_user int ,
id_type int
);


CREATE TABLE tb_typeMovi(
id int primary key auto_increment,
description varchar(100)
);

-- PARA ALTERAR AS TABELAS ------------------------------
ALTER TABLE tb_wallet ADD COLUMN id_user INTEGER;
ALTER TABLE tb_movimentation ADD COLUMN id_user INTEGER;
ALTER TABLE tb_movimentation ADD COLUMN id_type INTEGER;

-- FAZER A CONEXÃO DAS CHAVES ESTRANGEIRAS -------------------------------------------------------
ALTER TABLE tb_wallet ADD CONSTRAINT fk_userW FOREIGN KEY(id_user) REFERENCES tb_users(id);
ALTER TABLE tb_movimentation ADD CONSTRAINT fk_user FOREIGN KEY(id_user) REFERENCES tb_users(id);
ALTER TABLE tb_movimentation ADD CONSTRAINT fk_us FOREIGN KEY(id_type) REFERENCES tb_typeMovi(id);

INSERT INTO tb_typeMovi (description) VALUES("Deposito");
INSERT INTO tb_typeMovi (description) VALUES("Saque");

-- INSERTS USERS -----------------------------------------------

INSERT INTO tb_users( personName, userName, cpf, userPassword)
VALUES ( "Matheus", "Maths", "125.425.425-51", "12345");

INSERT INTO tb_users( personName, userName, cpf, userPassword)
VALUES ( "Sarah", "sa", "125.425.425-51", "12345");


-- INSERTS MOVIMENTATION ------------------------------------------
INSERT INTO tb_movimentation (moviDate, money,  typeMovi, id_user, id_type) VALUES ("20.05.2022", 52.35,  "deposito", 1, 1);
INSERT INTO tb_movimentation (moviDate, money,  typeMovi, id_user, id_type) VALUES ("20.05.2022", 52.35, "deposito", 1, 2);
INSERT INTO tb_movimentation (moviDate, money,  typeMovi, id_user, id_type) VALUES ("20.05.2022", 52.35,  "deposito", 1, 2);
INSERT INTO tb_movimentation (moviDate, money,  typeMovi, id_user, id_type) VALUES ("20.05.2022", 52.35,  "deposito", 1, 1);

SELECT * FROM tb_users;
SELECT * FROM tb_wallet;
SELECT * FROM tb_typeMovi;
SELECT * FROM tb_movimentation;

SELECT M.money , U.userName, T.description FROM tb_movimentation M INNER JOIN tb_users U ON U.id = M.id_user
														  INNER JOIN tb_typeMovi T ON T.id = M.id_type
														  WHERE T.id = 2;


