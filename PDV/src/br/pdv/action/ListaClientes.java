/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaClientes implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.getRequestDispatcher("vwListaCliente.jsp").forward(request, response);
    }
}
