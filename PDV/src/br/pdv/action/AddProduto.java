/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pdv.model.ProdutoDao;
import br.pdv.model.ProdutoBean;

public class AddProduto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProdutoBean pBean = new ProdutoBean();
        ProdutoDao pDao = new ProdutoDao();
        pBean.setDescricao(request.getParameter("descricao"));
        pBean.setPreco_unitario(Double.parseDouble(request.getParameter("preco_unitario")));
        pDao.AddProduto(pBean);
        request.setAttribute("mensagem", "O Produto  " + request.getParameter("descricao") + " foi adicionado com sucesso");
        request.setAttribute("destino", "./?acao=ListaTodosProdutos");
        request.getRequestDispatcher("Mensagem").forward(request, response);
    }
}
