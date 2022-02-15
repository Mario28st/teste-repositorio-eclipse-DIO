package br.edu.ifsuldeminas.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.cadastro.Cadastro;
import br.edu.ifsuldeminas.cadastro.Clientes;
import br.edu.ifsuldeminas.connection.ConnectFactory;
import br.edu.ifsuldeminas.dao.ClientesDao;
import br.edu.ifsuldeminas.dao.cadastro.ClientesDaoImpl;

public class ControllerClientes {
	
	private static ControllerClientes instance = null;
	
	List <Clientes>listClientes = new ArrayList<Clientes>();
	
	private ControllerClientes() {}
	
	public static ControllerClientes getInstance() {
		if (instance == null) {
			instance = new ControllerClientes();
		}
		return instance;
	}

	public boolean Add(Clientes novoCliente) {
	
		ClientesDao dao = new ClientesDaoImpl();
		boolean resposta = dao.saveClientes(novoCliente);
		return resposta;	
		//listClientes.add(novoCliente);
	}
	
	public List<Clientes> ListAll(){
		
		listClientes.clear();
		List<Clientes> listTemp = null;
		
			ClientesDaoImpl dao = new ClientesDaoImpl(); 
			listTemp = dao.getAllClientes();
			if(listTemp != null) {
				listClientes.addAll(listTemp);
				listTemp.clear();
			}
			
		return listClientes;
	}

	public Clientes getClientes(int id) {
		
		ClientesDao dao = new ClientesDaoImpl();
		Clientes resposta = dao.getClientes(id);
		return resposta;
		// TODO Auto-generated method stub
	}
	
	public boolean Update(Clientes cliente) {
		ClientesDaoImpl novoCliente = new ClientesDaoImpl();
		boolean resposta = novoCliente.updateClientes(cliente);
		return resposta;
	}
	
	public boolean Delete(Clientes cliente) {
		ClientesDaoImpl novoCliente = new ClientesDaoImpl();
		boolean resposta = novoCliente.deleteClientes(cliente);
		return resposta;
	}
}
