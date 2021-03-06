package br.com.forum.controller.topico;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.forum.dao.TopicoDAO;
import br.com.forum.model.Pagina;
import br.com.forum.service.TopicoService;

@WebServlet("/topicoListar")
public class RespostaPaginaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			TopicoDAO dao = new TopicoDAO(connection);
			
			Long topico = Long.valueOf(request.getParameter("t").equals("null") ? "1" : request.getParameter("t"));
			Long numeroPagina = Long.valueOf(request.getParameter("pagina") != null ? request.getParameter("pagina"): "1");
			
			TopicoService topicoService = new TopicoService(dao);
			Pagina pagina = topicoService.recuperaPaginaRespostas(topico, numeroPagina);
	
			request.setAttribute("pagina", pagina);
			request.getRequestDispatcher("WEB-INF/views/topico/topico.jsp").forward(request, response);
		} catch (NumberFormatException | SQLException e) {
		}

	}

}