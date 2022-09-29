package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Cliente cliente) {
		
		String sql = "insert into cliente (nome_cliente, cidade_cliente, cpf_cliente) values "
				+ "(?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, cliente.getNome());

			pstm.setString(2, cliente.getCidade());
			
			pstm.setString(3, cliente.getCpf());
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
	public List<Cliente> getCliente() {
		String sql = "select * from Cliente;";

		List<Cliente> clientes = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rset.getInt("id_cliente"));

				cliente.setNome(rset.getString("nome_cliente"));
				
				cliente.setCidade(rset.getString("cidade_cliente"));
				
				cliente.setCpf(rset.getString("cpf_cliente"));

				clientes.add(cliente);

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

		return clientes;
	}
	// Metodo pra atualizar

	public void update(Cliente cliente) {
		String sql = "UPDATE cliente set nome_cliente = ?, cidade_cliente = ?, cpf_cliente = ? where id_cliente = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());

			pstm.setString(2, cliente.getCidade());
			
			pstm.setString(3, cliente.getCpf());
			
			pstm.setInt(4, cliente.getId());

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
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

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

	public Cliente getClienteById(int id) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";

		Cliente cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			cliente.setId(rset.getInt("id_cliente"));

			cliente.setNome(rset.getString("nome_cliente"));
			
			cliente.setCidade(rset.getString("cidade_cliente"));
			
			cliente.setCpf(rset.getString("cpf_cliente"));
			

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

		return cliente;
	}
	
	public List<Cliente> getFiltro(String coluna, String busca) {
		
		String sql = "select * from cliente where " + coluna + " like '%" + busca + "%';";

		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			//pstm.setString(1, coluna);
			//pstm.setString(2, busca);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rset.getInt("id_cliente"));

				cliente.setNome(rset.getString("nome_cliente"));
				
				cliente.setCidade(rset.getString("cidade_cliente"));
				
				cliente.setCpf(rset.getString("cpf_cliente"));

				clientes.add(cliente);

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

		return clientes;
	}

}
