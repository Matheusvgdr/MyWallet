<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.UserDAO" %>
<%@page import="model.User" %>
<%@page import="model.Wallet" %>
<%@page import="dao.WalletDAO" %>
<%@page import="dao.MovimentationDAO" %>
<%@page import="model.Movimentation" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
		function confirmDelete(id){
			var answer = confirm("Confirma a exclus�o do registro?");
			
			if(answer == true){
				window.location.href = "DeleteServlet?id=" + id;
			}
		}
	</script>
</head>
<body>
	<h1>Menu</h1>
	<%String name = (String)session.getAttribute("userSession"); %>
	
	
	
	<h2>Bem vindo ao sistema, <%=name %></h2>
	
	<div>
		<h2>Lista de Usu�rios</h2>
	</div>
	<div>
		<table border=1>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>USU�RIO</th>
				<th>Senha</th>
				<th>Anivers�rio</th>
				<th>CPF</th>
				<th>Foto</th>
				<th colspan=2></th>
			</tr>
			
			<%
			UserDAO dao = new UserDAO();
			List<User> list = new ArrayList<User>();
			
			list = dao.listUser();
			
			for(User usr: list){%>
				<tr>
					<td>
						<%=usr.getId() %>
					</td>
					<td>
						<%=usr.getPersonName() %>
					</td>
					<td>
						<%=usr.getUserName() %>
					</td>
					<td>
						<%=usr.getUserPassword() %>
					</td>
					<td>
						<%=usr.getCpf() %>
					</td>
					<td>
						<a href="PrepareModificationServlet?id=<%=usr.getId()%>"><img src="images/edit.png" width="24px"/></a>
					</td>
					<td>
						<img src="images/delete.png" width="24px" onclick="confirmDelete(<%=usr.getId()%>)"/>
					</td>
				</tr>
			<%
			}
			%>
		</table><br>
		<table border=1>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>Valo</th>
				<th colspan=2></th>
			</tr>
			
			<%
			WalletDAO daoW = new WalletDAO();
			List<Wallet> listW = new ArrayList<Wallet>();
			
			listW = daoW.listWallet();
			
			for(Wallet usr: listW){%>
				<tr>
					
					<td>
						<%=usr.getId()%>
					</td>
					<td>
						<%=usr.getNameWallet()%>
					</td>
					
					<td>
						<%=usr.getBudget() %>
					<td>
						<a href="PrepareModificationServlet?id=<%=usr.getId()%>"><img src="images/edit.png" width="24px"/></a>
					</td>
					<td>
						<img src="images/delete.png" width="24px" onclick="confirmDelete(<%=usr.getId()%>)"/>
					</td>
				</tr>
			<%
			}
			%>
		</table>
		
	<div>
			<nav>
				<ul>
					<li><a href="register.jsp">Incluir Usu�rio</a></li>
					<li><a href="register.jsp">Incluir carteira</a></li>
					<li><a href="index.html">Logout</a></li>
					
					<li><a href="movimentatio.jsp">Deposito</a></li>
					
				</ul>
			</nav>
			<form action="InserTypeServlet" method="post">
				<input type="hidden" name="deposit" id="deposit" value="1"/>
				<input type="hidden" name="nome" id="nome" value="<%=name %>"/>
				<input type="submit" value="depositar"/>
			</form>
		</div>
</body>
</html>