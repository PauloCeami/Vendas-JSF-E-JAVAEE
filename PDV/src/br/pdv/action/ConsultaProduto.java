/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import br.pdv.model.ProdutoBean;
import br.pdv.model.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Analista
 */
public class ConsultaProduto implements Command{
    
        @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ProdutoBean pBean = new ProdutoBean();
        ProdutoDao pDao = new ProdutoDao();
        pBean = pDao.BuscaProdutos_ID(Long.parseLong(request.getParameter("id")));
        if (null != pBean) {
            request.setAttribute("id", pBean);
        }
        request.getRequestDispatcher("vw_FormAddProduto.jsp").forward(request, response);
    }
    
}
