package example.webprog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CusomerServlet
 */
@WebServlet("/addCustomer.do")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Customer Information</title>");
		out.println("</head>");
		out.println("<body>");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		String fax = request.getParameter("fax");
		String email = request.getParameter("email");
		out.println("<h2> Customer Information </h2>");
		out.println("<b>ID: </b>" + id + "<BR>");
		out.println("<b>Name: </b>" + name + "<BR>");
		out.println("<b>Address: </b>" + addr + "<BR>");
		out.println("<b>Mobile: </b>" + mobile + "<BR>");
		out.println("<b>Fax: </b>" + fax + "<BR>");
		out.println("<b>E-mail: </b>" + email + "<BR>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
