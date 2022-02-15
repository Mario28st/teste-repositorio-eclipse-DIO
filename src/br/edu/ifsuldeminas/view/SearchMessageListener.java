package br.edu.ifsuldeminas.view;

import java.util.List;

import br.edu.ifsuldeminas.cadastro.Clientes;

public interface SearchMessageListener {
	public List<Clientes> receiveList();
	public void sendIdentifier(int id);
}
