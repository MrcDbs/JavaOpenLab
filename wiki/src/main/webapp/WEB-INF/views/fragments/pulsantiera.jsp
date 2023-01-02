<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="post" action="pulsantiera.action" name="pulsantieraForm">
	<input type="hidden" name="titolo" value="${titolo}"/>
	<div class="btn-example">
		<input class="btn btn-primary" type="submit" name="principale" value="PRINCIPALE"/>
		<input class="btn btn-secondary" type="submit" name="tutte" value="TUTTE"/>
		<input class="btn btn-danger" type="submit" name="recenti" value="RECENTI"/>
		<input class="btn btn-warning" id="email" type="submit" name="email" value="EMAIL" disabled="true"/>
	</div>
</form>