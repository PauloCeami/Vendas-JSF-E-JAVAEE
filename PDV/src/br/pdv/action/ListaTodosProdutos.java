package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaTodosProdutos implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("vwListaTodosProdutos.jsp").forward(request, response);
    }
}
