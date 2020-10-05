package br.com.caelum.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {
	

	@BeforeClass
	public static void testandoBeforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public static void testandoAffterClass() {
		System.out.println("affter class");
	}

	@Test
	public void deveReceberUmLance(){
		
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		
		assertEquals(1, leilao.getLances().size());
		
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));
		
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.00001);
		
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario stevJobs = new Usuario("Steve Jobs");
		
		leilao.propoe(new Lance(stevJobs, 2000));
		leilao.propoe(new Lance(stevJobs, 3000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario stevJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");
		
		leilao.propoe(new Lance(stevJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));
		
		leilao.propoe(new Lance(stevJobs, 4000));
		leilao.propoe(new Lance(billGates, 5000));
		
		leilao.propoe(new Lance(stevJobs, 6000));
		leilao.propoe(new Lance(billGates, 7000));
		
		leilao.propoe(new Lance(stevJobs, 8000));
		leilao.propoe(new Lance(billGates, 9000));
		
		leilao.propoe(new Lance(stevJobs, 10000));
		leilao.propoe(new Lance(billGates, 11000));
		
		// deve ser ignorado
		
		leilao.propoe(new Lance(stevJobs, 12000));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size() -1 ).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveDobrarOUltimoLanceDado() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario stevJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");
		
		leilao.propoe(new Lance(stevJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));
		
		leilao.dobraLance(stevJobs);
		
		assertEquals(4000.0, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario stevJobs = new Usuario("Steve Jobs");
		
		leilao.dobraLance(stevJobs);
		
		assertEquals(0, leilao.getLances().size());
	}
}
