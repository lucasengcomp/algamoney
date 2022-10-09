CREATE TABLE lancamento (
  codigo BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(100) NOT NULL,
  data_vencimento DATETIME,
  data_pagamento DATETIME,
  valor DECIMAL(19,4) NOT NULL,
  observacao VARCHAR(100),
  tipo varchar(20) NOT NULL,
  codigo_categoria BIGINT(20) NOT NULL,
  codigo_pessoa BIGINT(20) NOT NULL,
  FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
  FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Salário mensal', '2022-06-10', NULL, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Bahamas', '2022-03-10', '2022-03-10', 100.32, NULL, 'DESPESA', 2, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Top Club', '2022-07-10', NULL, 120, NULL, 'RECEITA', 3, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('CEMIG', '2022-02-10', '2022-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('DMAE', '2022-06-10', NULL, 200.30, NULL, 'DESPESA', 3, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Extra', '2022-03-10', '2022-03-10', 1010.32, NULL, 'RECEITA', 3, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Bahamas', '2022-06-10', NULL, 500, NULL, 'RECEITA', 1, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Top Club', '2022-03-10', '2022-03-10', 400.32, NULL, 'DESPESA', 4, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Despachante', '2022-06-10', NULL, 123.64, 'Multas', 'DESPESA', 4, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Pneus', '2022-04-10', '2022-04-10', 665.33, NULL, 'RECEITA', 1, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Café', '2022-06-10', NULL, 8.32, NULL, 'DESPESA', 1, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Eletrônicos', '2022-04-10', '2022-04-10', 2100.32, NULL, 'DESPESA', 5, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Instrumentos', '2022-06-10', NULL, 1040.32, NULL, 'DESPESA', 4, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Café', '2022-04-10', '2022-04-10', 4.32, NULL, 'DESPESA', 4, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES ('Lanche', '2022-06-10', NULL, 10.20, NULL, 'DESPESA', 4, 1);
