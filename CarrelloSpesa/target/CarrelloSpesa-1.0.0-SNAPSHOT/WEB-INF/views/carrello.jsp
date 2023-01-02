<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Log In autenticato, benvenuto nel carrello</h1>
	
	<form action="loginAuth" method="post">
		<h2>Seleziona gli item che desideri comprare</h2>
		<input type="checkbox" name="items" value="Pasta-3.7"/>Pasta - $3.7
		<br/>
		<input type="checkbox" name="items" value="Caffe-1.5"/>Caffe - $1.5
	    <br/>
		<input type="checkbox" name="items" value="Pane-2.0"/>Pane - $2.0
		<br/>
		<input type="checkbox" name="items" value="Latte-5.4"/>Latte - $5.4
	    <br/>
		<input type="checkbox" name="items" value="Uova-4.1"/>Uova	- $4.1
	    <br/><br/>
		
		<input type="hidden" name="richiesta" value="carrello"/>
		<input type="submit" value="Vai alla cassa"/>
	</form>
</body>
</html>