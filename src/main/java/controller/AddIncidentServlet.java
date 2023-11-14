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
 * Servlet implementation class AddIncidentServlet
 */
@WebServlet("/addIncident")
public class AddIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		IncidentManagementDao incidentDao = DaoFactory.createIncidentDao();
		List<IncidentManagement>IncidentList = incidentDao.findAll();
		request.setAttribute("IncidentList", IncidentList);
		request.getRequestDispatcher("/WEB-INF/view/addIncident.jsp").forward(request, response);
	}catch(Exception e) {
		throw new ServletException(e);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		//データの追加
		Integer Incident_id = Integer.parseInt(request.getParameter("id"));
		String Incident_Name = request.getParameter("name");
		String Incident_Content = request.getParameter("content");
		String getStatus = request.getParameter("status");
		
		IncidentManagement incidentManagement = IncidentManagement.builder()
				.InCId(Incident_id)
				.incident_Name(Incident_Name)
				.incident_Content(Incident_Content)
				.Status(getStatus)
				.build();
		
	}

}
