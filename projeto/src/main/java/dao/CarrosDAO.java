package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Carro;

public class CarrosDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Carro carro) {
		
		String sql = "insert into carro (modelo_carro, placa_carro, valor_aluguel_carro) values "
				+ "(?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, carro.getModelo());

			pstm.setString(2, carro.getPlaca());
			
			pstm.setDouble(3, carro.getValor());
			// Executar a sql para inserção dos dados
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

	// Metodo para Ler
	public List<Carro> getCarros() {
		String sql = "select * from Carro;";

		List<Carro> carros = new ArrayList<Carro>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Carro carro = new Carro();

				carro.setId(rset.getInt("id_carro"));

				carro.setModelo(rset.getString("modelo_carro"));
				
				carro.setPlaca(rset.getString("placa_carro"));
				
				carro.setValor(rset.getDouble("valor_aluguel_carro"));

				carros.add(carro);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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

		return carros;
	}
	// Metodo pra atualizar

	public void update(Carro carro) {
		String sql = "UPDATE carro set modelo_carro = ?, placa_carro = ?, valor_aluguel_carro = ? where id_carro = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, carro.getModelo());

			pstm.setString(2, carro.getPlaca());
			
			pstm.setDouble(3, carro.getValor());
			
			pstm.setInt(4, carro.getId());

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

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM carro WHERE id_carro = ?";

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

	public Carro getCarroById(int id) {
		String sql = "SELECT * FROM carro WHERE id_carro = ?;";

		Carro carro = new Carro();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			carro.setId(rset.getInt("id_carro"));

			carro.setModelo(rset.getString("modelo_carro"));
			
			carro.setPlaca(rset.getString("placa_carro"));
			
			carro.setValor(rset.getDouble("valor_aluguel_carro"));	

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

		return carro;
	}

}
