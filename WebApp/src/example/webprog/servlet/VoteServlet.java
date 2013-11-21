package example.webprog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/vote.do")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HashSet<String> voters = new HashSet<String>();
	String[] lang = { "Java", "C#", "C", "Pascal" };
	int[] count = new int[4];

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteServlet() {
		super();
	}

	@Override
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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet VoteServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h4>Servlet VoteServlet at " + request.getContextPath() + "</h4>");

		String ip = request.getRemoteAddr();
		if (voters.contains(ip)) {
			out.print("<font color='red'>IP Address: " + ip + " has been voted</font><br>");
		} else {
			String vote = request.getParameter("lang");
			if (vote != null) {
				int voteIdx = Integer.parseInt(vote) - 1;
				count[voteIdx]++;
				voters.add(ip);
			}
		}

		for (int i = 0; i < count.length; i++) {
			out.println(lang[i] + " = " + count[i] + "<BR>");
		}

		out.println("<a href='vote/vote.jsp'><b>Back to Vote Page<b></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
