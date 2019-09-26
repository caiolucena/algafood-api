insert into COZINHA (ID, NOME) values (1, 'Tailandesa');
insert into COZINHA (ID, NOME) values (2, 'Indiana');

insert into RESTAURANTE (ID, NOME, TAXA_FRETE, COZINHA_ID) values (1, 'Thai Gourmet', 10, 1);
insert into RESTAURANTE (ID, NOME, TAXA_FRETE, COZINHA_ID) values (2, 'Thai Delivery', 9.50, 1);
insert into RESTAURANTE (ID, NOME, TAXA_FRETE, COZINHA_ID) values (3, 'Tuk Tuk ComIDa Indiana', 15, 2);

insert into ESTADO (ID, NOME) values (1, 'Minas Gerais');
insert into ESTADO (ID, NOME) values (2, 'São Paulo');
insert into ESTADO (ID, NOME) values (3, 'Ceará');

insert into CIDADE (ID, NOME, ESTADO_ID) values (1, 'Uberlândia', 1);
insert into CIDADE (ID, NOME, ESTADO_ID) values (2, 'Belo Horizonte', 1);
insert into CIDADE (ID, NOME, ESTADO_ID) values (3, 'São Paulo', 2);
insert into CIDADE (ID, NOME, ESTADO_ID) values (4, 'Campinas', 2);
insert into CIDADE (ID, NOME, ESTADO_ID) values (5, 'Fortaleza', 3);

insert into FORMA_PAGAMENTO (ID, DESCRICAO) values (1, 'Cartão de crédito');
insert into FORMA_PAGAMENTO (ID, DESCRICAO) values (2, 'Cartão de débito');
insert into FORMA_PAGAMENTO (ID, DESCRICAO) values (3, 'Dinheiro');

insert into PERMISSAO (ID, NOME, DESCRICAO) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar COZINHAs');
insert into PERMISSAO (ID, NOME, DESCRICAO) values (2, 'EDITAR_COZINHAS', 'Permite editar COZINHAs');