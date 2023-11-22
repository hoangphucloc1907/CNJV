package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SignupServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getConnection();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			UserAccount user = new UserAccount(username, password, gender);
			DBUtils.insertUserAccount(conn, user);
			request.setAttribute("username", username);
			request.getRequestDispatcher("jsp/Login.jsp").forward(request, response);
			
		}catch(ClassNotFoundException ex) {
			logger.log(Level.SEVERE, null, ex);
		}catch(SQLException ex) {
			logger.log(Level.SEVERE, null, ex);
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException ex) {
					logger.log(Level.SEVERE, null, ex);
				}
			}
		}
	}

}
