package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		
		if (cookie != null) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}*/
		
		HttpSession session = req.getSession();
			
		if(session.getAttribute("usuario.logado") != null) {
			session.removeAttribute("usuario.logado");
			
//			resp.sendRedirect("logout.html");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/pages/logout.html");
			dispatcher.forward(req, resp);
		}
				
		
	}
	
}
