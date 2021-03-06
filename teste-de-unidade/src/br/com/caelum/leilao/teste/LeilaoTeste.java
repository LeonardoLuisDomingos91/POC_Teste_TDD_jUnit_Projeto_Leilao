package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Cliente;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class LeilaoTeste {
	
	private Cliente messi;
	private Cliente cr7;
	
	@Before
	public void criarCliente() {
		this.messi = new Cliente("Messi");
		this.cr7 = new Cliente("Cr7");
	}
	
	@Test
	public void naoDeveAceitarLanceDoMesmoClienteDuasVezesSeguidas() {
		
		Leilao leilao = new CriadorDeLeilao().para("Carro")
				.lance(messi, 1000.0)
				.lance(messi, 2000.0)
				.constroi();
		
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(1000.0,leilao.getLances().get(0).getValor(),0.00001);
	}
	
	@Test
	public void naoDevePermitirClienteDarMaisDeCincoLancesNoMesmoLeilao() {
		
		Leilao leilao = new CriadorDeLeilao().para("Celular")
				.lance(messi, 1000.0)
				.lance(cr7, 1000.1)
				.lance(messi, 2000.0)
				.lance(cr7, 2000.1)
				.lance(messi, 3000.0)
				.lance(cr7, 3000.1)
				.lance(messi, 4000.0)
				.lance(cr7, 4000.1)
				.lance(messi, 5000.0)
				.lance(cr7, 5000.1)
				.lance(messi, 6000.0)
				.constroi();
		
//		Leilao leilao = new Leilao("Bola de ouro");
//		
//		Lance lance1Messi = new Lance(messi,1000.0);
//		
//		Lance lance1Cr7 = new Lance(cr7,1000.1);
//		
//		Lance lance2Messi = new Lance(messi,2000.0);
//		
//		Lance lance2Cr7 = new Lance(cr7,2000.1);
//		
//		Lance lance3Messi = new Lance(messi,3000.0);
//		
//		Lance lance3Cr7 = new Lance(cr7,3000.1);
//		
//		Lance lance4Messi = new Lance(messi,4000.0);
//		
//		Lance lance4Cr7 = new Lance(cr7,4000.1);
//		
//		Lance lance5Messi = new Lance(messi,5000.0);
//		
//		Lance lance5Cr7 = new Lance(cr7,5000.1);
//		
//		Lance lance6Messi = new Lance(messi,6000.0);
//		
//		leilao.propoe(lance1Messi);
//		
//		leilao.propoe(lance1Cr7);
//		
//		leilao.propoe(lance2Messi);
//		
//		leilao.propoe(lance2Cr7);
//		
//		leilao.propoe(lance3Messi);
//		
//		leilao.propoe(lance3Cr7);
//		
//		leilao.propoe(lance4Messi);
//		
//		leilao.propoe(lance4Cr7);
//		
//		leilao.propoe(lance5Messi);
//		
//		leilao.propoe(lance5Cr7);
//		
//		leilao.propoe(lance6Messi);
		
		Assert.assertEquals(10, leilao.getLances().size());
	}

}
