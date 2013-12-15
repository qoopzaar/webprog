package listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Application Lifecycle Listener implementation class Init
 * 
 */
@WebListener
public class Init implements ServletContextListener {

	@Resource(name = "jdbc/test")
	private DataSource dataSource;
	private Connection connection;

	/**
	 * Default constructor.
	 */
	public Init() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
			connection = dataSource.getConnection();
			sce.getServletContext().setAttribute("connection", connection);
			System.out.println("Connected to... " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
