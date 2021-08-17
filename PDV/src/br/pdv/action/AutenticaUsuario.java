package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.pdv.model.SessaoApp;
import br.pdv.model.Usuario;
import br.pdv.model.UsuarioDAO;
import br.util.Hash;

public class AutenticaUsuario implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		// cria a instância do DAO para acessar BD
		UsuarioDAO usuarios = new UsuarioDAO();
		// cria a instância de Usuário
		Usuario u = new Usuario();
		// define o email do objeto Usuario
		u.setEmail(request.getParameter("email"));
		// define a senha do objeto Usuario
		u.setSenha(Hash.md5(request.getParameter("senha")));
		// roda o método que autentica o usuario
		u = usuarios.validar(u);
		// se não veio um id para o usuario
		if (u.getId()==0) {
			// dados inválidos:
			// define mensagem de erro no request
			request.setAttribute("mensagem", "Email e/ou senha inválidos.");
			// volta para formulário de login
			request.setAttribute("destino","./?acao=MostraLogin"); // destino apos mostrar mensagem
		} else {
			// dados válidos:
			// Inicia a sessão
			SessaoApp.inicia(u, request);
			// define mensagem de boas vindas no request
			request.setAttribute("mensagem", "Ola "+u.getNome()+"!");
			// vai para página inicial com acesso restrito
			request.setAttribute("destino","./?acao=DirecionaPageIndex"); // destino apos mostrar mensagem
		}
		// redireciona para Mensagem
		request.getRequestDispatcher("Mensagem").forward(request, response);
	}
}
