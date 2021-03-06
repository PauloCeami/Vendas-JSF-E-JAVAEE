package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pdv.model.ClienteBean;
import br.pdv.model.ClienteDao;
import br.pdv.model.ItensVendaBean;
import br.pdv.model.ItensVendaDao;
import br.pdv.model.PedidoBean;
import br.pdv.model.PedidoDao;

public class RemovePedido implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ItensVendaBean iBean = new ItensVendaBean();
		ItensVendaDao iDao = new ItensVendaDao();
		
		PedidoBean pBean = new PedidoBean();
		PedidoDao pDao = new PedidoDao();
		ClienteDao cDao = new ClienteDao();
		int IT =  Integer.parseInt(request.getParameter("idPedido"));
		
		//Excluindo o pedido e os itens do pedido
		iDao.RemoveItensPedido(IT);
		pDao.RemovePedido(IT);
		
	    request.setAttribute("mensagem", "O Pedido " + request.getParameter("idPedido") + " do cliente "   + cDao.BuscaClientePor_ID_GetINT(Integer.parseInt(request.getParameter("clienteID"))).getNome() +" foi excluido ");
        request.setAttribute("destino", "./?acao=ConsultaPedidosCliente&idCliente="+request.getParameter("clienteID")+"&nome="+ cDao.BuscaClientePor_ID_GetINT(Integer.parseInt(request.getParameter("clienteID"))).getNome());   
        request.getRequestDispatcher("Mensagem").forward(request, response);
	}

}
