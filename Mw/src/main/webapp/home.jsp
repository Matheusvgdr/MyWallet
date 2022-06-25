<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="service.UserService" %>
<%@page import="model.User" %>
<%@page import="model.Wallet" %>
<%@page import="service.WalletService" %>
<%@page import="service.MovimentationService" %>
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
			var answer = confirm("Confirma a exclusão do registro?");
			
			if(answer == true){
				window.location.href = "DeleteServlet?id=" + id;
			}
		}
	</script>
</head>
<body>
	<h1>Menu</h1>
	<%User us = (User)session.getAttribute("userSession"); %>
	
	
	
	<h2>Bem vindo ao sistema, <%=us.getId() %></h2>
	
	<div>
		<h2>Lista de Usuários</h2>
	</div>
	<div>
		<table border=1>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>USUÁRIO</th>
				<th>Senha</th>
				<th>CPF</th>
				<th>Alterar</th>
				<th>Deletar</th>
			</tr>
			
			<%
			UserService serviceU = new UserService();
			List<User> list = new ArrayList<User>();
			
			list = serviceU.list(us.getId());
			
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
				<th>Valor</th>
				<th colspan=2></th>
			</tr>
			
			<%
			WalletService serviceW = new WalletService();
			List<Wallet> listW = new ArrayList<Wallet>();
			
			listW = serviceW.listWallet(us.getId());
			
			for(Wallet w: listW){%>
				<tr>
					
					<td>
						<%=w.getId()%>
					</td>
					<td>
						<%=w.getNameWallet()%>
					</td>
					
					<td>
						<%=w.getBudget() %>
					<td>
						<a href="PrepareModificationWalletServlet?id=<%=w.getId()%>"><img src="images/edit.png" width="24px"/></a>
					</td>
					<td>
						<img src="images/delete.png" width="24px" onclick="confirmDel(<%=w.getId()%>)"/>
					</td>
				</tr>
			<%
			}
			%>
		</table><br>
		
		<table border=1>
			<tr>
				<th>Tipo</th>
				<th>Data</th>
				<th>Valor</th>
				<th>Id usuario</th>
				<th>Nome usuario</th>
				<th colspan=2></th>
			</tr>
			
			<%
			MovimentationService serviceM = new MovimentationService();
			List<Movimentation> listM = new ArrayList<Movimentation>();
			
			listM = serviceM.listMov(us.getId());
			
			for(Movimentation mv: listM){%>
				<tr>
					
					<td>
						<%=mv.getType()%>
					</td>
					<td>
						<%=mv.getMoviDate()%>
					</td>
					
					<td>
						<%=mv.getMoney() %>
					</td>
					<td>
						<%=us.getId() %>
					</td>
					<td>
						<%=us.getUserName() %>
					</td>
					<td>
				
						<img src="images/delete.png" width="24px" onclick="confirmDel(<%=mv.getId()%>)"/>
					</td>
				</tr>
			<%
			}
			%>
		</table>
		
		<div>
			<nav>
				<ul>
					<li><a href="register.jsp">Incluir Usuário</a></li>
					
					<li><a href="register.jsp">Incluir carteira></a></li>
					
					<li><a href="PrepareMovimentationServlet">Deposito</a></li>
					
					<li><a href="index.html">Logout</a></li>
					
				</ul>
			</nav>
			
		</div>
</body>
</html>