package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aluga;
import model.Carro;
import model.Cliente;

public class AlugaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	// Metodo pra salvar
	public void save(Aluga aluga) {
		
		String sql = "insert into aluga "
				+ "(data_retirada, data_devolucao, valor_aluguel, dias_aluguel, id_cliente, id_carro) values "
				+ "(?, ?, ?, ?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setDate(1, new Date(formatter.parse(aluga.getRetirada()).getTime()));

			pstm.setDate(2, new Date(formatter.parse(aluga.getDevolucao()).getTime()));
			
			pstm.setDouble(3, aluga.getValor_total());
			
			pstm.setLong(4, aluga.getDias());
			
			pstm.setInt(5, aluga.getCliente().getId());
			
			pstm.setInt(6, aluga.getCarro().getId());
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
	public List<Aluga> getAluga() {
		String sql = "select * from aluga_cliente_carro;";

		List<Aluga> alugueis = new ArrayList<Aluga>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Aluga aluga = new Aluga();
				Cliente cliente = new Cliente();
				Carro carro = new Carro();

				aluga.setId(rset.getInt("id_aluguel"));
				aluga.setRetirada(formatter.format(rset.getDate("data_retirada")));
				aluga.setDevolucao(formatter.format(rset.getDate("data_devolucao")));
				aluga.setValor_total(rset.getDouble("valor_aluguel"));
				aluga.setDias(rset.getInt("dias_aluguel"));
				
				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome_cliente"));
				cliente.setCidade(rset.getString("cidade_cliente"));
				cliente.setCpf(rset.getString("cpf_cliente"));
				aluga.setCliente(cliente);
				
				carro.setId(rset.getInt("id_carro"));
				carro.setModelo(rset.getString("modelo_carro"));
				carro.setPlaca(rset.getString("placa_carro"));
				carro.setValor(rset.getDouble("valor_aluguel_carro"));
				aluga.setCarro(carro);

				alugueis.add(aluga);

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

		return alugueis;
	}
	// Metodo pra atualizar

	public void update(Aluga aluga) {
		String sql = "UPDATE aluga set data_retirada = ?, data_devolucao = ?, "
				+ "valor_aluguel = ?, dias_aluguel = ?, id_cliente = ?, id_carro = ? "
				+ "where id_aluguel = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(formatter.parse(aluga.getRetirada()).getTime()));
			pstm.setDate(2, new Date(formatter.parse(aluga.getDevolucao()).getTime()));
			pstm.setDouble(3, aluga.getValor_total());
			pstm.setLong(4, aluga.getDias());
			pstm.setInt(5, aluga.getCliente().getId());
			pstm.setInt(6, aluga.getCarro().getId());
			
			pstm.setInt(7, aluga.getId());

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
		String sql = "DELETE FROM aluga WHERE id_aluguel = ?";

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

	public Aluga getAlugaById(int id) {
		String sql = "SELECT * FROM aluga WHERE id_aluguel = ?;";

		Aluga aluga = new Aluga();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			Cliente cliente = new Cliente();
			Carro carro = new Carro();

			aluga.setId(rset.getInt("id_aluguel"));
			aluga.setRetirada(formatter.format(rset.getDate("data_retirada")));
			aluga.setDevolucao(formatter.format(rset.getDate("data_devolucao")));
			aluga.setValor_total(rset.getDouble("valor_aluguel"));
			aluga.setDias(rset.getInt("dias_aluguel"));
			
			cliente.setId(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome_cliente"));
			cliente.setNome(rset.getString("cidade_cliente"));
			cliente.setNome(rset.getString("cpf_cliente"));
			aluga.setCliente(cliente);
			
			carro.setId(rset.getInt("id_carro"));
			carro.setId(rset.getInt("modelo_carro"));
			carro.setId(rset.getInt("placa_carro"));
			carro.setId(rset.getInt("valor_aluguel_carro"));
			aluga.setCarro(carro);

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

		return aluga;
	}

}
