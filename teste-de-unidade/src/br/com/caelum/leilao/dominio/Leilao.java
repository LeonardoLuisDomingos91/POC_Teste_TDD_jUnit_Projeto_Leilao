package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		int contador = 0;
		for(Lance l: lances) {
			if(l.getCliente().equals(lance.getCliente())) contador ++;
		}
		
		if(lances.isEmpty() || !lances.get(lances.size()-1).getCliente().equals(lance.getCliente()) && contador < 5) {
			lances.add(lance);
		}
	}
	
	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return lances;
	}

	
	
}