package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import dao.WorkTableDao;
import domain.User;
import domain.WorkTable;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/userRegistration")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//所属部門を呼び出す為の処理11/29
		WorkTableDao workDao = DaoFactory.createWorkTableDao();
		List<WorkTable>WorkList = workDao.findAll();
		request.setAttribute("WorkList", WorkList);
		
		request.getRequestDispatcher("/WEB-INF/view/userRegistration.jsp").forward(request, response);
	}catch(Exception e) {
		throw new ServletException(e);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		//入力値の取得確認
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String workId = request.getParameter("workId");
		
		
		//Daoを使いDB登録
		UserDao dao = DaoFactory.createUserDao();
		dao.insert(new User(null,name,password,workId));
		
	
		//新規登録が完了したらログインページへ移行
		response.sendRedirect(request.getContextPath() +"/login" );
		return;
	}

}
