<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<jsp:useBean id="carrello" scope="session" class="it.carrello.javabean.Carrello"/>
		<th><td> <b>Items nel carrello </b></td><td>(<b><jsp:getProperty property="itemsCount" name="carrello"/></b>)</td></th>
		<c:forEach var="item" items="${carrello.lista}">
		<tr>
			<td><c:out value="${item.descrizione}"/> - </td>
			<td> $ <c:out value="${item.prezzo}"/></td>
		</tr>
		</c:forEach>	
	</table>
	<br/>
	
	<label>TOT. </label><jsp:getProperty name="carrello" property="tot"/>
	<form action="loginAuth" method="post">
			<input type="hidden" name="richiesta" value="checkout"/>
		<input type="submit" value="Compra"/>
	</form>
</body>
</html>