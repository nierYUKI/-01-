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
import domain.User;

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
		
		 //12/6追記 ログインしているユーザーの情報を取得（仮のセッション属性名として"loggedInUser"を使用）
    User loggedInUser = (User) request.getSession().getAttribute("user");
    System.out.println(loggedInUser+"APEX");
    //Integer loggedIn_User = Integer.parseInt(request.getParameter("loggedInUser"));
		
		//12/6追記 ログインしているユーザーとインシデント作成者が一緒じゃなければ更新出来ないようにする処理12/6
		//12/7追記「supported_person_id」が既にListIncident.jspファイルにて、「詳細・更新」を送る際に使用しているので、
    //supported_person_id2にしてインシデント作成者のID番号を渡してあげている処理
    //ListIncident.jspファイルの詳細・更新のリンクをクリックすると
    //&supported_person_id2=<c:out value="${IncidentManagement.supported_person_id}"/>の部分で
    //インシデント作成者のID番号を渡している
		Integer supported_person_id2 = Integer.parseInt(request.getParameter("supported_person_id2"));
		System.out.println(supported_person_id2+"衛宮さんちの今日のごはん");

		

		//フォーム初期表示用データ
		request.setAttribute("incident_id",incident.getIncident_id());
		request.setAttribute("incident_name", incident.getIncident_Name());
		request.setAttribute("incident_content",incident.getIncident_Content());
		request.setAttribute("status",incident.getStatus());
		
		//11/30追記 インシデント作成者名をupdateIncident.jspで表示する為
		//IncidentManagement incident = incidentDao.findById(id);でUserテーブルも取得しているメソッド「findById」があったので、
		request.setAttribute("user_name",incident.getUser_name());//再利用して、インシデント作成者の名前を取得している
		
		//12/6追記 インシデント作成者とログインしているユーザーが一緒じゃなかったら更新不可にする為、インシデント作成者のID番号を取得する為。
		request.setAttribute("supported_person_id", incident.getSupported_person_id());
		
		//12/5追記 インシデント作成時間も取得する
		request.setAttribute("Creation_Time",incident.getCreation_Time());
		
		//12/5追記 インシデント更新時間も取得する
		request.setAttribute("update_time", incident.getUpdate_time());
		
		request.setAttribute("ServiceList", ServiceList);
		if(loggedInUser.getId() == supported_person_id2 ) {
		request.getRequestDispatcher("/WEB-INF/view/updateIncident.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/view/updateIncident_view.jsp").forward(request, response);
		}
		
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
