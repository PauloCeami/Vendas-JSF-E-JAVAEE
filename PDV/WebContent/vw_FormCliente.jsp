<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,br.pdv.model.ClienteBean,br.pdv.model.ClienteDao"%>

<%
    ClienteBean cli = null; // objeto da classe bean getter e setter
    ClienteDao cDao = new ClienteDao();  // objeto da classe Dao 

    // este getAttribute esta recebendo o id vindo do vwListaCliente que por sua 
    //vez mandou a acao pra camada action com ConsultaCliente.java onde ele pegou 
    // o id do cliente e pesquisou cliente pelo seu id vindo da lista.
    if (null != request.getAttribute("id")) {
        cli = (ClienteBean) request.getAttribute("id");
    }

%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>

        <style type="text/css">
            <%@ include  file="css/bootstrap.css"%>
        </style>

        <style type="text/css">
           
        </style>
        <style type="text/css">
            form label, form input {
                display: block;
                margin: 0 0 10px 0;
            }
            form input {
                height: 20px;   
            }

            label.error {
                border: 1px solid red;
                color: red;
                font-weight: bold;
                padding: 3px;
                background-color: #99CCFF;
                margin: 6px 0;
                width: 120px;
                text-align: center;
            }
        </style>   
    </head>
    <body>

        <%@ include file="Menu.jsp"  %>


        <div class="container">
            <div class="row">
                <div class="span10">
                    <table class="table">

                    </table>
                </div>
            </div>

            <div class="row">         
                <form action="." method="post">

                    <input type="hidden"  name="acao" value="<%=null != cli ? "AlteraCliente" : "AddCliente"%>" />
                    <input type="hidden"  name="id" value="<%=null != cli ? cli.getId() : ""%>" />

                    <fieldset class="fieldset">
                        <legend>Código.<%=null != cli ? cli.getId() : ""%> - Cadastro de Clientes </legend>

                        <div class="formulario">
                            <label class="labelFormulario">Nome Completo</label>
                            <input class="nome" name="Nome" type="text" placeholder="Nome…"  value="<%=null != cli ? cli.getNome() : ""%>"   >
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">Endereço do Cliente</label>
                            <input  class="endereco" name="Endereco" type="text" placeholder="Endereco…" value="<%=null != cli ? cli.getEndereco() : ""%>"  >
                        </div>

                        <div class="clear"></div>

                        <div class="formulario">
                            <label class="labelFormulario">Bairro</label>
                            <input class="bairro" name="Bairro" type="text" placeholder="Bairro…" value="<%=null != cli ? cli.getBairro() : ""%>">
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">Cidade</label>
                            <input  class="cidade" name="Cidade" type="text" placeholder="Cidade…" value="<%=null != cli ? cli.getCidade() : ""%>">
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">Estado</label>
                            <input class="estado" name="Estado" type="text" placeholder="Estado…" value="<%=null != cli ? cli.getEstado() : ""%>">
                        </div>

                        <div class="clear"></div>


                        <div class="formulario">
                            <label class="labelFormulario">Cep</label>
                            <input class="span2" name="Cep" type="text" placeholder="Cep…" value="<%=null != cli ? cli.getCep() : ""%>">
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">Telefone</label>
                            <input class="telefone" name="Telefone" type="text" placeholder="Telefone…" value="<%=null != cli ? cli.getTelefone() : ""%>">
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">Fax</label>
                            <input class="fax" name="Fax" type="text" placeholder="Telefone…" value="<%=null != cli ? cli.getFax() : ""%>">
                        </div>

                        <div class="clear"></div> 

                        <div class="formulario">
                            <label class="labelFormulario">Celular</label>
                            <input class="celular" name="Celular" type="text" placeholder="Celular…" value="<%=null != cli ? cli.getCelular() : ""%>">
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">CNPJ_CPF</label>
                            <input class="cnpj" name="CNPJ_CPF" type="text" placeholder="CNPJ_CPF…" value="<%=null != cli ? cli.getCNPJ_CPF() : ""%>">
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">Email</label>
                            <input class="email" name="Email" type="text" placeholder="Email…" value="<%=null != cli ? cli.getEmail() : ""%>">

                        </div>

                        <div class="clear"></div> 

                        <% if (null != cli) {%>

                        <div class="formulario">
                            <label class="labelFormulario"></label>
                            <button class="btn btn-warning " type="submit"  ><%=null != cli ? "Alterar Cadastro de " + cli.getNome() : "Novo Cadastro"%></button>
                        </div>
                        <% }%>



                        <% if (null == cli) {%>

                        <div class="formulario">
                            <label class="labelFormulario"></label>
                            <button class="btn btn-success " type="submit"  ><%=null != cli ? "Alterar Cadastro de " + cli.getNome() : "Gravar"%></button>
                        </div>
                        <% }%>

                        <div class="formulario">
                            <label class="labelFormulario"></label>
                            <a class="btn btn-info"  href="./?acao=NovoCliente" >Novo Registro</a>
                        </div>

                    </fieldset>
                </form>
            </div>
    </body>
    
</html>

