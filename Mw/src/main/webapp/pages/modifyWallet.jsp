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
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modification Wallet</title>
    <link rel="stylesheet" href="../css/modifyW.css">

    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>

<!-------------------USUARIO LOGADO------------------------------>

<%User us = (User)session.getAttribute("userSession"); %>
<%Wallet w = (Wallet)session.getAttribute("walletSelected"); %>

<!--------------------------------------------------------------->


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
                        <a href="#">
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
                        <a href="TransactionsWallet.jsp">
                            <i class='bx bx-money-withdraw icon'></i>
                            <span class="text nav-text">Withdraw money</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="TransactionsWallet.jsp">
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
        <div class="text">Your wallets</div>
    </section>

    
    
    <section id="main_wallet">

        <div class="wallet" id="new">
            <img src="../imgs/moneyGreen.svg" alt="">
            <div class="main_container">
                <h2>New Wallet</h2>
                <form action="" method="post">
                   
                <div class="input-data">

                    <input type="text" name="personName" id="personName" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Name</label>

                </div>

                <div class="input-data">

                    <input type="text" name="userName" id="userName" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Money</label>

                </div>

                    <button class="btn"><i class='bx bx-right-arrow-circle icon moon'></i></button>

                </form>
                
            </div>

        </div>


        <div class="wallet" id="new">
            <img src="../imgs/moneyGreen.svg" alt="">
            <div class="main_container">
                <h2>Change Wallet</h2>
                <form action="../ModifyWalletServlet" method="post">
                   
                <div class="input-data">
                    <input type="hidden" value="<%=w.getId() %>" name="id" id="id">
                    <input type="text" value="<%=w.getNameWallet()%>" name="nameWallet" id="nameWallet" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Name</label>

                </div>

                    <button class="btn"><i class='bx bx-right-arrow-circle icon moon'></i></button>

                </form>
                
            </div>

        </div>

        
        <div class="wallet" id="new">
            <img src="../imgs/wallet_up.svg" alt="">
            <div class="main_container">
                <h2>Deposit Money</h2>
                <form action="" method="post">
                   
                <div class="input-data">

                    <input type="text" name="personName" id="personName" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Name</label>

                </div>

                    <button class="btn"><i class='bx bx-right-arrow-circle icon moon'></i></button>

                </form>
                
            </div>

        </div>

        <div class="wallet" id="new">
            <img src="../imgs/wallet_down.svg" alt="">
            <div class="main_container">
                <h2>Withdraw Money</h2>
                <form action="" method="post">
                   
                <div class="input-data">

                    <input type="text" name="personName" id="personName" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Name</label>

                </div>

                    <button class="btn"><i class='bx bx-right-arrow-circle icon moon'></i></button>

                </form>
                
            </div>

        </div>
        
        
    </section>


    
    <!-- ----------SCRIPT ------------- -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/home.js"></script>
</body>

</html>