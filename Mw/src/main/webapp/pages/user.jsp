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
    <title>User</title>

    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="../css/user.css">

    <script>
        function confirmDeleteUser(id){
            var answer = Swal.fire({
            	  title: 'Are you sure?',
            	  text: "You won't be able to revert this!",
            	  icon: 'warning',
            	  showCancelButton: true,
            	  confirmButtonColor: '#3085d6',
            	  cancelButtonColor: '#d33',
            	  confirmButtonText: 'Yes, delete it!'
            	}).then((result) => {
            	  if (result.isConfirmed) {
            	    Swal.fire(
            	      'Deleted!',
            	      'Your file has been deleted.',
            	      'success'
            	    )
            	  }
            	});
            
            if(answer == true){
                window.location.href = "../DeleteUserServlet?id=" + id;
            }
        }
        </script>
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
                            <span class="text nav-text">Withdraw money</span>
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
      
        <div class="info">

            <h2>Your infos</h2>

            <div class="container_info">
                <%
                UserService serviceU = new UserService();
                List<User> list = new ArrayList<User>();
                
                list = serviceU.list(us.getId());
                
                for(User usr: list){%>

                <div class="name">

                    <span><strong>Name:</strong> <%=usr.getPersonName() %></span>
                    
                </div>

                <div class="underline"></div>

                <div class="userName">
                    <span><strong>Username:</strong> <%=usr.getUserName() %></span>
                   
                </div>

                <div class="underline"></div>

                <div class="password">
                    <span><strong>Password:</strong> <%=usr.getUserPassword() %></span>
                    
                </div>

                <div class="underline"></div>

                <div class="cpf">
                    <span><strong>CPF:</strong><%=usr.getCpf() %></span>
                   
                </div>

                <div class="underline"></div>

                <div class="container_icons">
                    <a href="../PrepareModificationServlet?id=<%=usr.getId()%>" id="edit"><i class='bx bx-edit icon '></i></a>
                    <a href="#" onclick="confirmDeleteUser(<%=usr.getId()%>)"><i class='bx bx-x-circle icon '></i></a>
                </div>

            <%
			}
			%>
            </div>
            
        </div>

        <div class="modification">
            <h2>Change your datas</h2>
            <form action="../ModifyUserServlet" method="post">
                <input type="hidden" name="id" id="id" value="<%=us.getId() %>">

                <div class="input-data">

                    <input type="text" value="<%=us.getPersonName() %>" name="personName" id="personName" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Name</label>

                </div>

                <div class="input-data">

                    <input type="text" value="<%=us.getUserName() %>" name="userName" id="userName" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Username</label>

                </div>
                <div class="input-data">

                    <input type="text" value="<%=us.getUserPassword() %>" name="userPassword" id="userPassword" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>Password</label>

                </div>
                <div class="input-data">

                    <input type="text" value="<%=us.getCpf() %>" name="cpf" id="cpf" autocomplete="off" required>
                    <div class="underline"></div>

                    <label>CPF</label>

                </div>

                <button class="btn">Modify</button>

            </form>
            
        </div>

        

    </section>


    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/home.js"></script>

</body>

</html>