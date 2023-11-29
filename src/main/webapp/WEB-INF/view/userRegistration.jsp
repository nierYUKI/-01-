<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>新規ユーザー登録</title>
</head>
<body>
<div class="main">
<h1 class="sign" align="center">ユーザー登録</h1>
<form action="" method="post">


<input type="text" name="name" class="un" placeholder="name">



<input type="text" name="password" class="pass" placeholder="password">


<select name="workId" id=""class="department" placeholder="所属部門">
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


</body>
</html>