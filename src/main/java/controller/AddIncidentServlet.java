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
import domain.IncidentManagement;
import domain.ServiceManagment;

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

			//インシデントIDをサービス名で表示する処理
			ServiceManagmentDao serviceDao = DaoFactory.createServiceManagmentDao();
			List<ServiceManagment> ServiceList = serviceDao.findAll();
			request.setAttribute("ServiceList", ServiceList);
			//サービス名取得確認用System.out.println(ServiceList);

			//セッションからユーザー情報を取得
//			HttpSession session = request.getSession();
//			User user = (User) session.getAttribute("user");

//			if (user != null) {
				// ユーザー名がセッションに存在する場合の処理
//				response.getWriter().write("User Name: " + name);
//				request.setAttribute("name", name);
//				request.setAttribute("id", id);
//				System.out.println(id);
//			}

			request.getRequestDispatcher("/WEB-INF/view/addIncident.jsp").forward(request, response);
		} catch (Exception e) {
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
		//要注意jspファイルのname属性と同じにする
		Integer Incident_id = Integer.parseInt(request.getParameter("Incident_id"));//JSPファイルname属性と同じにする
		String Incident_Name = request.getParameter("Incident_Name");//JSPファイルname属性と同じにする
		String Incident_Content = request.getParameter("Incident_Content");//JSPファイルname属性と同じにする
		Integer supported_person_id = Integer.parseInt(request.getParameter("supported_person_id"));
		String getStatus = request.getParameter("getStatus");//JSPファイルname属性と同じにする

		IncidentManagement incidentManagement = IncidentManagement.builder()
				.incident_id(Incident_id)//インシデントID
				.incident_Name(Incident_Name)//インシデント名
				.incident_Content(Incident_Content)//インシデント内容
				.supported_person_id(supported_person_id)//インシデント登録者
				.status(getStatus)//ステータス
				.build();

		try {
			incidentManagement.setIncident_id(Incident_id);
			incidentManagement.setIncident_Name(Incident_Name);
			incidentManagement.setIncident_Content(Incident_Content);
			incidentManagement.setSupported_person_id(supported_person_id);
			incidentManagement.setStatus(getStatus);
			IncidentManagementDao incidentDao = DaoFactory.createIncidentDao();
			incidentDao.insert(incidentManagement);
			

			//DBに登録されるのを確認する為に、一覧にいく
			response.sendRedirect(request.getContextPath() + "/ListIncident");
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
}