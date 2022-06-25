<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "model.TypeMov" %>
<%@ page import = "dao.TypeMovDAO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@page import = "model.User" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	List<TypeMov> list;
	list = (ArrayList<TypeMov>)session.getAttribute("typeMovi");
	TypeMovDAO t = new TypeMovDAO();
	
	list = t.listar();
						
	%>
	
	<%User us = (User)session.getAttribute("userSession"); %>
	
	<form action="DepositServlet" method="post">
		<labe>Data</labe>
		<input name="dateMovi" id="dateMovi" type="text"/>
		
		<labe>Money</labe>
		<input name="money" id="money" type="number"/>
		
		<labe>Type Movi</labe>
		<input name="typeM" id="typeM" type="text"/>
		
		<labe>Id user </labe>
		<input name="idUs" id="idUs" type="text" value="<%=us.getId() %>"/>
	
		
		<select name="idType" id="idType">
		<option value="0" >Selecione...</option>
		<% for(TypeMov tp: list){%>
		
		  <option value="<%=tp.getId() %>"><%=tp.getDescription() %></option>
		  
		  
		  <% }%>
		  
		</select>

		
			<input type="submit" value="Criar"/>
	</form>
</body>
</html>