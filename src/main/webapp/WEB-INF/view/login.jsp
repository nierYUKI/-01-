<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action="" method="post">
<h1>ログイン画面</h1>


<teble>
<tr>
	<td>
	<p>名前
	<input type="text" name="name">
	</p>
	</td>
	
	<p>パスワード
	<td>
	<input type="password" name="password">
	</p>
	</td>
</tr>

<input type="submit" value="ログイン">

</teble>




</form>

</body>
</html>