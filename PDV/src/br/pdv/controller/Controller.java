package br.pdv.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.pdv.action.Command;
import br.pdv.model.SessaoApp;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        String acao = (
        		null==request.getParameter("acao") 
        		? "." 
        		: request.getParameter("acao")
        	);
        
        // verificar se a sessão é inválida
        if ( false==SessaoApp.valida(request)
        		&& (!acao.equals("AutenticaUsuario")) ) {
        	// não logado
        	// força encerramento da sessão
        	SessaoApp.encerra(request);
        	// força mostrar formulário de login
        	acao = "MostraLogin";
        }
            
        /* carrega a classe correspondente à ação a ser executada e
         * invoca o método execute desta classe passando request 
         * como parâmetro */
        try { // captura as exceções que possam ser geradas
            // gera caminho da classe correspondente à ação
        	String caminhoClasse = "br.pdv.action." + acao;
            // carrega a classe correspondente à ação
            Class classe = Class.forName(caminhoClasse);
            // instancia a acao a ser executada
            Command comando = (Command) classe.newInstance();
            // roda o método execute()
            comando.execute(request,response);
        } catch (Exception e) { // exceção ao invocar o método
            throw new RuntimeException(e);
        }            

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
