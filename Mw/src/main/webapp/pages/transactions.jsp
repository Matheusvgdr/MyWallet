<%@page import="service.UserService" %>
<%@page import="model.User" %>
<%@page import="model.Wallet" %>
<%@page import="model.TypeMov" %>
<%@page import="dao.TypeMovDAO" %>
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
    <title>Transactions</title>

    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="../css/transactions.css">
</head>

<body>

       <!-------------------USUARIO LOGADO------------------------------>

       <%User us = (User)session.getAttribute("userSession"); %>


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
                        <a href="wallet.html">
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
                    <a href="../index.html">
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
        <div class="text">Your profile</div>
    </section>

 

    <section id="main_user">
      
        <div class="transactions">
        
                <% 
                List<TypeMov> list;
                list = (ArrayList<TypeMov>)session.getAttribute("typeMovi");
                TypeMovDAO t = new TypeMovDAO();
                
                list = t.listar();
                                    
                %>
        
            <h2>Deposit or withdraw your money</h2>
            <form action="../TransactionsServlet" method="post">
                <input type="hidden" name="idUs" id="idUs" value="<%=us.getId() %>">

                <div class="input-data">

                    <input type="date" name="dateMovi" id="dateMovi" autocomplete="off" required>


                </div>

                <div class="input-data">

                    <input type="number" name="money" id="money" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Money</label>

                </div>

                <div class="input-data">

                    <input type="hidden" name="type" id="type" value="0" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Type</label>

                </div>

                <div class="input-data">

                    <input type="hidden" name="userPassword" id="userPassword" autocomplete="off" required>
                    <div class="underline"></div>


                </div>

                
                <select name="idType" id="idType">
                
                    <option value="0" ><strong>Select...</strong></option>
                    
                    <% for(TypeMov tp: list){%>
                    
                      <option value="<%=tp.getId() %>"><strong><%=tp.getDescription() %></strong></option>
                      
                      
                      <% }%>
            
                      
                </select>

                <button class="btn">Enter</button>

            </form>
            
        </div>
        

    </section>


    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/home.js"></script>

</body>

</html>