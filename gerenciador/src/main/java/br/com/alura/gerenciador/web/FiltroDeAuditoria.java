package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String url = ((HttpServletRequest)request).getRequestURI();
		HttpServletRequest req = ((HttpServletRequest)request);
		HttpServletResponse res = (HttpServletResponse) response;
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
		
		if(usuario != null) 
			System.out.println("O usuário " + usuario.getEmail() + " acessou a página " + url);
/*		
 * 
 * 
 * Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();		

		if(cookie != null) {
			cookie.setMaxAge(600);
			res.addCookie(cookie);
		}*/
		
		chain.doFilter(request, response);
	}

	private void verificarAcessoCookies(HttpServletRequest req) {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
