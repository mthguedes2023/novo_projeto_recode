package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Pacotes;

public class PacoteDAO {
	// create
		public void create(Pacotes pacote) {

			String sql = "insert into pacotes (preco_pacote, nome_pacote, quantidade_pacote) values (?, ?, ?)";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setFloat(1, pacote.getPreco());
				pstm.setString(2, pacote.getNome());
				pstm.setInt(3, pacote.getQtd());

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		// read
		public List<Pacotes> read() {
			List<Pacotes> pacotes = new ArrayList<>();
			String sql = "select * from pacotes";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {
					Pacotes pacote = new Pacotes();

					pacote.setId(rset.getInt("id_pacote"));
					pacote.setPreco(rset.getFloat("preco_pacote"));
					pacote.setNome(rset.getString("nome_pacote"));
					pacote.setQtd(rset.getInt("quantidade_pacote"));

					pacotes.add(pacote);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return pacotes;
		}
		
		// update
		public void update(Pacotes pacote) {
			String sql = "UPDATE pacotes SET preco_pacote = ?, nome_pacote = ?, quantidade_pacote = ? WHERE id_pacote = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setFloat(1, pacote.getPreco());
				pstm.setString(2, pacote.getNome());
				pstm.setInt(3, pacote.getQtd());
				pstm.setDouble(4, pacote.getId());

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		
		// readById
		public Pacotes readById(int id) {
			Pacotes pacote = new Pacotes();
			String sql = "select * from pacotes WHERE id_pacote = ?";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				pacote.setId(rset.getInt("id_pacote"));
				pacote.setPreco(rset.getFloat("preco_pacote"));
				pacote.setNome(rset.getString("nome_pacote"));
				pacote.setQtd(rset.getInt("quantidade_pacote"));
				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return pacote;
		}

		// delete
		public void delete(int id) {
			String sql = "DELETE FROM pacotes WHERE id_pacote = ?";
		
			Connection conn = null;
			PreparedStatement pstm = null;
		
			try {
		
				conn = ConnectionMySQL.createConnectionMySQL();
		
				pstm = conn.prepareStatement(sql);
		
				pstm.setInt(1, id);
		
				pstm.execute();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		}
		
		
		
		
}
