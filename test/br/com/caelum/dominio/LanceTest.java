package br.com.caelum.dominio;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class LanceTest {
	
	private Usuario joao;

	@Before
	public void setup() {
		joao = new Usuario("João");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarErroSeLanceMenorQue0(){
		
		new Lance(joao, -10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarErroSeLanceIgualA0(){
		
		new Lance(joao, 0);
	}
}
