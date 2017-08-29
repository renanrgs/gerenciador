<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
	<form action="novaEmpresa" method="POST">
		<label>Nome: </label><input name="nome" type="text">
		<button type="submit">Cadastrar</button>
	</form>
	
	<form action="login" method="post">
		<label>E-mail:</label><input type = "email" name="email"/>
		<label>Senha:</label><input type="password" name="senha"/>
		<button type="submit">Entrar</button>
	</form>
	
	<form action="logout" method="post">
		<button type="submit">Logout</button>
	</form>
	
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="BuscaEmpresa">
		<label>Nome:</label><input type="text" name="filtro"/>
		<button type="submit">Pesquisar</button>
	</form>
	
</body>
</html>