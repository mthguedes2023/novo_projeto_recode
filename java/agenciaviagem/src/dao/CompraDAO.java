package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Compras;
import modelos.Pacotes;

public class CompraDAO {

	// create
		public void create(Compras compra) {

			String sql = "insert into Compras (data_compra, opcao_pagamento, total_compra, id_pacote) values (?, ?, ?, ?)";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, compra.getData_compra());
				pstm.setString(2, compra.getOpcao_pagamento());
				pstm.setFloat(3, compra.getTotal_compra());
				pstm.setInt(4, compra.getPacote().getId());

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
		public List<Compras> read() {
			List<Compras> compras = new ArrayList<Compras>();
			String sql = "select * from compras order by id_compra";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {
					Compras compra = new Compras();
					PacoteDAO pacoteDAO = new PacoteDAO();
					Pacotes pacote = pacoteDAO.readById(rset.getInt("id_pacote"));

					compra.setId(rset.getInt("id_compra"));
					compra.setData_compra(rset.getString("data_compra"));
					compra.setOpcao_pagamento(rset.getString("opcao_pagamento"));
					compra.setTotal_compra(rset.getFloat("total_compra"));

					compra.setPacote(pacote);

					compras.add(compra);
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

			return compras;
		}
		
		// update
		public void update(Compras compra) {
			String sql = "UPDATE Compras SET data_compra = ?, opcao_pagamento = ?, total_compra = ?, id_pacote = ? WHERE id_compra = ?";
			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, compra.getData_compra());
				pstm.setString(2, compra.getOpcao_pagamento());
				pstm.setFloat(3, compra.getTotal_compra());
				pstm.setInt(4, compra.getPacote().getId());
				pstm.setInt(5, compra.getId());

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
		
		// delete
		public void delete(int id) {
			String sql = "DELETE FROM Compras WHERE id_compra = ?";

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
		
		// readById
		public Compras readById(int id) {
			Compras compra = new Compras();
			String sql = "select * from compras WHERE id_compra = ?";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();

				rset.next();
				PacoteDAO pacoteDAO = new PacoteDAO();

				Pacotes pacote = pacoteDAO.readById(rset.getInt("id_pacote"));
				
				compra.setId(rset.getInt("id_compra"));
				compra.setData_compra(rset.getString("data_compra"));
				compra.setOpcao_pagamento(rset.getString("opcao_pagamento"));
				compra.setTotal_compra(rset.getFloat("total_compra"));

				compra.setPacote(pacote);
	
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
			return compra;
		}
		
		
}
