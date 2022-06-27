<%@page import="service.UserService" %>
<%@page import="model.User" %>
<%@page import="model.Wallet" %>
<%@page import="service.WalletService" %>
<%@page import="service.MovimentationService" %>
<%@page import="model.Movimentation" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="dao.MovimentationDAO" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../css/home.css">

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
                    <span class="text nav-text"><%=us.getUserName() %></span>
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
                            <span id = "registerW" class="text nav-text">Register wallet</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="movimentation.jsp">
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
                        <a href="wallet.jsp">
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
        <div class="text">Welcome to home</div>
    </section>
    
	<% MovimentationDAO mo = new MovimentationDAO();
	List<Movimentation> lis = new ArrayList<Movimentation>();
	double calc = 0;
	lis = mo.listDeposits(us.getId(), 1);
	
	for(Movimentation i: lis){
	
		calc += i.getMoney();
		
	}
	
	%>
	
	<h1>Todos depositos: </h1>
	
	
		<% MovimentationDAO movime = new MovimentationDAO();
	List<Movimentation> listaW = new ArrayList<Movimentation>();
	double calcW = 0;
	lis = movime.listWithdraw(us.getId(), 2);
	
	for(Movimentation i: lis){
	
		calcW += i.getMoney();
		
	}
	%>
	<h1>Todos saques:</h1>
	
	<h1>Todos dinheiro: </h1>
    <section id="main">

        <div class="withdraw">

            <div class="main_container">
                <h2> Day's Withdraw </h2>
                <span>R$  <%=calcW %></span>
            </div>
            <img src="../imgs/money_down.svg" alt="">

        </div>

        <div class="wallets">
            <div class="main_container">
                <h2>Your wallets</h2>
            </div>
            <img src="../imgs/Wallet_brown.svg" alt="">
        </div>

        <div class="deposit">
            <div class="main_container">
                <h2>Day's deposit</h2>
                <span>R$ <%=calc %></span>
            </div>
            <img src="../imgs/money_up.svg" alt="">
        </div>

        <div class="money">
            <div class="main_container">
                <h2>Money </h2>
                <span>R$ <%=calc - calcW %></span>
            </div>
            <img src="../imgs/money.svg" alt="">
        </div>
    </section>

    <div class="ocean">

        <div class="wave"></div>
        <div class="wave"></div>

    </div>

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- ----------SCRIPT ------------- -->
    <script src="../js/home.js"></script>

</body>

</html>