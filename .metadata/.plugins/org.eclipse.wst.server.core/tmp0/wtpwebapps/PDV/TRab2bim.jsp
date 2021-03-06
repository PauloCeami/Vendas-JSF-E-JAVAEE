<%-- 
    Document   : TRab2bim
    Created on : 25/05/2013, 09:26:12
    Author     : Analista
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>UNIVERSIDADE DE FRANCA
Sistemas de informação – 5º sem – 2013
Programação para Internet I
DATA PARA ENTREGA: 27/05/2013
Realizados, utilizando Java/JSP/MySQL.


1) A base de dados utilizada deve ser criada a partir do arquivo
TRAB2BIM.sql que será fornecido pelo professor.

2) A aplicação deverá restringir o acesso apenas à usuários
autorizados, que deverão estar cadastrados na tabela USUARIOS (ID,      ok 
NOME, EMAIL, SENHA(hash))


3) A aplicação deverá implementar um CADASTRO de CLIENTES (ID,
NOME, ENDERECO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE, FAX,
CELULAR, CNPJ_CPF, EMAIL). Deverá estar disponível recursos para o       ok
gerenciamento deste cadastro (INCLUSÃO, EXCLUSÃO, ALTERAÇÃO).

8) A aplicação deverá permitir a emissão de listagem de CLIENTES POR
CIDADE, mostrando nessa listagem: ID E NOME e permitindo que, ao
se clicar no NOME do cliente, sejam mostrados os dados completos          ok
deste CLIENTE (ID, NOME, ENDERECO, BAIRRO, CIDADE, ESTADO, CEP,
TELEFONE, FAX, CELULAR, CNPJ_CPF, EMAIL).


4) A aplicação deverá implementar um CADASTRO de REPRESENTANTES
(ID, NOME, ENDERECO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE,
FAX, CELULAR, CNPJ_CPF, CONTATO, EMAIL). Deverá estar disponível          ok
recursos para o gerenciamento deste cadastro (INCLUSÃO, EXCLUSÃO,
ALTERAÇÃO).
--------------------------------------------------------------------------------------
5) A aplicação deverá implementar um CADASTRO de PRODUTOS (ID,
DESCRICAO, PRECO_UNITARIO). Deverão estar disponíveis recursos            ok
para o gerenciamento deste cadastro (INCLUSÃO, EXCLUSÃO,
ALTERAÇÃO).

9) A aplicação deverá permitir a emissão de listagem de PRODUTOS,        ok
mostrando nessa listagem: ID, DESCRICAO E PRECO_UNITARIO.

---------------------------------------------------------------------------------------
6) A aplicação deverá implementar um CADASTRO de PEDIDOS (ID,
DATA_PEDIDO, DATA_ENTREGA, CLIENTEID, REPRESENTANTEID).
Deverão estar disponíveis recursos para o gerenciamento deste             ok 
cadastro (INCLUSÃO, EXCLUSÃO, ALTERAÇÃO)

7) A aplicação deverá implementar um CADASTRO com a relação de
produtos por pedido: PRODUTOS_PEDIDO (PEDIDOID, PRODUTOID,                ok
QUANTIDADE, PRECO_UNITARIO).-

-----------------------------------------------------------------------------------------


10) A aplicação deverá permitir a emissão de listagem de PEDIDOS POR
CLIENTE, mostrando nesta listagem: ID, DATA_DO_PEDIDO,
DATA_DA_ENTREGA, VALOR_TOTAL_DO_PEDIDO                                    ok


e permitindo que , ao
se clicar no ID do pedido, sejam mostrados os dados completos deste
PEDIDO (ID, DATA_PEDIDO, DATA_ENTREGA, NOME_DO_CLIENTE,
NOME_DO_REPRESENTANTE e a lista de PRODUTOS do pedido com: ID,
DESCRICAO, PRECO_UNITARIO, PRECO_TOTAL_DO_PRODUTO, bem
como o VALOR_TOTAL_DO_PEDIDO.
        


        </h3>
    </body>
</html>
