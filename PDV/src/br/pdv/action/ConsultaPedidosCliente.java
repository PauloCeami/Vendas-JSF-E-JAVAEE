
package br.pdv.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaPedidosCliente implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getRequestDispatcher("vw_ListaPedidosCliente.jsp?idCliente="+request.getParameter("idCliente")).forward(request, response);


    }
}
