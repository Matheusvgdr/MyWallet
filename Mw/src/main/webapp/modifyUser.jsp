<%@page import = "model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<% User usr = (User)session.getAttribute("userSelected");%>
		<form action="ModifyUserServlet" method="post">
		
			<input type="hidden" name="id" id="id" value="<%=usr.getId() %>" >
			<label>Nome : </label>
			<input type="text" name="personName" id="personName" placeholder="Nome do Usu�rio" size="40" value="<%=usr.getPersonName() %>"/><br>
			<label>Usu�rio:</label>
			<input type="text" name="userName" id="userName" placeholder="Login para o usu�rio" size="20" value="<%=usr.getUserName()%>"/><br>
			<label>Senha:</label>
			<input type="password" name="userPassword" id="userPassword" placeholder="Senha" size="20" value="<%=usr.getUserPassword() %>"/><br>
	
			<label>CPF:</label>
			<input type="password" name="cpf" id="cpf" placeholder="Senha" size="20" value="<%=usr.getCpf() %>"/><br>
			
			<input type="submit" value="Gravar"/>
		</form>
		</div>
</body>
</html>