<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,br.pdv.model.ProdutoBean,br.pdv.model.ProdutoDao"%>

<%
    ProdutoBean prd = null; // objeto da classe bean getter e setter
    ProdutoDao pDao = new ProdutoDao();  // objeto da classe Dao 

    // este getAttribute esta recebendo o id vindo do vwListaCliente que por sua 
    //vez mandou a acao pra camada action com ConsultaCliente.java onde ele pegou 
    // o id do prdente e pesquisou prdente pelo seu id vindo da lista.
    if (null != request.getAttribute("id")) {
        prd = (ProdutoBean) request.getAttribute("id");
    }

%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>

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

                    <input type="hidden"  name="acao" value="<%=null != prd ? "AlteraProduto" : "AddProduto"%>" />
                    <input type="hidden"  name="id" value="<%=null != prd ? prd.getId() : ""%>" />

                    <fieldset class="fieldset">
                        <legend>Código.<%=null != prd ? prd.getId() : ""%> - Cadastro de Produtos </legend>

                        <div class="formulario">
                            <label class="labelFormulario">Descrição do Produto</label>
                            <input class="nome span4" name="descricao" type="text" placeholder="Descricao…"  value="<%=null != prd ? prd.getDescricao() : ""%>"   >
                        </div>
                        <div class="clear"></div>

                        <div class="formulario">
                            <div class="input-prepend input-append">
                                <label class="labelFormulario">Preço</label>                                
                                <span class="add-on">$</span>                         
                                <input class="span2" id="appendedPrependedInput" placeholder="Preço…"  name="preco_unitario" type="text" value="<%=null != prd ? prd.getPreco_unitario() : ""%>" >
                                <span class="add-on">.00</span>
                            </div>

                        </div>


                        <div class="clear"></div>

                        <% if (null != prd) {%>

                        <div class="formulario">
                            <label class="labelFormulario"></label>
                            <button class="btn btn-warning " type="submit"  ><%=null != prd ? "Alterar Cadastro " : "Novo Cadastro"%></button>
                        </div>
                        <% }%>



                        <% if (null == prd) {%>

                        <div class="formulario">
                            <label class="labelFormulario"></label>
                            <button class="btn btn-success " type="submit"  ><%=null != prd ? "Alterar Cadastro"  : "Gravar"%></button>
                        </div>
                        <% }%>

                        <div class="formulario">
                            <label class="labelFormulario"></label>
                            <a class="btn btn-info"  href="./?acao=NovoProduto" >Novo Produto</a>
                        </div>

                    </fieldset>
                </form>
            </div>
    </body>

</html>

