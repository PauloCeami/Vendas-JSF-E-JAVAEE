/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pdv.model.ClienteDao;
import br.pdv.model.ClienteBean;

public class ConsultaCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClienteBean cBean = new ClienteBean();
        ClienteDao cDao = new ClienteDao();

        cBean = cDao.BuscaClientePor_ID(Long.parseLong(request.getParameter("id")));

        if (null != cBean) {
            request.setAttribute("id", cBean);
        }

        request.getRequestDispatcher("vw_FormCliente.jsp").forward(request, response);
    }
}
