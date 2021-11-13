<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="App.User"%>
    <% User user = (User) session.getAttribute("userlog");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TempVisualisation | Home</title>

<style>
     <%@ include file="css/normalize.css"%>
     <%@ include file="css/home.css"%>
     <%@ include file="css/global.css"%>
</style>

</head>
<body>

	<header>
		
		<img id="logo" src="img/IMS1.png" />
		<nav >
  <a href="System.jsp">Home</a>
			<a href="TableServlet">Data Visual</a>
			<a href="statservlet">Statistics</a>
			<a href="graph.jsp">Graph</a>
			<a href="LogoutServlet">Log Out</a> 
			<a href="contact.jsp">Contact</a>
</nav>

		

	</header>
	<section id="slideshow">

		<section id="content">
			
			<h1> Welcome, <%= user.getName() %></h1>

			

	</section>

		
		<img id="slide" src="img/arduino.jpg">

	</section>

	 

</body>
</html>