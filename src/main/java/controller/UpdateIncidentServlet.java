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
			String Strid = request.getParameter("id");
			Integer id = Integer.parseInt(Strid);
		IncidentManagementDao incidentDao = DaoFactory.createIncidentDao();
		IncidentManagement incident = incidentDao.findById(id);
		

	
	
		
		//フォーム初期表示用データ
		request.setAttribute("incident_id",incident.getIncident_id());
		request.setAttribute("incident_name", incident.getIncident_Name());
		request.setAttribute("incident_content",incident.getIncident_Content());
		request.setAttribute("status",incident.getStatus());
		//インシデント作成者を呼び出す11/30
		request.setAttribute("supported_person_id",incident.getSupported_person_id());
		
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
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		//Getパラメータの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);


		//ログインしているユーザーの情報を取得したい11/30
//		Integer supported_person_id = Integer.parseInt(request.getParameter("supported_person_id"));
//			System.out.println(supported_person_id +"無限の剣製");
//		UserDao userDao = DaoFactory.createUserDao();
//		User user = userDao.findAll();
		
		//jspファイルのname属性を変更して修正(incident_id2)原因は不明おそらく、name属性の名前被りかも？
		String strincident_id = request.getParameter("incident_id2");
		//確認用System.out.println(strincident_id);
		Integer incident_id = Integer.parseInt(strincident_id);
		
		String incident_name = request.getParameter("Incident_Name");
		String incident_content = request.getParameter("Incident_Content");
		String status = request.getParameter("getStatus");
		
		
		request.setAttribute("incident_id", incident_id);
		request.setAttribute("incident_name",incident_name);
		request.setAttribute("incident_content",incident_content);
		request.setAttribute("status", status);
		
		IncidentManagement incidentManagement = new IncidentManagement();
		incidentManagement.setId(id);
		incidentManagement.setIncident_id(incident_id);
		incidentManagement.setIncident_Name(incident_name);
		incidentManagement.setIncident_Content(incident_content);
		incidentManagement.setStatus(status);
		
		try {
			//データの更新
		
		IncidentManagementDao incidentDao = DaoFactory.createIncidentDao();
		incidentDao.update(incidentManagement);
		
		//更新完了ページへ画面遷移
		request.getRequestDispatcher("/WEB-INF/view/UpdateIncidentDone.jsp").forward(request, response);
		
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
