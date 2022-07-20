<%@page import="service.UserService" %>
<%@page import="model.User" %>
<%@page import="model.Wallet" %>
<%@page import="service.WalletService" %>
<%@page import="service.MovimentationService" %>
<%@page import="model.Movimentation" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="dao.MovimentationDAO" %>
<%@page import="java.util.Objects" %>
<!-------------------USUARIO LOGADO------------------------------>

<%
User us = (User) session.getAttribute("userSession");
%>

<!--------------------------------------------------------------->

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
    <script>
        function confirmDeleteWallet(id){
            var answer = confirm("Confirma a exclusão do registro?");
            
            if(answer == true){
                window.location.href = "../DeleteWalletServlet?id=" + id;
            }
        }
        </script>
    
</head>

<body>
     <% if(!Objects.isNull(us)){%>


    <nav class="sidebar close">
        <header>
            <li class="nav-link">
                <a href="user.jsp">
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
                        <a href="transactionsWallet.jsp">
                            <i class='bx bx-plus-circle icon'></i>
                            <span id="registerW" class="text nav-text">Register wallet</span>
                        </a>
                    </li>
                    
                     <li class="nav-link">
                        <a href="home.jsp">
                            <i class='bx bx-home icon'></i>

                            <span class="text nav-text">Home</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="movimentation.jsp">
                            <i class='bx bx-receipt icon'></i>

                            <span class="text nav-text">Movimentation</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="transactions.jsp">
                            <i class='bx bx-money-withdraw icon'></i>
                            <span class="text nav-text">Transactions</span>
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
                    <a href="../LogoutServlet">
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

        <% WalletService serviceW = new WalletService();
        List<Wallet> listW = new ArrayList<Wallet>();
     
       listW = serviceW.listWallet(us.getId());
     
       for(Wallet w: listW){%>

        <div class="wallet">
            <img src="../imgs/Wallet_brown.svg" alt="">
            <div class="main_container">

                <h2><%=w.getNameWallet()%></h2>
                <span>R$ <%=w.getBudget() %></span>


            </div>

            <div class="container_icons">
                <a href="../PrepareModificationWalletServlet?id=<%=w.getId()%>"><i class='bx bx-edit icon '></i></a>
                <a href="#" onclick="confirmDeleteWallet(<%=w.getId()%>)"><i class='bx bx-x-circle icon '></i></a>
                <a href=""><i class='bx bx-wallet-alt icon '></i></a>
            </div>

        </div>


        <%
		}
		%>
        
    </section>


    
    <!-- ----------SCRIPT ------------- -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/home.js"></script>
      <%} else{
    	
    	response.sendRedirect("error.html");%>
 
    	<% } %>
</body>

</html>