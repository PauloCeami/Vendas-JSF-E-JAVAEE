/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import br.pdv.model.ClienteBean;
import br.pdv.model.ClienteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoverCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id = Long.parseLong(request.getParameter("id"));
        ClienteDao cDao = new ClienteDao();
        
        
        
        cDao.remove(id);
        request.setAttribute("mensagem", "O Cliente " + request.getParameter("nome")+" foi pra lata de lixo kkkkkkk ");
        request.setAttribute("destino", "./?acao=ListaClientes");   
        request.getRequestDispatcher("Mensagem").forward(request, response);
    }
}
