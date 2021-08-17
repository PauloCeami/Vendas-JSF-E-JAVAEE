/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import br.pdv.model.ClienteBean;
import br.pdv.model.ClienteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Analista
 */
public class ConsultaClientePedido implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClienteBean cBean = new ClienteBean();
        ClienteDao cDao = new ClienteDao();

        cBean = cDao.BuscaClientePor_ID(Long.parseLong(request.getParameter("cli_id")));

        if (null != cBean) {
            request.setAttribute("cli_id", cBean);
        }

        request.getRequestDispatcher("vw_Pedido.jsp").forward(request, response);
    }
}
