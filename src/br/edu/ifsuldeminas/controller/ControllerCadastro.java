package br.edu.ifsuldeminas.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.modelo.Cadastro;
import br.edu.ifsuldeminas.modelo.Clientes;

public class ControllerCadastro {
	
	private static ControllerCadastro instance = null;
	
	List <Cadastro>listCadastro = new ArrayList<Cadastro>();
	
	private ControllerCadastro() {}
	
	public static ControllerCadastro getInstance() {
		if (instance == null) {
			instance = new ControllerCadastro();
		}
		return instance;
	}

	public void Add(Cadastro cadastro) {
		listCadastro.add(cadastro);
	}
	
	public List<Cadastro> ListAll(){
		return listCadastro;
	}
}
