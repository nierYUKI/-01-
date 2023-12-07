<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>インシデント編集</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/style3.css">
</head>
<c:import url="parts/header.jsp" />
<body>
	<h1 class="sign" align="center">インシデント編集</h1>

	<form action="" method="post">

<table>
<tr>
<th>インシデントシステム名</th>

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
		
		<td><select name="incident_id2" id="">
			<c:forEach items="${ServiceList }" var="ServiceManagment"
				varStatus="vs">
<option value="<c:out value="${ServiceManagment.serviceId}"/>" <c:out value="${ServiceManagment.serviceId == incident_id ? 'selected' : ''}"/>>
					<%-- <c:if test="${serviceManagment.serviceId eq incident.incident_id}"></c:if> --%>
					<c:out value="${ServiceManagment.serviceName}" />

				</option>
			</c:forEach>
</select></td>

<tr>
<th>インシデント概要</th>
<td><textarea name="Incident_Name" class="textarea" id="formIncident_Name" cols="30" rows="10">
<c:out value="${incident_name }"/>
</textarea></td>
</tr>

<tr>
<th>インシデント対応内容</th>
<td><textarea name="Incident_Content" class="textarea" id="formIncident_Content" cols="30" rows="10"><c:out value="${incident_content }"/></textarea></td>
</tr>

<tr>
<th>インシデント作成時間</th>
<td><fmt:formatDate  value="${Creation_Time}" pattern="y年MM月dd日 HH:mm:ss" /></td>
</tr>

<tr>
<th>インシデント更新時間</th>
<td><fmt:formatDate  value="${update_time}" pattern="y年MM月dd日 HH:mm:ss" /></td>
</tr>

<tr>
<th>ステータス</th>
<td><select name="getStatus" id="formgetStatus">

    <option value="受付" <c:if test="${status eq '受付'}">selected</c:if>>受付</option>
    <option value="対応中" <c:if test="${status eq '対応中'}">selected</c:if>>対応中</option>
    <option value="対応完了" <c:if test="${status eq '対応完了'}">selected</c:if>>対応完了</option>
    <option value="お客様対応待ち" <c:if test="${status eq 'お客様対応待ち'}">selected</c:if>>お客様対応待ち</option>

</select></td>
</tr>

<tr>
<th>インシデント作成者</th>
<td><label for="formsupported_person_id">${user_name}</label>
</tr>

<tr>
<th>インシデント内容変更</th>
<td><input type="submit" class="update" value="インシデントの内容を変更"></td>
</tr>
		
</table>
	</form>

<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>

</body>
</html>