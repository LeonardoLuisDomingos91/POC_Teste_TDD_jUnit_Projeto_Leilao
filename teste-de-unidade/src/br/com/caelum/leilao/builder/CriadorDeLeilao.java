package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominio.Cliente;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class CriadorDeLeilao {
	
	private Leilao leilao;
	
	public CriadorDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Cliente cliente, Double valor) {
		leilao.propoe(new Lance(cliente,valor));
		return this;
	}
	
	public Leilao constroi() {
		return leilao;
	}
}
