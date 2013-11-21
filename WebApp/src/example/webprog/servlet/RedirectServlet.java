package example.webprog.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect.do")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectServlet() {
		super();
		// TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String s = headerNames.nextElement();
			System.out.println(s + "\t= " + request.getHeader(s));
		}

		System.out.println("" + request.getHeader("user-agent"));

		String userAgent = request.getHeader("user-agent");
		if (userAgent.contains("MSIE")) {
			response.sendRedirect("http://www.microsoft.com/");
		} else if (userAgent.contains("Firefox")) {
			response.sendRedirect("http://www.mozilla.org");
		} else if (userAgent.contains("Chrome")) {
			response.sendRedirect("http://www.google.com");
		}
		
		
//		Chrome
//		host	= localhost:8080
//		connection	= keep-alive
//		accept	= text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//		user-agent	= Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36
//		referer	= http://localhost:8080/WebApp/
//		accept-encoding	= gzip,deflate,sdch
//		accept-language	= en-US,en;q=0.8
//		Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36
//		
//		
//		Firefox
//		host	= localhost:8080
//		user-agent	= Mozilla/5.0 (Windows NT 6.1; WOW64; rv:17.0) Gecko/20100101 Firefox/17.0
//		accept	= text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//		accept-language	= en-US,en;q=0.5
//		accept-encoding	= gzip, deflate
//		connection	= keep-alive
//		referer	= http://localhost:8080/WebApp/
//		Mozilla/5.0 (Windows NT 6.1; WOW64; rv:17.0) Gecko/20100101 Firefox/17.0
//		
//		
//		IE
//		accept	= application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, application/x-ms-xbap, application/x-shockwave-flash, application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint, */*
//		referer	= http://localhost:8080/WebApp/
//		accept-language	= en-US
//		user-agent	= Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)
//		accept-encoding	= gzip, deflate
//		host	= localhost:8080
//		connection	= Keep-Alive
//		Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)
//

	}

}
