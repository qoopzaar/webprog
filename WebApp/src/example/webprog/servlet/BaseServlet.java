package example.webprog.servlet;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/base")
public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = -8736679648168143711L;
//	@Resource(name = "jdbc/test")
//	protected DataSource dataSource = null;
	protected Connection connection = null;

	DB db = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		try {
			initMySQL();
			initMongoDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initMySQL() throws ServletException {
		try {
			connection = (Connection) getServletContext().getAttribute("connection");
//			connection = dataSource.getConnection();
			System.out.println("Connected to... " + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initMongoDB() throws ServletException {
		try {
			Mongo mongo = new Mongo();
			// Mongo mongo = new Mongo("localhost");
			// Mongo mongo = new Mongo("localhost", 27017);
			db = mongo.getDB("test");
			System.out.println("Connected to... " + mongo);

			// if (!db.collectionExists("books")) {
			// db.createCollection("books", null);
			// }
			db.createCollection("books", null);
			db.createCollection("member", null);
			// System.out.println("Create if does not exist, [books, member] ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
