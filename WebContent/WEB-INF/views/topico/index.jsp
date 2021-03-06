<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../general/header.jsp" />

	<a href="blacklistListar">[Blacklist]</a>
	<h1>F�rum</h1>
	<hr />
	
	<form action="topicoAdicionar" method="post">
		<input name="idPai" type="hidden" value="0" />
		<input name="pagina" type="hidden" value="${param['pagina']}" />
		<input name="nivel" type="hidden" value="0" />
		<textarea name="texto" rows="4" cols="50"></textarea>
		<br />
		<input type="submit" value="Enviar" />
	</form>
	<br /><br />

	<table>
	
		<c:forEach var="topico" items="${pagina.lista}" varStatus="id">
			<tr>
				<td><a href="topicoListar?t=${topico.id}">${topico.texto}</a></td>
			</tr>
		</c:forEach>

		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr>
			<td colspan="2">
				[
					<c:forEach var="numeroPagina" begin="1" end="${pagina.paginacao}">
						<a href="home?pagina=${numeroPagina}">${numeroPagina}</a> 
					</c:forEach>
				]
			</td>
		</tr>
	</table>
		
<c:import url="../general/footer.jsp" />