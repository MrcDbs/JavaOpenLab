
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<jsp:useBean id="persona" scope="request" type="it.esercizi.javaBean.Persona"/>
	
		<tr>
		<td>Nome</td><td><jsp:getProperty name="persona" property="nome"/></td>
		</tr>
		<tr>
		<td>Cognome</td><td><jsp:getProperty name="persona" property="cognome"/></td>
		</tr>
		<tr>
		<td>Codice Fiscale</td><td><jsp:getProperty name="persona" property="codiceFiscale"/></td>
		</tr>
		<tr>
		<td>Città</td><td><jsp:getProperty name="persona" property="città"/></td>
		</tr>
		<tr>
		<td>Username</td><td><jsp:getProperty name="persona" property="username"/></td>
		</tr>
		<tr>
		<td>Password</td><td><jsp:getProperty name="persona" property="password"/></td>
		</tr>
		<tr>
		<td>Genere</td><td><jsp:getProperty name="persona" property="genere"/></td>
		</tr>
	
	</table>
	
</body>
</html>