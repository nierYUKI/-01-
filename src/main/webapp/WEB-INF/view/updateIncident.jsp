<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>インシデント編集</title>
</head>
<body>
	<h1>インシデント編集</h1>
	<form action="" method="post">

		<label for="formIncident_id">インシデントシステム名</label>
		<%-- <select name="incident_id2" id="formIncident_id">
			<option value="1" <c:out value="${incident_id == 1 ? 'selected' : ''}" />>
ネットワークエラー
</option>
<option value="2"
<c:out value="${incident_id == 2 ? 'selected' : ''}" />>
アプリケーションエラー

<option value="3"
<c:out value="${incident_id == 3 ? 'selected' : ''}" />>
サーバーエラー
</option>
<option value="4"
<c:out value="${incident_id == 4 ? 'selected' : ''}" />>
社内システムエラー

<option value="5"
<c:out value="${incident_id == 5 ? 'selected' : ''}" />>
オペレーションシステムエラー --%>

			<%--11月27日インシデント一覧で取得した「インシデントシステム名」の「incident_id」の
番号は取得出来たがそれに紐づくインシデントシステム名を取得する事ができなかった。
原因は「serviceManagment」が「ServiceManagment」にしていなかった為
<c:forEach items="${ServiceList }" var="ServiceManagment" varStatus="">
<option value="<c:out value="${serviceManagment.serviceId}"/>"
                <c:out value="${serviceManagment.serviceId == incident_id ? 'selected' : ''}" />>
                <c:out value="${incident_id}" />

<%--11月27日インシデントシステム名に紐づいている。「incident_id」からテーブル「servicemanagement」の「serviceName」を取得
			<c:forEach items="${ServiceList }" var="ServiceManagment"
				varStatus="vs">
<option value="<c:out value="${ServiceManagment.serviceId}"/>" <c:out value="${ServiceManagment.serviceId == incident_id ? 'selected' : ''}"/>> --%>
					<%-- <c:if test="${serviceManagment.serviceId eq incident.incident_id}"></c:if>
					<c:out value="${ServiceManagment.serviceName}" />

				</option>
			</c:forEach>
		</select> --%>
		
		<select name="incident_id2" id="">
			<c:forEach items="${ServiceList }" var="ServiceManagment"
				varStatus="vs">
<option value="<c:out value="${ServiceManagment.serviceId}"/>" <c:out value="${ServiceManagment.serviceId == incident_id ? 'selected' : ''}"/>>
					<%-- <c:if test="${serviceManagment.serviceId eq incident.incident_id}"></c:if> --%>
					<c:out value="${ServiceManagment.serviceName}" />

				</option>
			</c:forEach>
</select>

		<div></div>
		<label for="formIncident_Name">インシデント概要</label> <input type="text"
			name="Incident_Name" id="formIncident_Name"
			value="<c:out value="${incident_name }"/>" />
		<div></div>

		<label for="formIncident_Content">インシデント内容</label> <input type="text"
			name="Incident_Content" id="formIncident_Content"
			value="<c:out value="${incident_content }"/>" />
		<div></div>

		<label for="formgetStatus">ステータス</label> <input type="text"
			name="getStatus" id="formgetStatus"
			value="<c:out value="${status}"/>" />
		<div></div>
		

		<label for="formsupported_person_id">インシデント作成者</label> 
		<input type="text"
			name="supported_person_id" id="formsupported_person_id"
			value="<c:out value="${user.name}"/>" />



		<input type="submit" value="インシデントの内容を変更">

		<div></div>
		<a href="ListIncident">インシデント一覧へ戻る</a>

	</form>

</body>
</html>