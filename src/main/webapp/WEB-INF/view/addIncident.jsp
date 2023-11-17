<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>インシデント登録</title>
</head>
<body>
<h1>インシデント登録</h1>
<form action="" method="post">

<label for="formIncident_id">インシデントID</label>
<select  name="Incident_id" id="formIncident_id">

<c:forEach items="${ServiceList }" var="ServiceManagment">
<option value="<c:out value="${ ServiceManagment.serviceId}"/>">
<c:out value="${ServiceManagment.serviceName }"/>
</option>
</c:forEach>

</select>
<div></div>
<label for="formIncident_Name">インシデント名</label>
<input type="text" name="Incident_Name" id="formIncident_Name">
<div></div>
<label for="formIncident_Content">インシデント内容</label>
<input type="text" name="Incident_Content" id="formIncident_Content">
<div></div>
<label for="formgetStatus">ステータス</label>
<input type="text" name="getStatus" id="formgetStatus">
<div></div>


<label for="formsupported_person_id">対応者</label>


<c:out value="${user.name}" />
<input type="hidden" name="supported_person_id" id="formsupported_person_id" value="<c:out value="${IncidentManagement.supported_person_id}"/>">
<input type="submit" value="新規登録">
</form>

<a href="logout">ログアウトする</a>

</body>
</html>