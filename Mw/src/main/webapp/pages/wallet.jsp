<%@page import="service.UserService" %>
<%@page import="model.User" %>
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
    <title>Wallets</title>
    <link rel="stylesheet" href="../css/wallet.css">

    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
	<%User us = (User)session.getAttribute("userSession"); %>
	
    <nav class="sidebar close">
        <header>
            <li class="nav-link">
                <a href="user.jsp">
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
        <div class="text">Your wallets</div>
    </section>
    <section id="main_wallet">
    
    <div class="wallet">
            <img src="../imgs/Wallet_brown.svg" alt="">
            <div class="main_container">

                <form action="../InsertWalletServlet" method="post">
                    <div class="input-data">

                        <input type="text" name="nameWlt" id="nameWlt" autocomplete="off" required>
                        <div class="underline"></div>
    
                        <label>Name</label>
    
                    </div>
    
                    <div class="input-data">
    
                        <input type="text" name="value" id="value" autocomplete="off" required>
                        <div class="underline"></div>
    
                        <label>Money</label>
    
                    </div>

                    <!-- USURIO -->
                    <input type="hidden" name="idUs" id="idUs" value="<%=us.getId()%>"/>
                    <button class="btn btn1" id="enter">

                        <strong> Enter</strong>
    
                    </button>
                </form>

            </div>

        </div>
			
			<% WalletService serviceW = new WalletService();
			   List<Wallet> listW = new ArrayList<Wallet>();
			
			  listW = serviceW.listWallet(us.getId());
			
			  for(Wallet w: listW){%>
			
		<div class="wallet">
		
            <img src="../imgs/Wallet_brown.svg" alt="">
            
           	<div class="main_container">
           	
                <h2><%=w.getNameWallet()%></h2>
                <span>R$ <%=w.getBudget() %></span>
                
                <a href="../PrepareModificationWalletServlet?id=<%=w.getId()%>"><img src="images/edit.png" width="24px"/></a>
                <img src="images/delete.png" width="24px" onclick="confirmDeleteWallet(<%=w.getId()%>)"/>
                
            </div>

        </div>
			<%
			}
			%>
        
    </section>



    <!-- ----------SCRIPT ------------- -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/home.js"></script>
</body>

</html>