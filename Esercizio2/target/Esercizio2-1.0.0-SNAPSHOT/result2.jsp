<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="utente" scope="session" class="it.esercizio2.javabean.Utente"/>
	<label>Username : </label>
	<jsp:getProperty name="utente" property="username"/>
	<br/>
	<br/>
	<label>Password : </label>
	<jsp:getProperty name="utente" property="password"/>
</body>
</html>