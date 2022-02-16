package br.edu.ifsuldeminas.dao.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.connection.ConnectFactory;
import br.edu.ifsuldeminas.dao.ClientesDao;
import br.edu.ifsuldeminas.modelo.Clientes;
import br.ifsuldeminas.edu.br.utils.Utils;

public class ClientesDaoImpl implements ClientesDao {

	

	@Override
	public boolean saveClientes(Clientes cliente) {

		Connection connection = null;
		boolean sucesso = true;
		
		try {
			connection = ConnectFactory.createConnection();
			
			/* preparar a instruÃ§Ã£o SQL */
			String query = "insert into clientes (nome,sobrenome,cpf,data_nascimento,salario, rg, telefone) values(?, ?, ?, ?, ?, ?,?)";

			/* preencher os dados na query */
			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, cliente.getNome());
			prepare.setString(2,  cliente.getSobrenome());
			prepare.setString(3, cliente.getCpf().replace(".", "").replace("-", ""));
			prepare.setDate(4, cliente.getData_nascimento());
			prepare.setDouble(5, cliente.getSalario());
			prepare.setString(6, cliente.getRg());
			prepare.setString(7, cliente.getTelefone());

			
			prepare.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return sucesso;
	}

	@Override
	public boolean deleteClientes(Clientes cliente) {
		Connection connection = null;
		boolean sucesso = true;
		
		try {
			connection = ConnectFactory.createConnection();
			
			/* preparar a instrução SQL */
			
			String query = "DELETE FROM clientes WHERE id = ?";

			/* preencher os dados na query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1, cliente.getId());
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return sucesso;	}

	@Override
	public boolean updateClientes(Clientes cliente) {
		Connection connection = null;
		boolean sucesso = true;
		
		try {
			connection = ConnectFactory.createConnection();
			
			/* preparar a instrução SQL */
			
			String query = "UPDATE clientes set nome=?, sobrenome=?,cpf=?, data_nascimento=?, salario=?, rg=?, telefone=? WHERE id = ?";

			/* preencher os dados na query */
			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, cliente.getNome());
			prepare.setString(2,  cliente.getSobrenome());
			prepare.setString(3, cliente.getCpf().replace(".", "").replace("-", ""));
			prepare.setDate(4, cliente.getData_nascimento());
			prepare.setDouble(5, cliente.getSalario());
			prepare.setString(6, cliente.getRg());
			prepare.setString(7, cliente.getTelefone());
			prepare.setInt(8, cliente.getId());

			prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return sucesso;
	}
	

	@Override
	public Clientes getClientes(int identificador) {
		Connection connection = null;
		Statement st = null;
		Clientes cliente = null;
	
		
		try {
			connection = ConnectFactory.createConnection();
			
			String query = "SELECT id, nome, sobrenome, cpf, data_nascimento, salario, rg, telefone FROM clientes WHERE id = " + identificador;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = Utils.formatarString("###.###.###-##", rs.getString("cpf"));
				Date dataNascimentoSQL = rs.getDate("data_nascimento");
				LocalDate dataNascimento = dataNascimentoSQL.toLocalDate();
				double salario = rs.getDouble("salario");
				String rg = rs.getString("rg");
				String telefone = rs.getString("telefone");

				cliente = new Clientes(id, nome,sobrenome,cpf,dataNascimento, rg, telefone, salario);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return cliente;
	
	}

	@Override
	public List<Clientes> getAllClientes() {
		List<Clientes> listClientes = new ArrayList<Clientes>();
		Connection connection = null;
		Statement st = null;
		
		try {
			connection = ConnectFactory.createConnection();
			
			String query = "SELECT id, nome, sobrenome, cpf, data_nascimento, salario, rg, telefone FROM clientes" ;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = Utils.formatarString("###.###.###-##", rs.getString("cpf"));
				Date dataNascimentoSQL = rs.getDate("data_nascimento");
				LocalDate dataNascimento = dataNascimentoSQL.toLocalDate();
				double salario = rs.getDouble("salario");
				String rg = rs.getString("rg");
				String telefone = rs.getString("telefone");
				
				listClientes.add(new Clientes (id, nome,sobrenome,cpf,dataNascimento, rg, telefone, salario));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return listClientes;
	}

}
