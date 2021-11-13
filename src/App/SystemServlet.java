package App;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.List;
/**
 * Servlet implementation class LoginServlet
 */

public class SystemServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UserDB user;
	Connection con=null;
    public SystemServlet() {
        super();
        con=DBConn.ConnectDB();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getServletPath();
		try {
		switch(action)
		{
		case"/LogoutServlet":
			logoutservlet(request,response);
			break;
		case"/LoginServlet":
			loginservlet(request,response);
			break;
		case"/RegisterServlet":
			registrationservlet(request,response);
			break;
		case"/ForgetpassServlet":
			forgetpassservlet(request,response);
			break;
		case"/TableServlet":
			Datavisual(request,response);
			break;
		case"/statservlet":
			statistics(request,response);
			break;
		
		
		}
		}catch (SQLException ex) {
			throw new ServletException(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void loginservlet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user=new User(name, password);
		UserDB loguser = new UserDB();
		
		if(loguser.userlog(user)) {
			HttpSession session = request.getSession();
            session.setAttribute("userlog", user);
            response.sendRedirect("System.jsp");
		}
		else {
			String errorMessage = "User not found";
		    HttpSession session = request.getSession();
		    session.setAttribute("logError", errorMessage);
			 response.sendRedirect("index.jsp");
		}
		}
		private void registrationservlet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			//make user object
			//User userModel = new User(name, email, password);
			User user1 = new User(name,email,password);
			
			UserDB regUser = new UserDB();
			
				try {
					if (regUser.Userver(user1)) {
						String errorMessage = "User Available";
					    HttpSession regSession = request.getSession();
					    regSession.setAttribute("RegError", errorMessage);
					   response.sendRedirect("registration.jsp");
					}
					else {
					  regUser.saveUser(user1);
					  response.sendRedirect("index.jsp");
					   }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		private void forgetpassservlet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user = new User(name,email,password);
			UserDB userpass = new UserDB();
			
			try {
				if (userpass.updatepass(user)) {
					
				   response.sendRedirect("index.jsp");
				}
				else {
				  
				  response.sendRedirect("forgetpass.jsp");
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void logoutservlet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			HttpSession session = request.getSession();
	        session.removeAttribute("userlog");
	        response.sendRedirect("index.jsp");
			
		}
		
		private void Datavisual(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			user =new UserDB();
			String query1="select * from dht22";
			
			
			PreparedStatement pt1=con.prepareStatement(query1);
			ResultSet rs1 = pt1.executeQuery();
			
			
			
			
			
			
					List<User> listData = user.selectAllData(rs1);
					request.setAttribute("listData", listData);
					RequestDispatcher dispatcher = request.getRequestDispatcher("TempTable.jsp");
					dispatcher.forward(request, response);
					
				
				}
		private void statistics(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			user =new UserDB();
			String query1="select * from dht22";
			
			
			PreparedStatement pt1=con.prepareStatement(query1);
			ResultSet rs1 = pt1.executeQuery();
			
			List<User> liststat = user.statistic(rs1);
			request.setAttribute("liststat", liststat);
			RequestDispatcher dispatcher = request.getRequestDispatcher("statistics.jsp");
			dispatcher.forward(request, response);
			
		}
				
			
				
			
		}
		
		
		


