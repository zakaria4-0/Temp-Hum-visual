<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TempVisualisation | visualise</title>
<style >
<%@ include file="css/normalize.css"%>
     <%@ include file="css/home.css"%>
     <%@ include file="css/global.css"%>
     </style>
	
	
	
</head>
<body>
<header>
		
		<img id="logo" src="img/IMS1.png">

		<nav>
			<a href="System.jsp">Home</a>
			<a href="TableServlet">Data Visual</a>
			<a href="statservlet">Statistics</a>
			<a href="graph.jsp">Graph</a>
			<a href="LogoutServlet">Log Out</a> 
			<a href="contact.jsp">Contact</a>
		</nav>

	</header>
	
<section id="slideshow">
   <section id="table">
	<table class="content-table table-fixed">
 <thead>
  <tr>
    <th >ID</th>
    <th>Humidity</th>
    <th >Temperature</th>
    <th >Time</th>
    
    
  </tr>
  </thead>
  
  <tbody>
				
					<c:forEach var="user" items="${listData}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.humidity}" /></td>
							<td><c:out value="${user.temperature}" /></td>
							<td><c:out value="${user.time}" /></td>
							
							
						</tr>
					</c:forEach>
		
				</tbody>
</table>
</section>

		
		
		<img id="slide" src="img/arduino.jpg">

	</section>
	

</body>
</html>