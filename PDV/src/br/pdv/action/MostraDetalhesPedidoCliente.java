/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import br.pdv.model.ClienteBean;
import br.pdv.model.ClienteDao;
import br.pdv.model.ItensVendaBean;
import br.pdv.model.ItensVendaDao;
import br.pdv.model.PedidoBean;
import br.pdv.model.PedidoDao;
import br.pdv.model.RepresentanteBean;
import br.pdv.model.RepresentanteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraDetalhesPedidoCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PedidoBean pBean = new PedidoBean();
        PedidoDao pDao = new PedidoDao();

        ItensVendaBean iBean = new ItensVendaBean();
        ItensVendaDao iDao = new ItensVendaDao();

        ClienteBean cBean = new ClienteBean();
        ClienteDao cDao = new ClienteDao();

        RepresentanteBean rBean = new RepresentanteBean();
        RepresentanteDao rDao = new RepresentanteDao();

        pBean = pDao.BuscaPedido_ID(Long.parseLong(request.getParameter("PedidoDet")));

        cBean = cDao.BuscaClientePor_ID_GetINT(pBean.getCLIENTEID());

        rBean = rDao.BuscaRepresentantePor_GetINT(pBean.getREPRESENTANTEID());


        if (null != cBean) {
            request.setAttribute("id_do_cliente", cBean);
        }


        if (null != rBean) {
            request.setAttribute("id_do_representante", rBean);
        }

        if (null != pBean) {
            request.setAttribute("id_do_pedido", pBean);
        }

        request.getRequestDispatcher("vw_DetalhesPedidoCliente.jsp").forward(request, response);
    }
}
