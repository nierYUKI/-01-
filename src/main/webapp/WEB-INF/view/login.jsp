<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>ログイン画面</title>
</head>
<body>
<div class="main">
<form class="form1" action="" method="post">
<h1 class="sign" align="center">ログイン画面</h1>



<tr>
	<td>

	<input type="text" name="name" class="un"  placeholder="name">

	</td>
	

	<td>
	<input type="password" name="password" class="pass"  placeholder="Password">

	</td>
</tr>

<input type="submit" id="submit" value="ログイン" class="submit" >



<a href="userRegistration">アカウントが無い方は</a>


</form>
</div>
</body>
</html>