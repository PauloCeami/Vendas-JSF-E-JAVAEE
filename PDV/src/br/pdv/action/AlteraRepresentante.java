
package br.pdv.action;

import br.pdv.model.RepresentanteBean;
import br.pdv.model.RepresentanteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AlteraRepresentante implements Command {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        RepresentanteBean rBean = new RepresentanteBean();
        RepresentanteDao rDao = new RepresentanteDao();
        
        rBean.setId((int) Long.parseLong(request.getParameter("id")));
        rBean.setNome(request.getParameter("Nome"));
        rBean.setEndereco(request.getParameter("Endereco"));
        rBean.setBairro(request.getParameter("Bairro"));
        rBean.setCidade(request.getParameter("Cidade"));
        rBean.setEstado(request.getParameter("Estado"));
        rBean.setCep(request.getParameter("Cep"));
        rBean.setTelefone(request.getParameter("Telefone"));
        rBean.setFax(request.getParameter("Fax"));
        rBean.setCelular(request.getParameter("Celular"));
        rBean.setCNPJ_CPF(request.getParameter("CNPJ_CPF"));
        rBean.setEmail(request.getParameter("Email"));
        rBean.setContato(request.getParameter("Contato"));
        rDao.altera(rBean);
        request.setAttribute("mensagem", "O Cadastro do Representante " + request.getParameter("Nome") + " foi alterado com sucesso");
        request.setAttribute("destino", "./?acao=ListaRepresentante");        
        request.getRequestDispatcher("Mensagem").forward(request, response);
        
        
    }
}
