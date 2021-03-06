package br.com.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.forum.dao.sql.Queries;
import br.com.forum.model.ItemBlackList;

public class BlackListDAO {

	private Connection connection;

	public BlackListDAO(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<ItemBlackList> lista() throws SQLException {
		try (PreparedStatement stmtLista = this.connection.prepareStatement(Queries.SELECT_BLACK_LIST); ResultSet rs = stmtLista.executeQuery()) {
			ArrayList<ItemBlackList> palavras = new ArrayList<ItemBlackList>();

			while (rs.next()) {
				ItemBlackList palavra = new ItemBlackList();
				palavra.setId(rs.getLong("id"));
				palavra.setPalavra(rs.getString("palavra"));
				palavras.add(palavra);
			}

			return palavras;
		}
	}

	public void adiciona(ItemBlackList item) throws SQLException {
		try (PreparedStatement stmtAdiciona = this.connection.prepareStatement(Queries.INSERT_BLACK_LIST)){
			stmtAdiciona.setString(1, item.getPalavra());
			stmtAdiciona.execute();
		} 
	}

	public void delete(long id) throws SQLException {
		try (PreparedStatement stmtDelete = connection.prepareStatement(Queries.DELETE_BLACK_LIST)){
			stmtDelete.setLong(1, id);
			stmtDelete.execute();
		}
	}

}