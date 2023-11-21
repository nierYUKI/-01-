package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.IncidentManagementDao;
import dao.ServiceManagmentDao;
import domain.IncidentManagement;
import domain.ServiceManagment;

/**
 * Servlet implementation class UpdateIncidentServlet
 */
@WebServlet("/updateIncident")
public class UpdateIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<ServiceManagment>ServiceList;
	private IncidentManagementDao incidentDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServiceManagmentDao serviceManagmentDao = DaoFactory.createServiceManagmentDao();
		try {
			ServiceList = serviceManagmentDao.findAll();
			incidentDao = DaoFactory.createIncidentDao();
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		// IDを元に1件分のインシデントデータを取得
			//Getパラメータの取得
//			String strId = request.getParameter("id");
//			Integer id = Integer.parseInt(strId);
		IncidentManagementDao incidentDao = DaoFactory.createIncidentDao();
		IncidentManagement incident = incidentDao.findById(2);
		
		//フォーム初期表示用データ
		request.setAttribute("incident_id",incident.getIncident_id());
		request.setAttribute("incident_name", incident.getIncident_Name());
		request.setAttribute("incident_content",incident.getIncident_Content());
		request.setAttribute("status",incident.getStatus());
		
		request.setAttribute("ServiceList", ServiceList);
		
		request.getRequestDispatcher("/WEB-INF/view/updateIncident.jsp").forward(request, response);
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

}
