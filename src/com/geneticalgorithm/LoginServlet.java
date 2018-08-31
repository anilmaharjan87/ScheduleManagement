package com.geneticalgorithm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geneticalgorithm.dao.LoginDao;
import com.geneticalgorithm.domain.Admin;
import com.geneticalgorithm.utils.GAConstants;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin theAdmin = new Admin(username, password);
		int result = LoginDao.verifyAdmin(theAdmin);
		if (result == GAConstants.LOGIN_SUCCESS) {
			request.setAttribute("login",true);
			/*request.getRequestDispatcher("/").forward(request, response);*/
			IndexServlet indexServlet=new IndexServlet();
			indexServlet.doGet(request, response);
			
		}  else {
			request.setAttribute("login", false);
			IndexServlet indexServlet=new IndexServlet();
			indexServlet.doGet(request, response);
			
		 }
 
	}

}
