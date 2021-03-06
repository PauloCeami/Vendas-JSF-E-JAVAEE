<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,
    br.pdv.model.PedidoBean,
    br.pdv.model.PedidoDao,
    br.pdv.model.ItensVendaBean,
    br.pdv.model.ItensVendaDao,
    br.util.Conv

    "%>

<%
    PedidoBean ped = null;
    PedidoDao pDao = new PedidoDao();

    ItensVendaBean iTensBean = null;
    ItensVendaDao iTensDao = new ItensVendaDao();
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pedidos Cliente </title>

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
                    <legend>Lista de Pedidos :  <%=request.getParameter("nome")  %>  </legend>                   


                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Número Pedido</th>                                 
                                <th>Data de Emissão </th>  
                                <th>Data de Entrega </th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <%
                              
                                for (PedidoBean pBean : pDao.Listagem_De_Pedidos_Por_CLIENTE(Integer.parseInt(request.getParameter("idCliente")))) {
                            %>

                            <%
                                 Double Soma = 0.0;
                            
                                           for (ItensVendaBean IDP : iTensDao.Busca_os_Itens_De_1_Venda_Apenas_Agrupado(pBean.getID())) {
                            %>
                            <tr>
                                <td><a href="./?acao=MostraDetalhesPedidoCliente&PedidoDet=<%=pBean.getID()%>"><%=pBean.getID()%></a></td>
                                <td><%=Conv.cal2dtbr(pBean.getDATA_PEDIDO())%></td> 
                                <td><%=Conv.cal2dtbr(pBean.getDATA_ENTREGA())%></td>                                
                            </tr> 

                            <%
                                               }
                            %>


                            <%  }%>  
                        </tbody>
                    </table>



                </div>
            </div>
        </div>
    </body>
</html>

