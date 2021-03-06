
<%@page import="java.text.DecimalFormat"%>
<%@page import="br.pdv.model.RepresentanteDao"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,
    br.pdv.model.*,
    br.util.Conv
   


    "%>

<%
    ClienteBean cli = null;
    ClienteDao cliDao = null;
    ProdutoBean prBean = null;
	ProdutoDao prDao = new ProdutoDao();

    PedidoBean ped = null; // objeto da classe bean getter e setter
    PedidoDao pDao = new PedidoDao();  // objeto da classe Dao 
    RepresentanteBean rbean = null;
    RepresentanteDao rDao = new RepresentanteDao();

    ItensVendaBean iTensBean = null;
    ItensVendaDao iTensDao = new ItensVendaDao();

    // este getAttribute esta recebendo o id vindo do vwListaCliente que por sua 
    //vez mandou a acao pra camada action com ConsultaCliente.java onde ele pegou 
    // o id do pedente e pesquisou pedente pelo seu id vindo da lista.
    if (null != request.getAttribute("id_do_pedido")) {
        ped = (PedidoBean) request.getAttribute("id_do_pedido");
    }



    if (null != request.getAttribute("id_do_cliente")) {
        cli = (ClienteBean) request.getAttribute("id_do_cliente");
    }


    if (null != request.getAttribute("id_do_representante")) {
        rbean = (RepresentanteBean) request.getAttribute("id_do_representante");
    }


   
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>

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
            
            
            .subtot{
            align :right;
            
            
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

                    <fieldset class="fieldsetVendas">
                        <legend>Visualiza????o do Pedido <%=null != ped ? ped.getID() : ""%> <a class="btn btn-mini btn-danger" href="./?acao=RemovePedido&idPedido=<%=ped.getID() %>&clienteID=<%=ped.getCLIENTEID() %>&nome=<%=cli.getNome()%>">Excluir Pedido </a> </legend>

                        <div class="formulario">
                            <label class="labelFormulario">Pedido N??mero.... <%=ped.getID()%></label>

                        </div>
                        <div class="clear"></div>

                        <div class="formulario">
                            <label class="labelFormulario">Data do Pedido.... <%=Conv.cal2dtbr(ped.getDATA_PEDIDO())%></label>
                        </div>
                        <div class="clear"></div>
                        <div class="formulario">
                            <label class="labelFormulario">Data da Entrega... <%=Conv.cal2dtbr(ped.getDATA_ENTREGA())%></label>
                        </div>
                        <div class="clear"></div> 
                        <div class="formulario">
                            <label class="labelFormulario">Nome do Cliente... <%=cli.getNome()%></label>
                        </div>


                        <div class="clear"></div>     


                        <div class="formulario">
                            <label class="labelFormulario">Representante..... <%=rbean.getNome()%></label>
                        </div>

                    </fieldset>

                </form>

            </div>



            <div class="row">         
                <div class="fieldsetLista">
                    <legend>Itens deste Pedido </legend>                   

                    <table class="table table-condensed table-hover">
                        <thead>
                            <tr>
                                <th>C??digo</th>
                                <th>Produto</th>                                 
                                <th>Quantidade</th>    
                                <th>Pre??o Unit??rio</th>
                                <th>Total por Item</th>                            
                            </tr>
                        </thead>
                        <tbody>
                            <%
                               double soma = 0.0;
                            
                                for (ItensVendaBean IDP : iTensDao.Busca_os_Itens_De_1_Venda_Apenas(ped.getID())) {
                                	
                                	double subTotal = (IDP.getQUANTIDADE() * IDP.getPRECO_UNITARIO());
                                	
                                	soma +=subTotal;
                                	
                            %>
                            <tr>
                                <td><%=IDP.getPRODUTOID()%></td>
                                <td><%= prDao.BuscaProdutos_IDGetINT(IDP.getPRODUTOID()).getDescricao()   %></td>
                                <td><%=IDP.getQUANTIDADE()%></td> 
                                <td><%=IDP.getPRECO_UNITARIO()%></td>                        

                                <td><%=Conv.double2moeda(subTotal) %></td> 

                            </tr> 
                            <%
                                }
                                
                            %>
                         
                        </tbody>
                         
                    </table>                 
                <tr><a class="btn btn-success" href="#"><%=Conv.double2moeda(soma) %></a></tr>
                </div>
            </div>
        </div>

    </body>

</html>

