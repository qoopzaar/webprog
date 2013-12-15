package example.webprog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook.do")
public class AddBookServlet extends BaseServlet {

	private static final long serialVersionUID = 6037413770158101320L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processMongoDB(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		processMongoDB(request, response);
	}

	protected void processMySQL(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PreparedStatement pstmt = null;
		try {
			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String price = request.getParameter("price");

			String sql = "insert into books values(?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, price);
			int rowUpdated = pstmt.executeUpdate();

			String forward = "/bookStore/error.jsp";
			if (rowUpdated > 0) {
				forward = "/bookStore/success.jsp";
			}
			request.getRequestDispatcher(forward).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.write("Cannot add new book due to.." + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void processMongoDB(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String forward = "/bookStore/success.jsp";
		try {
			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String price = request.getParameter("price");

			DBCollection booksCol = db.getCollection("books");
			BasicDBObject bookObj = new BasicDBObject();
			bookObj.put("isbn", isbn);
			bookObj.put("title", title);
			bookObj.put("author", author);
			bookObj.put("price", Double.parseDouble(price));
			booksCol.insert(bookObj);

			request.getRequestDispatcher(forward).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.write("Error..." + e.getMessage());
		} finally {
		}
	}
}
