<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%String type = (String)session.getAttribute("type"); %>
	<%String nome = (String)session.getAttribute("nm"); %>
	
	<form action="DepositServlet" method="post">
		<labe>Data</labe>
		<input name="dateMovi" id="dateMovi" type="text"/>
		
		<labe>Money</labe>
		<input name="money" id="money" type="number"/>
		
		<labe>Type Movi</labe>
		<input name="typeM" id="typeM" type="text"/>
		
		<labe>Id_user</labe>
		<input name="idUser" id="idUser" type="text" value="<%=nome %>"/>
		
		<labe>Id_type</labe>
		<input name="idType" id="idType" type="text" value="<%=type %>"/>
		
			<input type="submit" value="Criar"/>
	</form>
</body>
</html>