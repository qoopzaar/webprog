package example.webprog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import example.webprog.entity.Book;

/**
 * Servlet implementation class MongoDBServlet
 */
@WebServlet("/mongo.do")
public class MongoDBServlet extends BaseServlet {

	private static final long serialVersionUID = 351203908643801146L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MongoDBServlet() {
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
		String forward = "/bookStore/success.jsp";
		try {

			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String price = request.getParameter("price");

			DBCollection books = db.getCollection("books");
			System.out.println(books.getFullName());
			System.out.println(books.find());

			// Book book = new Book(isbn, title, author,
			// Double.parseDouble(price));
			BasicDBObject book = new BasicDBObject();
			book.put("isbn", isbn);
			book.put("title", title);
			book.put("author", author);
			book.put("price", Double.parseDouble(price));
			books.insert(book);

			DBObject ref = new BasicDBObject("title", "Java");
			System.out.println(books.find(ref));

			DBCursor bookCursor = books.find();
			while (bookCursor.hasNext()) {
				System.out.println(bookCursor.next());
			}

			Set<String> colls = db.getCollectionNames();
			System.out.println(colls);
			for (String s : colls) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
			forward = "/bookStore/error.jsp";
		}
		request.getRequestDispatcher(forward).forward(request, response);

	}

}
