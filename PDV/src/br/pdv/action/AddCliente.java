/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pdv.model.ClienteBean;
import br.pdv.model.ClienteDao;

public class AddCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ClienteBean cBean = new ClienteBean();
        ClienteDao cDao = new ClienteDao();
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
        cDao.Gravar(cBean);
        request.setAttribute("mensagem", "O Cliente "+request.getParameter("Nome")+" foi adicionado com sucesso");
        request.setAttribute("destino", "./?acao=ListaClientes"); // destino apos mostrar mensagem
        // 5) Redireciona para servlet Mensagem
        request.getRequestDispatcher("Mensagem").forward(request, response);

    }
}
