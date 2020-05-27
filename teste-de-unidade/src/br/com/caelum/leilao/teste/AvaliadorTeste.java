package br.com.caelum.leilao.teste;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Cliente;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class AvaliadorTeste {
	
	private Avaliador leiloeiro;
	private Cliente leonardo;
	private Cliente leticia;
	private Cliente luis;
	private Cliente ana;
	
	// método que cria cliente
	@Before
	public void criacliente() {
		this.leonardo = new Cliente("Leonardo");
		this.leticia = new Cliente("Leticia");
		this.luis = new Cliente("Luis");
		this.ana = new Cliente("Ana");
	}
	
	// método para criar avaliador
	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
	}
	
	@Test
	public void VerificaMaiorLance() {
		
		Leilao leilao = new CriadorDeLeilao().para("Computador")
				.lance(leonardo, 500.0)
				.lance(leticia, 550.0)
				.lance(luis, 551.0)
				.lance(ana, 552.0)
				.constroi();
		
//		Lance lanceLeonardo = new Lance(leonardo,500.0);
//		Lance lanceLeticia = new Lance(leticia,550.0);
//		Lance lanceLuis = new Lance(luis,551.0);
//		Lance lanceAna = new Lance(ana,552.0);
//		
//		Leilao leilao = new Leilao("Televisao");
//		
//		leilao.propoe(lanceLeonardo);
//		leilao.propoe(lanceLeticia);
//		leilao.propoe(lanceLuis);
//		leilao.propoe(lanceAna);
		
		Double maiorLance = 552.0;
		String clienteDeMaiorLance = "Ana";
		
		assertEquals(clienteDeMaiorLance,ana.getNome());
		assertEquals(maiorLance,leiloeiro.avaliaMaiorLance(leilao), 0.00001);	
	}
	
	@Test
	public void verificaMenorLance() {
				
		Leilao leilao = new CriadorDeLeilao().para("Computador")
				.lance(leonardo, 500.0)
				.lance(leticia, 550.0)
				.lance(luis, 551.0)
				.lance(ana, 552.0)
				.constroi();
			
		assertEquals("Leonardo",leonardo.getNome());
		assertEquals(500.0,leiloeiro.avaliaMenorLance(leilao), 0.00001);
	}
	
	@Test
	public void verificaLeilaoComApenasUmLAnce() {
		
		Leilao leilao = new CriadorDeLeilao().para("Computador")
				.lance(leonardo, 500.0)
				.constroi();
		
		assertEquals("Leonardo",leonardo.getNome());
		assertEquals(500.0,leiloeiro.avaliaMaiorLance(leilao), 0.00001);	
		//assertThat(leiloeiro.avaliaMaiorLance(leilao), equalTo(500.0));
		
		assertEquals("Leonardo",leonardo.getNome());
		assertEquals(500.0,leiloeiro.avaliaMenorLance(leilao), 0.00001);
	}
	
	@Test
	public void verificaOSTresMaioresLAnce() {
				
		Leilao leilao = new CriadorDeLeilao().para("Computador")
				.lance(leonardo, 500.0)
				.lance(leticia, 550.0)
				.lance(luis, 551.0)
				.lance(ana, 552.0)
				.constroi();
		
		List<Lance> maiores = leiloeiro.mostraOsTresMaioresLances(leilao);
		
		assertEquals(3,maiores.size());	
		
		assertEquals("Ana",maiores.get(0).getCliente().getNome());
		assertEquals(552.0,maiores.get(0).getValor(), 0.00001);	
		
		assertEquals("Luis",maiores.get(1).getCliente().getNome());
		assertEquals(551.0,maiores.get(1).getValor(), 0.00001);	
		
		assertEquals("Leticia",maiores.get(2).getCliente().getNome());
		assertEquals(550.0,maiores.get(2).getValor(), 0.00001);	
	}
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeilaoSemNenhumLanceDado() {
	
			Leilao leilao = new CriadorDeLeilao().para("Play Station 4").constroi();
			leiloeiro.avaliaMaiorLance(leilao);	
	}

}
