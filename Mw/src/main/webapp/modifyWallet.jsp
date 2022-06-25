<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import = "model.Wallet" %>
      <%@page import = "model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% Wallet w = (Wallet)session.getAttribute("walletSelected");%>
	
	<%User us = (User)session.getAttribute("userSession"); %>

		<form action="ModifyWalletServlet" method="post">
		
			<input type="hidden" name="id" id="id" value="<%=w.getId() %>" >
			<label>Nome : </label>
			<input type="text" name="nameWallet" id="nameWallet" placeholder="Nome do Usuário" size="40" value="<%=w.getNameWallet() %>"/><br>
			
			
			<input type="submit" value="Gravar"/>
		</form>
</body>
</html>