<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action="" method="post">

<p>名前
<input type="text" name="name">
</p>

<p>パスワード
<input type="text" name="password">
</p>

<p>所属部門
<input type="number" name="workId">
</p>

<p>
<input type="submit" value="登録">
</p>


</form>

</body>
</html>