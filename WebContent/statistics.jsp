<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TempHumVisualisation | statistic</title>
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
    <th ></th>
    <th >Mean</th>
    <th>Median</th>
    <th >Mode</th>
    <th >Standard deviation</th>
    <th >Variance</th>
    <th >Min</th>
    <th >Max</th>
    
    
    
  </tr>
  
  </thead>
  
  <tbody>
				
					<c:forEach var="user" items="${liststat}">

						<tr>
							<td>Humidity</td>
							<td><c:out value="${user.meanh}" /></td>
							<td><c:out value="${user.medianh}" /></td>
							<td><c:out value="${user.modeh}" /></td>
							<td><c:out value="${user.standivh}" /></td>
							<td><c:out value="${user.varianceh}" /></td>
							<td><c:out value="${user.minh}" /></td>
							<td><c:out value="${user.maxh}" /></td>
							
							
						</tr>
						<tr>
						<td>Temperature</td>
							<td><c:out value="${user.meant}" /></td>
							<td><c:out value="${user.mediant}" /></td>
							<td><c:out value="${user.modet}" /></td>
							<td><c:out value="${user.standivt}" /></td>
							<td><c:out value="${user.variancet}" /></td>
							<td><c:out value="${user.mint}" /></td>
							<td><c:out value="${user.maxt}" /></td>
							
					</tr>
		</c:forEach>
				</tbody>
</table>
</section>

		
		
		<img id="slide" src="img/arduino.jpg">

	</section>
	

</body>
</html>