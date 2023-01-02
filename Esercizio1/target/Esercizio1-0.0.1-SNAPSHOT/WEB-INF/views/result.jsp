<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<table>
	
		<tr><td><b>Nome</b> </td><td><c:out value="${persona.nome}"></c:out></td></tr>
		<tr><td><b>Cognome</b> </td><td><c:out value="${persona.cognome}"></c:out></td></tr>
		<tr><td><b>Codice Fiscale</b> </td><td><c:out value="${persona.codiceFiscale}"></c:out></td></tr>
		<tr><td><b>Città di nascita</b> </td><td><c:out value="${persona.città}"></c:out></td></tr>
		<tr><td><b>Data di nascita</b> </td><td><c:out value="${persona.dataDiNascita}"></c:out></td></tr>
		<tr><td><b>Username</b> </td><td><c:out value="${persona.username}"></c:out></td></tr>
		<tr><td><b>Password</b> </td><td><c:out value="${persona.password}"></c:out></td></tr>
		<tr><td><b>Genere</b> </td><td><c:out value="${persona.genere}"></c:out></td></tr>
		<tr><td><b>Newletters</b></td><c:forEach var="news" items="${persona.newsletterList}"><td>${news}</td></c:forEach> 
	</table>
	
	<c:out value="${error}"></c:out>
</body>
</html>