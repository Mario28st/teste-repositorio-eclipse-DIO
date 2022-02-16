package br.edu.ifsuldeminas.modelo;

import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;


public class Clientes extends Cadastro {
	
	private double salario;
	
	//construtor
	public Clientes(int id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, String rg,
			String telefone, double salario) {
		super(id, nome, sobrenome, cpf, dataNascimento, rg, telefone);
		
		if (salario < 0.00)
			throw new IllegalArgumentException("Salario deve ser maior que 0.00 (zero)");
		this.salario = salario;
		// TODO Auto-generated constructor stub
	}

	public Clientes(String nome, String sobrenome, String cpf, LocalDate dataNascimento, String rg,
			String telefone, double salario) {
		super(nome, sobrenome, cpf, dataNascimento, rg, telefone);
		if (salario < 0.00)
			throw new IllegalArgumentException("Salario deve ser maior que 0.00 (zero)");
		this.salario = salario;
		
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return super.toString() + "clientes [salario=" + salario + "]";
	}




}
