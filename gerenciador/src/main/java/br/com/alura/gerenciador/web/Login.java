package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(req.getParameter("email"), req.getParameter("senha"));
		PrintWriter writer = resp.getWriter();
		verificarUsuario(req, resp, usuario, writer);
	}

	private void verificarUsuario(HttpServletRequest req, HttpServletResponse resp, Usuario usuario,
			PrintWriter writer) throws IOException {
		System.out.println("Passei pela servlet de login!");
		HttpSession session  = req.getSession();
		session.setAttribute("usuario.logado", usuario);
		if(usuario == null) {
			writer.println("<html><body> Usuário não logado!</body></html>");
		}else {
//			Cookie cookie = new Cookie("usuario.logado", usuario.getEmail());
//			resp.addCookie(cookie);
			session.setAttribute("usuario.logado", usuario);
			writer.print("<html><body>" + usuario.getEmail() + " fez uma requisição à URL" + req.getRequestURI() + "</body></html>");
		}
	}
}
