<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.SQLException  ,java.text.SimpleDateFormat" %>
    <%@ page import="App.DBConn" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%
Gson gsonObj = new Gson();
Map<Object,Object> map1 = null;
Map<Object,Object> map2 = null;
List<Map<Object,Object>> list1 = new ArrayList<Map<Object,Object>>();
List<Map<Object,Object>> list2 = new ArrayList<Map<Object,Object>>();
String dataPoints1 = null;
String dataPoints2 = null;

try{
Connection con =DBConn.ConnectDB();
String query="select * from dht22";
PreparedStatement pt=con.prepareStatement(query);
ResultSet rs = pt.executeQuery();

while(rs.next()){
	int id = rs.getInt("ID");
    float temperature = rs.getFloat("temperature");
    float humidity = rs.getFloat("humidity");
    SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
    
    
    
    map1 = new HashMap<Object,Object>();
    map1.put("x", id);
    map1.put("y", temperature);
    list1.add(map1);
    dataPoints1 = gsonObj.toJson(list1);
    
    map2 = new HashMap<Object,Object>();
    map2.put("x", id);
    map2.put("y", humidity);
    
    list2.add(map2);
    dataPoints2 = gsonObj.toJson(list2);
}
}catch (SQLException e) {
	e.printStackTrace();
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
window.onload = function() { 
 
<% if(dataPoints1 != null) { %>
var chart = new CanvasJS.Chart("chartContainer1", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "Temprature"
	},
	data: [{
		type: "line", //change type to bar, line, area, pie, etc
		dataPoints: <%out.print(dataPoints1);%>, color: "Red"
	}]
});
chart.render();
<% } %> 

<% if(dataPoints2 != null) { %>
var chart = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "Humidity"
	},
	data: [{
		type: "line", //change type to bar, line, area, pie, etc
		dataPoints: <%out.print(dataPoints2);%>, color: "Indigo"
	}]
});
chart.render();
<% } %> 
 
}
</script>
<title>TempHumVisualisation | Graph</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>

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
			<div id="chartContainer1" style="height: 370px; width: 100%; right: 550px; position: absolute;"></div>
			<div id="chartContainer2" style="height: 370px; width: 100%; left: 50px;  position: absolute;"></div>
			<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
			

			

	</section>

		
		<img id="slide" src="img/arduino.jpg">

	</section>

	 

</body>
</html>