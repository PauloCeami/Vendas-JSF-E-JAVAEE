package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.pdv.model.SessaoApp;

public class Sair implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// encerra a sessão do usuário
		SessaoApp.encerra(request);
		// define mensagem de saída no request
		request.setAttribute("mensagem", "Sessão encerrada!.");
    	// força mostrar formulário de login
		request.setAttribute("destino","./?acao=MostraLogin"); // destino apos mostrar mensagem
		// redireciona para Mensagem
		request.getRequestDispatcher("Mensagem").forward(request, response);
	}
}
