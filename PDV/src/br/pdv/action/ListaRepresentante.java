/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Analista
 */
public class ListaRepresentante implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     
      request.getRequestDispatcher("vwListaRepresentante.jsp").forward(request, response);  
        
    }
    
}
