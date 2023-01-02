<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Accesso effettuato con successo</h1>
	<jsp:useBean id="user1" scope="session" class="it.simpleservlet.bean.User"/>
	<label>Username : <jsp:getProperty name="user1" property="username"/>
	<br/>
	<br/>
	<label>Password : <jsp:getProperty name="user1" property="password"/>
	
</body>
</html>