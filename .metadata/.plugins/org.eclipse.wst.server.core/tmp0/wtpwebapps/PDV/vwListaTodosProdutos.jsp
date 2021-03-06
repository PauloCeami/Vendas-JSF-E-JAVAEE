<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,br.pdv.model.ProdutoBean,br.pdv.model.ProdutoDao"%>

<%       
    ProdutoBean prd = null;
    ProdutoDao pDao = new ProdutoDao();
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>

        <style type="text/css">
            <%@ include  file="css/bootstrap.css"%>
        </style>

        <style type="text/css">
          
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
                <div class="fieldsetLista">
                    <legend>Lista de Produtos  <a class="btn btn-mini btn-info"  href="./?acao=NovoProduto" >Novo Produto</a></legend>                   

                    <table class="table table-condensed table-hover">
                        <thead>
                            <tr>
                                <th>Descrição</th>                                 
                                <th>$ Unitário</th>                             
                                <th colspan="4">Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (ProdutoBean pBean : pDao.ListaTodosProdutos()) {
                            %>
                            <tr>
                                <td><%=pBean.getDescricao() %></td>
                                <td><%=pBean.getPreco_unitario() %></td>                        
                                <td><a class="btn btn-mini btn-success" href="./?acao=ConsultaProduto&id=<%=pBean.getId()%>"> Alterar </a>   </td>
                                <td><a class="btn btn-mini btn-danger" href="javascript:if(confirm('Deseja excluir <%=pBean.getDescricao() %> do cadastro de Clientes ? ')){location='./?acao=RemoverProduto&id=<%=pBean.getId()%>&nome=<%=pBean.getDescricao() %>'};   "> Exluir </a>   </td>
                            </tr> 
                            <%  }%>  
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

