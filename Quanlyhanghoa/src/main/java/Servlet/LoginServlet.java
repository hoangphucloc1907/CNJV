package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginServlet.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getConnection();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserAccount usr = new UserAccount(username, password);
			UserAccount u = DBUtils.findUser(conn, usr.getUsername(), usr.getPassword());
			
			if(u != null) {
				UserAccount user = new UserAccount(u);
				request.setAttribute("username","Chào bạn: " + user.getUsername());
				String address = "Index.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				if (dispatcher != null) {
				    dispatcher.forward(request, response);
				} else {
				    // Log or handle the case where dispatcher is null
				    System.err.println("RequestDispatcher is null for /Index.jsp");
				}
//				request.getRequestDispatcher(address).forward(request, response);
			}else {
				response.setContentType("text/html;charset=UTF-8");
				try(PrintWriter out = response.getWriter()) {
					
					out.println (" <! DOCTYPE html>");
					out.println ("<html>");
					out.println ("<head>");
					out.println ("<title>Thông báo</title>");
					out.println ("</head>") ;
					out. println ("<body>");
					out.println ("<h1>Thông tin đang nhập không chính xác <a href=jsp/Login.jsp>Nhập lại</a></h1>");
					out.println ("</body>") ;
					out.println ("</html>");
				}
			}
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			logger.log(Level.SEVERE, null, ex);
		}catch(SQLException ex) {
			ex.printStackTrace();
			logger.log(Level.SEVERE, null, ex);
		}

	}

}
