package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteDaMatematicaMaluca {

	@Test
	public void contaAcimade30(){
		
		assertEquals(400, new MatematicaMaluca().contaMaluca(100));
		
	}
	
	@Test
	public void contaMaiorQue10EMenorQue30(){
		
		assertEquals(45, new MatematicaMaluca().contaMaluca(15));
		
	}
	
	@Test
	public void contaMaiorQue10(){
		
		assertEquals(6, new MatematicaMaluca().contaMaluca(3));
		
	}
}
