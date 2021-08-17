/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import br.pdv.model.RepresentanteBean;
import br.pdv.model.RepresentanteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Analista
 */
public class ConsultaRepresentante implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RepresentanteBean rBean = new RepresentanteBean();
        RepresentanteDao rDao = new RepresentanteDao();

        rBean = rDao.BuscaRepresentantePor_ID(Long.parseLong(request.getParameter("id")));

        if (null != rBean) {
            request.setAttribute("id", rBean);
        }

        request.getRequestDispatcher("vw_FormRepresentante.jsp").forward(request, response);
    }
}
