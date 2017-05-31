package model;

import java.time.LocalDate;

public abstract class Transaction extends BD {
	
	private int id;
	private Employee employee;
	private LocalDate date;
	private State state;
	
	public Transaction(int id, Employee employee, LocalDate date, State state) {
		super();
		this.id = id;
		this.employee = employee;
		this.date = date;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getFuncionario() {
		return employee;
	}

	public void setFuncionario(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public State getEstado() {
		return state;
	}

	public void setEstado(State state) {
		this.state = state;
	}
	
	
}
