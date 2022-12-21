package br.com.agenda.model;

public class Contatos {
	private int idCliente;
	private String nome;
	private String cpf;
	
	//getters e setters
	public int getId() {
		return this.idCliente;
	}
	public void setId(int id) {
		this.idCliente = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}


