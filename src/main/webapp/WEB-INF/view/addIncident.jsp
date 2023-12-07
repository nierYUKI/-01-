<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>インシデント登録</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style3.css" rel="stylesheet" />
</head>
<body>
<c:import url="parts/header.jsp" />



<h1 class="sign" align="center">インシデント登録</h1>

<form action="" method="post">
     
<table>
<tr>
<th>インシデントシステム名</th>


<td><select  name="Incident_id" id="formIncident_id" class="form-control">

<c:forEach items="${ServiceList }" var="ServiceManagment">
<option value="<c:out value="${ ServiceManagment.serviceId}"/>">
<c:out value="${ServiceManagment.serviceName }"/>
</option>
</c:forEach>

</select></td>

<tr>

<th>インシデント概要</th>
<td><textarea name="Incident_Name" class="textarea" placeholder="例:アプリが動かない&ネットに繋がらない等" id="formIncident_Name" cols="30" rows="10"></textarea></td>

</tr>

<tr>
<th>インシデント対応内容</th> 
<td><textarea name="Incident_Content" class="textarea" placeholder="例:アプリ再インストール&PC再起動等" id="formIncident_Content" cols="30" rows="10"></textarea></td> 

</tr>

<tr>
<th>ステータス</th>

<td><select name="getStatus" class="form-control" id="formgetStatus">

	<option value="受付">受付</option>
	<option value="対応中">対応中</option>
	<option value="対応完了">対応完了</option>
	<option value="お客様対応待ち">お客様対応待ち</option>

</select></td>
</tr>

<tr>
<th>インシデント作成者</th>
<td><label for="formsupported_person_id">${user.name}</label>
<input type="hidden" name="supported_person_id" id="formsupported_person_id" value="<c:out value="${user.id}"/>"></td>
</tr>
<tr>
<th>インシデント新規登録</th>
<td><input type="submit" class="incident" value="新規登録"></td></tr>
</table>

</form>


<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>

</body>
</html>