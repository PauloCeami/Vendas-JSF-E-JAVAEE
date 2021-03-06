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
        <title>Consulta de Produtos</title>

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
                    <legend>Consulta de Produtos </legend>                   
                    <form action="./?acao=ListaProdutosWhereLlike&like=ok" method="post" >
                        

                        <div class="formulario">
                            <label class="labelFormulario">Descrição do Produto</label>
                            <input class="nome span5" name="descricao" type="text" placeholder="Descricao…"  value=""   >
                        </div>
                        <div class="clear"></div>


                        <div class="formulario">
                            <label class="labelFormulario"></label>
                            <button class="btn btn-warning " type="submit"  >Pesquisar</button>
                        </div>

                    </form>

                    <%

                       if (null != request.getParameter("like")) {
        
 

                    %>

                    <table class="table table-condensed table-hover">
                        <thead>
                            <tr>
                                <th>Descrição</th>                                 
                                <th>$ Unitário</th>                             
                                <th colspan="3">Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                             

                                    for (ProdutoBean pBean : pDao.ListaProdutosWherelike(request.getParameter("descricao"))) {
                            %>
                            <tr>
                                <td><%=pBean.getDescricao()%></td>
                                <td><%=pBean.getPreco_unitario()%></td>                        
                                <td> <a class="btn btn-mini btn-info"  onclick="javascript:retorna('<%=pBean.getDescricao()%>', '<%=pBean.getId()%>','<%=pBean.getPreco_unitario()%>');"> C </a>  </td>                                  
                            </tr> 
                            <%  }
                                }
                            %>  
                        </tbody>
                    </table>


                </div>
            </div>
        </div>
        <script>

                function retorna(retorno, id,preco)

                {

                    window.opener.document.getElementById('IDPRODUTO').value = retorno;
                    window.opener.document.getElementById('IDPRODUTO2').value = id;
                    window.opener.document.getElementById('PRECO_UNITARIO').value = preco;

                    window.self.close();

                }



        </script>
    </body>
</html>

