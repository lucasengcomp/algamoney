use algamoney;

CREATE TABLE lancamento (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(10, 2) NOT NULL,
    observacao VARCHAR(100),
    tipo VARCHAR(20) NOT NULL,
    codigo_categoria BIGINT(20) NOT NULL,
    codigo_pessoa BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_categoria) REFERENCES categoria (codigo),
    FOREIGN KEY (codigo_pessoa) REFERENCES pessoa (codigo)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Café', '2022-03-12', null, 8.32, null, 'DESPESA', 1, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Pneus', '2022-04-12', '2022-04-12', 665.33, null, 'RECEITA', 5, 10);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Café', '2022-04-12', '2022-04-12', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('CEMIG', '2022-02-12', '2022-02-12', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('DMAE', '2022-03-12', null, 200.30, null, 'DESPESA', 3, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Extra', '2022-03-12', '2022-03-12', 1010.32, null, 'RECEITA', 4, 6);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Top Club', '2022-03-12', '2022-03-12', 400.32, null, 'DESPESA', 4, 8);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Bahamas', '2022-03-12', null, 500, null, 'RECEITA', 1, 7);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Despachante', '2022-03-12', null, 123.64, 'Multas', 'DESPESA', 3, 9);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Instrumentos', '2022-03-12', null, 1040.32, null, 'DESPESA', 4, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Bahamas', '2022-02-12', '2022-02-12', 100.32, null, 'DESPESA', 2, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Salário mensal', '2022-03-12', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Eletrônicos', '2022-04-12', '2022-04-12', 2100.32, null, 'DESPESA', 5, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Top Club', '2022-03-12', null, 120, null, 'RECEITA', 3, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Lanche', '2022-03-12', null, 10.20, null, 'DESPESA', 4, 1);
