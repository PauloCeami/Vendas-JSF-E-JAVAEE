package br.pdv.action;

import br.pdv.model.ProdutoBean;
import br.pdv.model.ProdutoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaProdutosWhereLlike implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
        
        request.getRequestDispatcher("vwListaProdutosWhereLlike.jsp").forward(request, response);
    }
}
