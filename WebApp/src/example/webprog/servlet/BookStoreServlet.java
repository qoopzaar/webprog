package example.webprog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookStoreServlet
 */
@WebServlet("/bookStore.do")
public class BookStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookStoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Book Store</title>");
		out.println("</head>");
		out.println("<body>");

		String admin = "admin";
		String adminPwd = "1234";

		String user = "user";
		String userPwd = "5678";

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (admin.equalsIgnoreCase(username) && adminPwd.equals(password)) {
			out.println("<h2> Add Book </h2>");
			out.println("<b>ISBN: </b><input type='text' name='isbn'><BR>");
			out.println("<b>Title: </b><input type='text' name='title'><BR>");
			out.println("<b>Author: </b><input type='text' name='author'><BR>");
			out.println("<b>Price: </b><input type='text' name='price'><BR>");
			out.println("<input type='submit' value='Add'>");
		} else if (user.equalsIgnoreCase(username) && userPwd.equals(password)) {
			out.println("<h2> Choose Book(s) to Buy </h2>");
			out.println("<input type='checkbox' name='book' value='JSP'>JSP<BR>");
			out.println("<input type='checkbox' name='book' value='Servlet'>Servlet<BR>");
			out.println("<input type='checkbox' name='book' value='HTML'>HTML<BR>");
			out.println("<input type='checkbox' name='book' value='CSS'>CSS<BR>");
			out.println("<input type='submit' value='Choose'>");

		} else {
			out.println("<h3> Invalid Username or Password </h3>");
			out.println("<a href=\"bookStore\"><h4>Back to Login Page<h4></a>");
		}

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
