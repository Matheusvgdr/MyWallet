<%@page import="service.UserService" %>
<%@page import="model.User" %>
<%@page import="model.TypeMov" %>
<%@page import="dao.TypeMovDAO" %>
<%@page import="model.Wallet" %>
<%@page import="service.WalletService" %>
<%@page import="service.MovimentationService" %>
<%@page import="model.Movimentation" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movimentation</title>
    <link rel="stylesheet" href="../css/movimentation.css">
    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

</head>
<body>
<%User us = (User)session.getAttribute("userSession"); %>
    <nav class="sidebar close">
        <header>
            <li class="nav-link">
                <a href="#">
                    <i class='bx bx-user icon'></i>
                    <span class="text nav-text">User</span>
                </a>
            </li>
            <i class='bx bx-chevron-right toggle'></i>
        </header>

        <div class="menu-bar">
            <div class="menu">

                <ul class="menu-links">

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-plus-circle icon'></i>
                            <span id="registerW" class="text nav-text">Register wallet</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-receipt icon'></i>

                            <span class="text nav-text">Movimentation</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-money-withdraw icon'></i>
                            <span class="text nav-text">Withdraw money</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-money icon'></i>
                            <span class="text nav-text">Deposit</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-wallet icon'></i>
                            <span class="text nav-text">Wallets</span>
                        </a>
                    </li>

                </ul>
            </div>

            <div class="bottom-content">
                <li class="">
                    <a href="#">
                        <i id="logOut" class='bx bx-log-out icon'></i>
                        <span class="text nav-text">Logout</span>
                    </a>
                </li>

                <li class="mode">
                    <div class="sun-moon">
                        <i class='bx bx-moon icon moon'></i>
                        <i class='bx bx-sun icon sun'></i>
                    </div>
                    <span class="mode-text text">Dark mode</span>

                    <div class="toggle-switch">
                        <span class="switch"></span>
                    </div>
                </li>

            </div>
        </div>

    </nav>
    <section class="home">
        <div class="text">Your movimentation</div>
    </section>

    <section id="main_movi">
        <div class="main_container">
            <div class="date">
                <h3>Date</h3>
                <span>16/02/2022</span>
            </div>
            <div class="money">
                <h3>Money</h3>
                <span>RS 50,00</span>
            </div>
            <div class="type">
                <h3>Movimentation's type</h3>
                <span>Deposit</span>
            </div>
            
        </div>

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
<% 
	List<TypeMov> list;
	list = (ArrayList<TypeMov>)session.getAttribute("typeMovi");
	TypeMovDAO t = new TypeMovDAO();
	
	list = t.listar();
						
	%>
	
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
    </section>

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- ----------SCRIPT ------------- -->
    <script src="../js/home.js"></script>
</body>
</html>