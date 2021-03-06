
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,
    br.pdv.model.ClienteBean,
    br.pdv.model.ClienteDao



    "%>

<%
    ClienteBean cli = null;
    ClienteDao cDao = new ClienteDao();
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
                    <legend>Consulta Pedido do Cliente </legend>                   
                    <form action="./?acao=ListaClientesWhereLlike&like=ok" method="post" >


                        <div class="formulario">
                            <label class="labelFormulario">Nome do Cliente</label>
                            <input class="span5" name="nome" type="text" placeholder="Nome Cliente…"  value=""   >
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
                                <th>id</th>                                 
                                <th>Nome Cliente</th>                             
                                <th>Cidade</th>                             
                                <th>CPF / CNPJ</th>                             

                                <th colspan="3">Ver</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (ClienteBean cBean : cDao.vwListaClientesWhereLlike(request.getParameter("nome"))) {
                            %>
                            <tr>

                                <td><%=cBean.getId()%></td>
                                <td><%=cBean.getNome()%></td>
                                <td><%=cBean.getCidade()%></td>                                
                                <td><%=cBean.getCNPJ_CPF()%></td>
                                <td> <a class="btn btn-mini btn-inverse" href="./?acao=ConsultaPedidosCliente&idCliente=<%=cBean.getId()%>&nome=<%=cBean.getNome()%>" >Meus Pedidos</a>  </td>  
                            </tr> 
                            <%  }
                                }
                            %>  
                        </tbody>
                    </table>


                </div>
            </div>
        </div>

    </body>
</html>

