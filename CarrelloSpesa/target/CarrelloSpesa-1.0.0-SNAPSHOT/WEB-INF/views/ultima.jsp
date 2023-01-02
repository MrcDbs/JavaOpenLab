<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label>Hai pagato : </label><c:out value="${tot}"/>
	<br/>
	<h2>La tua sessione è scaduta</h2>
</body>
</html>