<%@page import="service.UserService"%>
<%@page import="model.User"%>
<%@page import="model.Wallet"%>
<%@page import="service.WalletService"%>
<%@page import="service.MovimentationService"%>
<%@page import="model.Movimentation"%>
<%@page import="model.MoviWallet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MovimentationDAO"%>
<%@page import="dao.MoviWalletDAO"%>
<%@page import="java.util.Objects"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movimentation</title>
<link rel="stylesheet" href="../css/movimentation.css">
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

</head>
<body>

	<!-------------------USUARIO LOGADO------------------------------>

	<%
	User us = (User) session.getAttribute("userSession");
	%>

	<!--------------------------------------------------------------->

	<%
	if (!Objects.isNull(us)) {
	%>
	<nav class="sidebar close">
		<header>
			<li class="nav-link"><a href="user.jsp"> <i
					class='bx bx-user icon'></i> <span class="text nav-text">><%=us.getUserName()%></span>
			</a></li> <i class='bx bx-chevron-right toggle'></i>
		</header>

		<div class="menu-bar">
			<div class="menu">

				<ul class="menu-links">

					<li class="nav-link"><a href="transactionsWallet.jsp"> <i
							class='bx bx-plus-circle icon'></i> <span id="registerW"
							class="text nav-text">Register wallet</span>
					</a></li>

					<li class="nav-link"><a href="home.jsp"> <i
							class='bx bx-home icon'></i> <span class="text nav-text">Home</span>
					</a></li>

					<li class="nav-link"><a href="movimentation.jsp"> <i
							class='bx bx-receipt icon'></i> <span class="text nav-text">Movimentation</span>
					</a></li>

					<li class="nav-link"><a href="transactions.jsp"> <i
							class='bx bx-money-withdraw icon'></i> <span
							class="text nav-text">Transactions</span>
					</a></li>


					<li class="nav-link"><a href="wallet.jsp"> <i
							class='bx bx-wallet icon'></i> <span class="text nav-text">Wallets</span>
					</a></li>

				</ul>
			</div>

			<div class="bottom-content">
				<li class=""><a href="../LogoutServlet"> <i id="logOut"
						class='bx bx-log-out icon'></i> <span class="text nav-text">Logout</span>
				</a></li>

				<li class="mode">
					<div class="sun-moon">
						<i class='bx bx-moon icon moon'></i> <i class='bx bx-sun icon sun'></i>
					</div> <span class="mode-text text">Dark mode</span>

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

		<h2>Account Statement</h2>

		<%
		MovimentationService serviceM = new MovimentationService();
		List<Movimentation> listM = new ArrayList<Movimentation>();

		listM = serviceM.listMov(us.getId());

		for (Movimentation mv : listM) {
		%>

		<div class="main_container">

			<div class="date">
				<h3>Date</h3>
				<span><%=mv.getMoviDate()%> </span>
			</div>
			<div class="money">
				<h3>Money</h3>
				<span><%=mv.getMoney()%> </span>
			</div>
			<div class="type">
				<h3>Movimentation's type</h3>
				<span><%=mv.getId_type().getDescription()%> </span>
			</div>
			<div class="name">
				<h3>Name</h3>
				<span><%=mv.getId_user().getPersonName()%> </span>
			</div>

		</div>

		<%
		}
		%>
		
		<%
		MoviWalletDAO daoW = new MoviWalletDAO();
		List<MoviWallet> listWal = new ArrayList<MoviWallet>();

		listWal = daoW.listMov(us.getId());

		for (MoviWallet mw : listWal) {
		%>

		<div class="main_container">

			<div class="date">
				<h3>Date</h3>
				<span><%=mw.getMoviDate()%> </span>
			</div>
			<div class="money">
				<h3>Money</h3>
				<span><%=mw.getMoney()%> </span>
			</div>
			<div class="type">
				<h3>Movimentation's type</h3>
				<span><%=mw.getId_type().getDescription()%> </span>
			</div>
			<div class="name">
				<h3>Name</h3>
				<span><%=mw.getId_user().getPersonName()%> </span>
			</div>

		</div>

		<%
		}
		%>


	</section>


	<!-- ----------SCRIPT ------------- -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="../js/home.js"></script>
	<%
	} else {

	response.sendRedirect("error.html");
	%>

	<%
	}
	%>
</body>
</html>