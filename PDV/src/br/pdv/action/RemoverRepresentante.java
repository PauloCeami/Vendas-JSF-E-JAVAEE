/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pdv.model.RepresentanteDao;

public class RemoverRepresentante implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Long id = Long.parseLong(request.getParameter("id"));
        RepresentanteDao rDao = new RepresentanteDao();
        rDao.remove(id);
        request.setAttribute("mensagem", "O Representante " + request.getParameter("nome") + " foi pra lata de lixo kkkkkkk ");
        request.setAttribute("destino", "./?acao=ListaRepresentante");
        request.getRequestDispatcher("Mensagem").forward(request, response);


    }
}
