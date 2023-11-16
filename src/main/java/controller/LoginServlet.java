package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		try {	//入力値の取得
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			//入力値の確認
			System.out.println(name);
			System.out.println(password);
			UserDao userDao = DaoFactory.createUserDao();
			User user = userDao.findByLoginAndPass(name, password);

			if(user != null) {               //この1個目のuserはログインフィルターの「user」と一緒
			request.getSession().setAttribute("user", user.getName());
			System.out.println("1"+request.getSession().getAttribute("name"));
			//インシデント登録ページにいく
			response.sendRedirect("addIncident");
			return;
			}else {
				//ログイン名とパスワードが間違えていたらエラーメッセージ
				request.setAttribute("error", "ログインIDまたはパスワードが間違えています");
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				throw new ServletException(e);
			}
			


		}
	}


