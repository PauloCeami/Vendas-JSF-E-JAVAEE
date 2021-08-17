package br.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mensagem")
public class Mensagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = (String) request.getAttribute("mensagem");
		String destino = (String) request.getAttribute("destino");
		PrintWriter out = response.getWriter();
		out.println("<script language='javascript'>");
		out.println(" alert('"+mensagem+"');");
		out.println(" window.location='"+destino+"'");
		out.println("</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
