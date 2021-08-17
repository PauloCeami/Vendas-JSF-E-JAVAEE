/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import br.pdv.model.ClienteBean;
import br.pdv.model.ClienteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Analista
 */
public class AlteraCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClienteBean cBean = new ClienteBean();
        ClienteDao cDao = new ClienteDao();
        cBean.setId((int) Long.parseLong(request.getParameter("id")));
        cBean.setNome(request.getParameter("Nome"));
        cBean.setEndereco(request.getParameter("Endereco"));
        cBean.setBairro(request.getParameter("Bairro"));
        cBean.setCidade(request.getParameter("Cidade"));
        cBean.setEstado(request.getParameter("Estado"));
        cBean.setCep(request.getParameter("Cep"));
        cBean.setTelefone(request.getParameter("Telefone"));
        cBean.setFax(request.getParameter("Fax"));
        cBean.setCelular(request.getParameter("Celular"));
        cBean.setCNPJ_CPF(request.getParameter("CNPJ_CPF"));
        cBean.setEmail(request.getParameter("Email"));
        cDao.altera(cBean);
       request.setAttribute("mensagem", "O Cadastro do Cliente "+request.getParameter("Nome")+" foi alterado com sucesso");
        request.setAttribute("destino", "./?acao=ListaClientes"); 
        request.getRequestDispatcher("Mensagem").forward(request, response);
    }
}
