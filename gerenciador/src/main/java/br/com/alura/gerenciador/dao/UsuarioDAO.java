package br.com.alura.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("teste@gmail.com", new Usuario("renan.rgsilva@gmail.com","12345"));
		USUARIOS.put("teste@teste.com.br", new Usuario("rodrigo.turini@alura.com.br","turini"));
		USUARIOS.put("teste.turini@teste.com.br", new Usuario("rodrigo.turini@alura.com.br","turini"));
		USUARIOS.put("testegit@teste.com", new Usuario("rodrigo.turini@alura.com.br","turini"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;
		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
