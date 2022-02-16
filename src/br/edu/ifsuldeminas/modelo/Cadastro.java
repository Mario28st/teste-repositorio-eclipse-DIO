package br.edu.ifsuldeminas.modelo;

import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;

public abstract class Cadastro {

	private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private LocalDate dataNascimento;
	private String rg;
	private String telefone;
	
	
	public Cadastro(int id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, String rg,
			String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.telefone = telefone;
	}


	public Cadastro(String nome, String sobrenome, String cpf, LocalDate dataNascimento, String rg, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.telefone = telefone;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getData_nascimento() {
		java.sql.Date dataNascimentoSQL = Date.valueOf(dataNascimento);
		return dataNascimentoSQL;
	}


	public void setData_nascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "clientes [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf
			+ ", data_nascimento=" + dataNascimento + ", rg=" + rg + ", telefone="
				+ telefone + "]";
	}
	
}




