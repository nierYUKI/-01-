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
import domain.IncidentManagement;

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
			
		IncidentManagementDao incidentDao = DaoFactory.createIncidentDao();
			List<IncidentManagement>IncidentList = incidentDao.findAll();
			request.setAttribute("IncidentList", IncidentList);
			//IncidentListの取得確認System.out.println(IncidentList);
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
