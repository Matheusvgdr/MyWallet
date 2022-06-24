<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>Cadastrar</h1>
		<form action="InsertServlet" method="post">
		
			<label>Nome : </label>
			<input type="text" name="name" id="name"/><br>
			
			<label>Usuário:</label>
			<input type="text" name="userName" id="userName"/><br>
			
			<label>Senha:</label>
			<input type="password" name="password" id="password"/><br>
			
			<label>CPF:</label>
			<input type="text" name="cpf" id="cpf" /><br>
			
			<input type="submit" value="Gravar"/>
		</form>
		
		<form action="InsertWalletServlet" method="post">
		
			<label>Nome : </label>
			<input type="text" name="nameWlt" id="nameWlt"/><br>
			
			<label>dinheiro:</label>
			<input type="text" name="value" id="value"/><br>
			<label>User:</label>
			<input type="text" name="idUs" id="idUs"/><br>
			
			
			<input type="submit" value="Gravar"/>
		</form>
	</div>
	<div>
		<nav>
			<ul>
				<li><a href="home.jsp">Home</a></li>
			</ul>
		</nav>
	</div>	
</body>
</html>