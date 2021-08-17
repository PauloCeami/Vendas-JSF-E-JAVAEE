/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import br.pdv.model.RepresentanteBean;
import br.pdv.model.RepresentanteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddRepresentante implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
        RepresentanteBean rBean = new RepresentanteBean();
        RepresentanteDao rDao = new RepresentanteDao();
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
        rDao.Gravar(rBean);
        request.setAttribute("mensagem", "O Representante "+request.getParameter("Nome")+" foi adicionado com sucesso");
        request.setAttribute("destino", "./?acao=ListaRepresentante"); // destino apos mostrar mensagem       
        request.getRequestDispatcher("Mensagem").forward(request, response);        
    }
    
    
    
}
