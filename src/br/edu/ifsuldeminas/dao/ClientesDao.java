package br.edu.ifsuldeminas.dao;

import java.util.List;

import br.edu.ifsuldeminas.cadastro.Clientes;

public interface ClientesDao {
	
	public boolean saveClientes(Clientes cliente) ;
	public boolean deleteClientes (Clientes cliente);
	public boolean updateClientes (Clientes cliente);
	public Clientes getClientes(int id);
	public List<Clientes> getAllClientes();

}
