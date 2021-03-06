<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../general/header.jsp" />

	<a href="home">[Home]</a>
	<h1>Blacklist</h1>
	<hr />
	
	<form action="blacklistAdicionar" method="post">
		<input type="hidden" name="blacklist" value="1" />
		<input type="text" name="palavra" />
		<input type="submit" value="Gravar" />
	</form>
	
	<br />
	
	<table>
		<c:forEach var="palavra" items="${lista}" varStatus="id">
			<tr>
				<td>${palavra.palavra}</td>
				<td><a href="blacklistDeletar?idPalavra=${palavra.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>

<c:import url="../general/footer.jsp" />