package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		String classTarefa = "br.com.alura.gerenciador.web."+tarefa;
		
			Tarefa t;
			try {
				t = (Tarefa) Class.forName(classTarefa).newInstance();
				RequestDispatcher dispatcher = req.getRequestDispatcher(t.executar(req, resp));
				dispatcher.forward(req, resp);
			} catch (IllegalAccessException | InstantiationException | ClassNotFoundException c ) {
				c.printStackTrace();
			}
	}
	
}
