
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="br.pdv.model.RepresentanteDao"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,
    br.pdv.model.*,
    br.util.Conv"%>

<%
    ClienteBean cli = null;
	RepresentanteBean rep = null;
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
    if (null != request.getAttribute("id")) {
        ped = (PedidoBean) request.getAttribute("id");
    }



    if (null != request.getAttribute("idCliente")) {
        cli = (ClienteBean) request.getAttribute("idCliente");
    }


    if (null != request.getAttribute("idRepresentante")) {
        rep = (RepresentanteBean) request.getAttribute("idRepresentante");
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

                    <input type="hidden"  name="acao" value="<%=null != ped ? "MovimentacaoVendas_RegraNegocio" : "MovimentacaoVendas_RegraNegocio"%>" />
                    <input type="hidden"  name="id" value="<%=null != ped ? ped.getID() : "0"%>" />



                    <fieldset class="fieldsetVendas">
                        <legend>C??digo.<%=null != ped ? ped.getID() : ""%> - Vendas-PDV </legend>

                        <div class="formulario">
                            <label class="labelFormulario">Pedido</label>
                            <input class="span2" readonly name="PEDIDOID" type="text" placeholder="Pedido"  value="<%=null != ped ? ped.getID() : "0"%>">
                        </div>


                        <div class="formulario">
                            <label class="labelFormulario">Data</label>
                            <input class="nome span2" name="DATA_PEDIDO" type="text" placeholder="Data???"  value="<%=null != ped ? Conv.cal2dtbr(ped.getDATA_PEDIDO()) :  ""    %>"   >
                        </div>

                        <div class="formulario">
                            <label class="labelFormulario">Entrega</label>
                            <input class="nome span2" name="DATA_ENTREGA" type="text" placeholder="Entrega???"  value="<%=null != ped ?  Conv.cal2dtbr(ped.getDATA_PEDIDO())  : ""   %>"   >
                        </div>
                        <div class="clear"></div>

                        <div class="formulario">
                            <label  class="labelFormulario">  id  </label>
                            <input type="text" class="idcliente" readonly  name="CLIENTEID2" id="CLIENTEID2" value="<%=null != ped ? ped.getCLIENTEID() : "" %>" />
                        </div>
                        <div class="formulario">
                            <div class="input-append">
                                <label  class="labelFormulario">  Cliente  </label>
                                <input name="CLIENTEID" id="CLIENTEID" class="span3" id="appendedInputButton" type="text"  placeholder="Cliente???"  value="<%=null != ped ?  cli.getNome()  : ""    %>" >
                                <button   class="btn" onClick=javascript:abrir('./?acao=ListaClientes'); type="button">Pesquisar</button>
                            </div>
                        </div>


                        <div class="clear"></div>     

                        <div class="formulario">
                            <label  class="labelFormulario">  id  </label>
                            <input type="text" class="idcliente" readonly  name="REPRESENTANTEID2" id="REPRESENTANTEID2" value="<%=null != ped ? ped.getREPRESENTANTEID()  : ""    %>" />
                        </div>
                        <div class="formulario">
                            <div class="input-append">
                                <label  class="labelFormulario">  Vendedor  </label>
                                <input name="REPRESENTANTEID" id="REPRESENTANTEID" class="span3" id="appendedInputButton" type="text"  placeholder="Vendedor"  value="<%=null != ped ?  rep.getNome()  : ""    %>" >
                                <button   class="btn" onClick=javascript:abrir('./?acao=ListaRepresentante'); type="button">Pesquisar Vendedor</button>
                            </div>
                        </div>
                        <div class="clear"></div>  
                        <%  // preco do produto                                                                                                            %>  
                        <div class="formulario">
                            <label  class="labelFormulario"> R$ Unit  </label>
                            <input type="text" class="idcliente span1"   name="PRECO_UNITARIO" id="PRECO_UNITARIO" value="0.00" />
                        </div> 
                        <%%>  
                        <div class="formulario">
                            <label  class="labelFormulario"> Quant  </label>
                            <input type="text" class="idcliente"   name="QUANTIDADE" id="QUANTIDADE" value="1" />
                        </div> 



                        <div class="formulario">
                            <label  class="labelFormulario">  id  </label>
                            <input type="text" class="idcliente" readonly  name="IDPRODUTO2" id="IDPRODUTO2" value="" />
                        </div>    


                        <div class="formulario">
                            <div class="input-append">
                                <label  class="labelFormulario">  Produto  </label>
                                <input name="IDPRODUTO" id="IDPRODUTO" class="span3" id="appendedInputButton" type="text"  placeholder="Produto"  value="<%=null != ped ? "" : ""%>" >
                                <button   class="btn" onClick=javascript:abrir('./?acao=ListaProdutosWhereLlike'); type="button">Pesquisar Produto</button>
                            </div>
                        </div>

                        <div class="clear"></div>    

                        <div class="formulario">
                            <label class="labelFormulario"></label>

                            <input type="submit" class="btn btn-mini btn-info" value="Add Item Venda" />                            
                        </div>

                        <div class="clear"></div>
                    </fieldset>
                </form>
            </div>


            <div class="row">         
                <div class="fieldsetLista">
                    <legend> Items da Venda </legend>                   

                    <table class="table table-condensed table-hover">
                        <thead>
                            <tr>
                            <th>C??digo</th>
                                <th>Produto</th>                                 
                                <th>Quantidade</th>    
                                <th>Pre??o Unit??rio</th>
                                <th>Total</th>                            
                            </tr>
                        </thead>
                        <tbody>
                                    <%   if (null != ped ) {
                                    for (ItensVendaBean IDP : iTensDao.Busca_os_Itens_De_1_Venda_Apenas(ped.getID())) {
                            %>
                            <tr>
                                <td><%= IDP.getPRODUTOID()   %></td>
                                <td><%= prDao.BuscaProdutos_IDGetINT(IDP.getPRODUTOID()).getDescricao()   %></td>
                                   <td><%=IDP.getQUANTIDADE()%></td> 
                                <td><%=IDP.getPRECO_UNITARIO()%></td> 
                                <td><%= ( IDP.getQUANTIDADE() * IDP.getPRECO_UNITARIO()) %></td> 

                            </tr> 
                            <%
                                    }
                                 
                                }
                           
                            %>
                        
                            
                        </tbody>
                    </table>
                </div>
            </div>
        


            <script>

                                    function abrir(programa, janela)
                                    {
                                        if (janela == "")
                                            janela = "janela";

                                        window.open(programa, janela, 'height=450,width=730,left=300,right=300,top=150,resizable=no');
                                    }

            </script>
    </body>

</html>

