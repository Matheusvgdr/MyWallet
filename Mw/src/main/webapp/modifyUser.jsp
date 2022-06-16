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
			<input type="text" name="personName" id="personName" placeholder="Nome do Usuário" size="40" value="<%=usr.getPersonName() %>"/><br>
			<label>Usuário:</label>
			<input type="text" name="userName" id="userName" placeholder="Login para o usuário" size="20" value="<%=usr.getUserName()%>"/><br>
			<label>Senha:</label>
			<input type="password" name="userPassword" id="userPassword" placeholder="Senha" size="20" value="<%=usr.getUserPassword() %>"/><br>
			<label>Birthday:</label>
			<input type="password" name="birthday" id="birthday" placeholder="Senha" size="20" value="<%=usr.getBirthday() %>"/><br>
			<label>CPF:</label>
			<input type="password" name="cpf" id="cpf" placeholder="Senha" size="20" value="<%=usr.getCpf() %>"/><br>
			<label>Photo:</label>
			<input type="password" name="photo" id="photo" placeholder="Senha" size="20" value="<%=usr.getPhoto() %>"/><br>
			<input type="submit" value="Gravar"/>
		</form>
		</div>
</body>
</html>