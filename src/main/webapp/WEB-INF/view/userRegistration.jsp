<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<%-- ブラウザのCSSスタイルを初期化 --%>
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<link rel="stylesheet" href="css/style.css">
<title>新規ユーザー登録</title>
</head>
<body>
<div class="main">
<h1 class="sign" align="center">ユーザー登録</h1>
<form action="" method="post">


<input type="text" name="name" class="un" placeholder="例:山田太郎">
<%-- 名前のエラーメッセージ表示 --%>
<c:if test="${not empty errorName }">
<p class="error"><c:out value="${errorName }"/></p>
</c:if>


<input type="password" name="password" class="pass" placeholder="password">
<%-- パスワードのエラーメッセージ表示 --%>
<c:if test="${not empty errorPassword }">
<p class="error">${errorPassword }</p>
</c:if>


<select name="workId" id=""class="department" >
<c:forEach items="${WorkList }" var="WorkTable">
<option value="<c:out value="${ WorkTable.workId}"/>"><%-- domainで変数宣言した同じ文字列を使用すること(先頭文字の大文字小文字に気を付けてゲッターセッターで取得する際に小文字変換されるからJSPでは先頭文字を小文字にする) --%>
<c:out value="${WorkTable.workName}"/><%-- domainで変数宣言した同じ文字列を使用すること(先頭文字の大文字小文字に気を付けてゲッターセッターで取得する際に小文字変換されるからJSPでは先頭文字を小文字にする) --%>
</option>
</c:forEach>
</select>




<input type="submit" id="submit" value="登録" class="submit">


<a href="login">アカウントをお持ちの方は</a>
</form>
</div>

<script src="js/jquery-3.6.0.min.js"></script>

<script>

function 

</script>


</body>
</html>