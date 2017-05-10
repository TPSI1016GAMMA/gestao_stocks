package model;

import java.time.LocalDate;

public abstract class Transaction {
	
	private int id;
	private Funcionario funcionario;
	private LocalDate date;
	private Estado estado;
	
	public Transaction(int id, Funcionario funcionario, LocalDate date, Estado estado) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.date = date;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
