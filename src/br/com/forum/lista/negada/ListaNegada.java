package br.com.forum.lista.negada;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.forum.dao.PalavraNegadaDAO;
import br.com.forum.model.PalavraNegada;

public class ListaNegada{

	private PalavraNegadaDAO palavraDAO;
	private ArrayList<PalavraNegada> listaPalavra;

	//L�gica de valida��o dos coment�rios contra a black list 
	public String verificaListaNegada(String texto, Connection connection) throws SQLException{
		
		palavraDAO = new PalavraNegadaDAO(connection);
		
		listaPalavra = palavraDAO.lista();
		
		for(int x=0; x<listaPalavra.size(); x++){
			//Verificar Possibilidades
			String regex = "(?i)" + listaPalavra.get(x).getPalavra().replace("a", "(a|@|�|�|�|�)").replace("i", "(i|1|�|�)").replace("o", "(o|0|�|�|�|�)").replace("s", "(s|&)");
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(texto);
            if(m.find())
            	texto = texto.replaceAll(m.group(), m.group().replaceAll(".", "x"));
		}
		return texto;
	}

}