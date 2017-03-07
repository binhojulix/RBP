package br.com.rbp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImagemDao {

	private Connection connection;

	public ImagemDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvar(byte bytes[]) {
		Connection c = this.connection;// busca uma conexao com o banco
		try {
			PreparedStatement ps = c.prepareStatement("INSERT INTO imgtable(image) VALUES (?)");

			ps.setBytes(1, bytes);
			ps.execute();
			ps.close();
			c.close();

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	public byte[] lerImagemDoBanco(int id) throws SQLException {
		Connection c = this.connection;// busca uma conexao com o banco
		String sql = "select *from imgtable where id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		byte[] bytes = null;
		while (resultSet.next()) {
			bytes = resultSet.getBytes("image");

		}
		resultSet.close();
		stmt.close();
		c.close();

		return bytes;
	}

}
