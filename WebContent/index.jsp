<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% session.getAttribute("RegError1");%> 
    
    
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join Us</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
       <style>
     <%@ include file="css/Style.css"%>
</style>
        
</head>
<body>
 <div class="container">
            <div class="box">
                <img class="avatar" src="img/login.png" />
                
                
                <h1>
Login Account</h1>
<form action="LoginServlet" method="post">
                    <p>
Username</p>
<input type="text" placeholder="Username" name="name" required>
                    <p>
Password</p>
<input type="password" placeholder="Password" name="password" required>
                    <input type="submit" value="Login">
                    <a href="forgetpass.jsp">Forget Password?</a><br>
                    <a href="registration.jsp">Create New Account</a>
                </form>
</div>
</div>
</body>
</html>