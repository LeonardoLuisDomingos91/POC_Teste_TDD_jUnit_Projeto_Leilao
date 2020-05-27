package br.com.caelum.leilao.dominio;

public class Cliente {

	private int id;
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
