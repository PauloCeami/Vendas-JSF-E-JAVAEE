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
public class RemoverProduto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ProdutoBean pBean = new ProdutoBean();
        ProdutoDao pDao = new ProdutoDao();
        
         Long id = Long.parseLong(request.getParameter("id"));
         
         pDao.RemoverProduto(id);
         
        request.setAttribute("mensagem", "O Produto " + request.getParameter("nome")+" foi pra lata de lixo kkkkkkk ");
        request.setAttribute("destino", "./?acao=ListaTodosProdutos");   
        request.getRequestDispatcher("Mensagem").forward(request, response);


    }
}
