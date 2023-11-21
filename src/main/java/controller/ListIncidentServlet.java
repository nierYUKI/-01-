package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.IncidentManagementDao;
import dao.ServiceManagmentDao;
import dao.UserDao;
import domain.IncidentManagement;
import domain.ServiceManagment;
import domain.User;

/**
 * Servlet implementation class ListIncidentServlet
 */
@WebServlet("/ListIncident")
public class ListIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//インシデントIDをサービス名で表示する処理
		ServiceManagmentDao serviceDao = DaoFactory.createServiceManagmentDao();
		List<ServiceManagment> ServiceList = serviceDao.findAll();
		request.setAttribute("ServiceList", ServiceList);
		System.out.println(ServiceList);
		
		  //インシデント作成者を表示する処理
		UserDao userDao = DaoFactory.createUserDao();
		List<User>UserList = userDao.findAll();
		request.setAttribute("UserList", UserList);
		//System.out.println(UserList);
			//インシデントの一覧を表示させる処理
		IncidentManagementDao incidentDao = DaoFactory.createIncidentDao();
			List<IncidentManagement>IncidentList = incidentDao.findAll();
			request.setAttribute("IncidentList", IncidentList);
		//IncidentListの取得確認
			//System.out.println(IncidentList);
			request.getRequestDispatcher("/WEB-INF/view/ListIncident.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
