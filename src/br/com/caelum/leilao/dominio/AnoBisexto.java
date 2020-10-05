package br.com.caelum.leilao.dominio;

public class AnoBisexto {

	public boolean ehBissexto(int ano) {
		
		if( (ano % 4 == 0) && (ano % 100 != 0)) return true;
		else if(ano % 400 == 0) return true;
		else return false;
	}
}
