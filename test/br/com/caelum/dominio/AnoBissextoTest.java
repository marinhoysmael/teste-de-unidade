package br.com.caelum.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.AnoBisexto;

public class AnoBissextoTest {

	@Test
	public void deveRetornarAnoBissexto() {
		
		AnoBisexto anoBisexto = new AnoBisexto();
		
		assertEquals(true, anoBisexto.ehBissexto(2016));
		assertEquals(true, anoBisexto.ehBissexto(2020));
	}
	
	@Test
	public void naoDeveRetornarAnoBissexto() {
		
		AnoBisexto anoBisexto = new AnoBisexto();
		
		assertEquals(false, anoBisexto.ehBissexto(2017));
		assertEquals(false, anoBisexto.ehBissexto(2018));
	}
}
