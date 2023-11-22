<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<select  name="Incident_id" id="formIncident_id">

<%--家でやる内容 --%>
<c:forEach items="${ServiceList }" var="ServiceManagment" varStatus="vs">
<option value="<c:out value="${serviceManagment.serviceId}"/>">
<c:out value="${serviceManagment.serviceId == ${vs.count} ? 'selected' : ''}"/> >
                <c:if test="${serviceManagment.serviceId eq incident.incident_id}"></c:if>
                <c:out value="${ServiceManagment.serviceName}" />
</option>
</c:forEach>
</select>

<div></div>
<label for="formIncident_Name">インシデント概要</label>
<input type="text" name="Incident_Name" id="formIncident_Name"
 value="<c:out value="${incident_name }"/>"/>
<div></div>

<label for="formIncident_Content">インシデント内容</label>
<input type="text" name="Incident_Content" id="formIncident_Content"
 value="<c:out value="${incident_content }"/>"/>
<div></div>

<label for="formgetStatus">ステータス</label>
<input type="text" name="getStatus" id="formgetStatus"
 value="<c:out value="${status}"/>"/>
<div></div>

</form>

</body>
</html>