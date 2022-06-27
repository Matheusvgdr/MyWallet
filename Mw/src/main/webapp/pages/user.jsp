<%@page import="service.UserService" %>
<%@page import="model.User" %>
<%@page import="model.Wallet" %>
<%@page import="service.WalletService" %>
<%@page import="service.MovimentationService" %>
<%@page import="model.Movimentation" %>
<%@page import="dao.MovimentationDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <script>
    function confirmDeleteUser(id){
		var answer = confirm("Confirma a exclus„o do registro?");
		
		if(answer == true){
			window.location.href = "../DeleteUserServlet?id=" + id;
		}
	}
    </script>
</head>
<body>
	<%User us = (User)session.getAttribute("userSession"); %>
	
	<% MovimentationDAO mo = new MovimentationDAO();
	List<Movimentation> lis = new ArrayList<Movimentation>();
	double calc = 0;
	lis = mo.listDeposits(us.getId(), 1);
	
	for(Movimentation i: lis){
	
		calc += i.getMoney();
		
	}
	
	%>
	
	<h1>Todos depositos: <%=calc %></h1>
	
	
		<% MovimentationDAO movime = new MovimentationDAO();
	List<Movimentation> listaW = new ArrayList<Movimentation>();
	double calcW = 0;
	lis = movime.listWithdraw(us.getId(), 2);
	
	for(Movimentation i: lis){
	
		calcW += i.getMoney();
		
	}
	%>
	<h1>Todos saques: <%=calcW %></h1>
	
	<h1>Todos dinheiro: <%=calc - calcW %></h1>
    <table border=1>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>USU√ÅRIO</th>
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
						<a href="../PrepareModificationServlet?id=<%=usr.getId()%>"><img src="images/edit.png" width="24px"/></a>
					</td>
					<td>
					
						<img src="images/delete.png" width="24px" onclick="confirmDeleteUser(<%=usr.getId()%>)"/>
					</td>
				</tr>
			<%
			}
			%>
		</table>
</body>
</html>