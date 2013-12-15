package example.webprog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookStoreServlet
 */
@WebServlet("/bookStore.do")
public class BookStoreServlet extends BaseServlet {

	private static final long serialVersionUID = -721829521219637394L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookStoreServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		processMySql(request, response);
	}

	protected void processMySql(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PreparedStatement preparedStatement = null;
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			String sql = "select * from member where username = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();
			String role = "";
			String pwd = "";
			if (rs.next()) {
				role = rs.getString("role");
				pwd = rs.getString("password");
			}

			if (pwd.equals(password) && role.equalsIgnoreCase("admin")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/bookStore/addBook.jsp");
				dispatcher.forward(request, response);

			} else if (pwd.equals(password) && role.equalsIgnoreCase("user")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/chooseBook.do");
				dispatcher.forward(request, response);

			} else {
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Book Store</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3> Invalid Username or Password </h3>");
				out.println("<a href=\"bookStore\"><h4>Back to Login Page<h4></a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.write("Error..." + e.getMessage());
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void processMongoDB(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PreparedStatement preparedStatement = null;
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			String sql = "select * from member where username = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();
			String role = "";
			String pwd = "";
			if (rs.next()) {
				role = rs.getString("role");
				pwd = rs.getString("password");
			}

			if (pwd.equals(password) && role.equalsIgnoreCase("admin")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/bookStore/addBook.jsp");
				dispatcher.forward(request, response);

			} else if (pwd.equals(password) && role.equalsIgnoreCase("user")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/chooseBook.do");
				dispatcher.forward(request, response);

			} else {
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Book Store</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3> Invalid Username or Password </h3>");
				out.println("<a href=\"bookStore\"><h4>Back to Login Page<h4></a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.write("Error..." + e.getMessage());
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
