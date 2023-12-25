<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>インシデント管理一覧</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />

<link rel="stylesheet" href="css/style2.css">

</head>
<body>
<c:import url="parts/header.jsp" />
<div class="container mt-3">
<h1 class="taitle">インシデント一覧</h1>
  <div class="row">
    <div class="col-md-12">
	<%--<
<form method="post" action="ListIncident">
    <input type="search" name="incident_id" placeholder="インシデントシステム名">
    <input type="search" name="supported_person_id" placeholder="インシデント作成者名">
    <input type="submit" value="検索">
</form>
--%>

<table >
<tr>
	<%--<th>ID</th>--%>
	<th>インシデントシステム名</th>
	<th>インシデント概要</th>
	<%-- <th>インシデント対応</th> --%>
	<th>インシデント作成者</th>
	<th>インシデント作成時間</th>
	 <%--<th>インシデント更新時間</th> --%>
	<th>インシデントステータス</th>
	<th>データ操作</th>
</tr>
        <c:forEach items="${IncidentList}" var="IncidentManagement">
        <tr>
          <%--<td><c:out value="${IncidentManagement.id}" /></td>--%>
          
          <%-- IncidentManagementDaoImplでResultSetからIncidentManagementオブジェクトへの変換の注意 --%>
          <%-- domainで作成したクラスの変数の先頭文字が大文字でも、getter,setterで取得する際 --%>
          <%-- 小文字で取得されるので、JSPファイルで指定する際は小文字で指定してあげる --%>
          <%-- JavaBeansの命名規則 --%>
          
          <td><c:out value="${IncidentManagement.incidentId_Name}" /></td>
          <td><c:out value="${IncidentManagement.incident_Name}" /></td>
          <%-- <td><c:out value="${IncidentManagement.incident_Content}" /></td>--%>
          <td><c:out value="${IncidentManagement.user_name}" /></td>

          <td><fmt:formatDate value="${IncidentManagement.creation_Time}" pattern="y年MM月dd日 HH:mm:ss" /></td>
          <%-- <td><fmt:formatDate value="${IncidentManagement.update_time}" pattern="y年MM月dd日 HH:mm:ss" /></td> --%>
          <td><c:out value="${IncidentManagement.status}" /></td>
          
          <%-- 一覧の中から選択したインシデントIDの値、インシデント作成者の名前を取得する為、「supported_person_id」を渡して、名前を表示させている。--%>
          <%-- ログインしているユーザーとインシデント作成者が違う場合、更新処理を行わせない為「supported_person_id2」でインシデント作成者の番号を取得させている。 --%>
          <td><a class="update" href="updateIncident?id=<c:out value="${IncidentManagement.id}" />&supported_person_id=<c:out value="${IncidentManagement.user_name}"/>&supported_person_id2=<c:out value="${IncidentManagement.supported_person_id}"/>">詳細・更新</a></td>
       </tr>
        </c:forEach>
       
</table>
    </div>
  </div>
    </div>
<%-- ヘッダーでログアウト処理のボタンを表示させるのに必要だった。 --%>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>

</body>
</html>