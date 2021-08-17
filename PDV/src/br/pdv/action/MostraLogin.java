package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// redireciona para a login.jsp
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
