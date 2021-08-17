<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List,br.pdv.model.ClienteBean,br.pdv.model.ClienteDao"%>

<%
    ClienteBean cli = null;
    ClienteDao cDao = new ClienteDao();
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>

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
                    <legend>Lista de Clientes  <a class="btn btn-mini btn-info"  href="./?acao=NovoCliente" >Novo Cliente</a></legend>                   

                    <table class="table table-condensed table-hover">
                        <thead>
                            <tr>
                                <th>Nome</th> 
                                <th>Cidade</th>
                                <th>Estado</th>
                                <th>Telefone</th>
                                <th>Email</th>
                                <th colspan="3">Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (ClienteBean cBean : cDao.ListarTodosClientes()) {
                            %>
                            <tr>
                               
                                <td><%=cBean.getNome()%></td>
                                <td><%=cBean.getCidade()%></td>
                                <td><%=cBean.getEstado()%></td>                                
                                <td><%=cBean.getTelefone()%></td>
                                <td><%=cBean.getEmail()%></td>
                                <td><a class="btn btn-mini btn-success" href="./?acao=ConsultaCliente&id=<%=cBean.getId()%>"> Alterar </a>   </td>
                                <td><a class="btn btn-mini btn-danger" href="javascript:if(confirm('Deseja excluir <%=cBean.getNome()%> do cadastro de Clientes ? ')){location='./?acao=RemoverCliente&id=<%=cBean.getId()%>&nome=<%=cBean.getNome()%>'};   "> Exluir </a>   </td>
                                <td> <a class="btn btn-mini btn-info"  onclick="javascript:retorna('<%=cBean.getNome()%>','<%=cBean.getId()%>');"> C </a>  </td>  
                                
                            </tr> 
                            <%  }%>  
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
    <script>

        function retorna(retorno,id)

        {

            window.opener.document.getElementById('CLIENTEID').value = retorno;
            window.opener.document.getElementById('CLIENTEID2').value = id;           

            window.self.close();

        }
        
 

    </script>

</html>

