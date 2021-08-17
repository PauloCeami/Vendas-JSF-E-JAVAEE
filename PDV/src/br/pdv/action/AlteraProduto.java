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
public class AlteraProduto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProdutoBean pBean = new ProdutoBean();
        ProdutoDao pDao = new ProdutoDao();
        pBean.setId((int) Long.parseLong(request.getParameter("id")));
        pBean.setDescricao(request.getParameter("descricao"));
        pBean.setPreco_unitario(Double.parseDouble(request.getParameter("preco_unitario")));
        pDao.AlteraProduto(pBean);
        request.setAttribute("mensagem", "O Produto  " + request.getParameter("descricao") + " foi alterado com sucesso");
        request.setAttribute("destino", "./?acao=ListaTodosProdutos");
        request.getRequestDispatcher("Mensagem").forward(request, response);

    }
}
