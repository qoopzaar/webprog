package example.webprog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import example.webprog.entity.Book;

/**
 * Servlet implementation class ChooseBookServlet
 */
@WebServlet("/chooseBook.do")
public class ChooseBookServlet extends BaseServlet {

	private static final long serialVersionUID = -7628042918421979764L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChooseBookServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
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
		PreparedStatement preparedStatement = null;
		try {
			String sql = "select isbn, title, author, price from books order by title";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);
			List<Book> books = new ArrayList<>();
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				books.add(book);
			}
			System.out.println(books);
			request.setAttribute("books", books);
			request.getRequestDispatcher("/bookStore/chooseBook.jsp").forward(request, response);
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
		try {
			List<Book> books = new ArrayList<>();

			DBCollection booksColl = db.getCollection("books");
			DBCursor cursor = booksColl.find();

			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				Book book = new Book();
				book.setIsbn(dbObject.get("isbn").toString());
				book.setTitle(dbObject.get("title").toString());
				book.setAuthor(dbObject.get("author").toString());
				book.setPrice(Double.parseDouble(dbObject.get("price").toString()));
				books.add(book);
			}
			System.out.println(books);
			request.setAttribute("books", books);
			request.getRequestDispatcher("/bookStore/chooseBook.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.write("Error..." + e.getMessage());
		}
	}
}
