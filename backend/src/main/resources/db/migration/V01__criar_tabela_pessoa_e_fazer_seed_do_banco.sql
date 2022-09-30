CREATE TABLE pessoa (
	codigo BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	logradouro varchar(100) NULL,
	numero varchar(10) NULL,
	complemento varchar(40) NULL,
	bairro varchar(30) NULL,
	cep varchar(14) NULL,
	cidade varchar(50) NULL,
	estado varchar(2) NULL,
	ativo boolean NOT NULL,
	PRIMARY KEY (codigo)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_croatian_ci
AUTO_INCREMENT=1;

CREATE FULLTEXT INDEX pessoa_nome_IDX ON pessoa (nome);
CREATE INDEX pessoa_codigo_IDX USING BTREE ON pessoa (codigo);


INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo)
VALUES('Davi Raimundo Fogaça','41320-800','Rua Antonio Carlos Monteiro Teixeira',821,'Castelo Branco','Salvador','BA', true);

INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo);
VALUES	 ('Carolina Gabrielly Francisca Costa','39400-040','Avenida Armênio Veloso',92,'Centro','Montes Claros','MG', true);

INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo);
VALUES	 ('Arthur Davi da Conceição','99714-206','Rua Honorato Novello',382,'Presidente Vargas','Erechim','RS', true);

INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo);
VALUES	 ('Julio Alexandre Cavalcanti','09930-427','Travessa Sabiá',958,'Taboão','Diadema','SP', true);

INSERT INTO pessoa (nome,cep,logradouro,numero,bairro,cidade,estado,ativo)
VALUES ('Ana Rafaela Teresinha Lima','52080-440','Rua Tejipió',31,'Alto José Bonifácio','Recife','PE', true);