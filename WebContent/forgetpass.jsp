<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Account</title>
<style>
     <%@ include file="css/Style.css"%>
     
</style>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        
    </head>
    <body>
        <div class="container">
            <div class="regbox box">
                <img class="avatar" src="img/password.png">
                <h1>
Password Update</h1>
<form action="ForgetpassServlet" method="post">
                   <p>
Username</p>
<input type="text" placeholder="Username" name="name" required>
                   <p>
Useremail</p>
<input type="text" placeholder="Useremail" name="email" required>
                   <p>
New Password</p>
<input type="password" placeholder="New Password" name="password" required>
                   <input type="submit" value="Save">
                   <a href="index.jsp">Already have Account?</a>
                </form>
</div>
</div>
</body>
</html>