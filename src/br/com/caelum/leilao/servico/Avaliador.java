package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	
	private double maiorDetodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double valorMedio = Double.NEGATIVE_INFINITY;
	private List<Lance> maiores;
	
	public void avalia(Leilao leilao) {
		
		if(leilao.getLances().size() == 0) {
			throw new RuntimeException("Não é possível avaliar um leilão em lances!");
		}
		
		double somaValores = 0.0;
		int contaLances = 0;
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDetodos) maiorDetodos = lance.getValor();
			if (lance.getValor() < menorDeTodos ) menorDeTodos = lance.getValor();
			
			somaValores +=lance.getValor();
			contaLances++;
		}
		
		maiores = new ArrayList<Lance>(leilao.getLances());
		
		Collections.sort(maiores, new Comparator<Lance>() {
			
			public int compare(Lance o1, Lance o2) {
				if(o1.getValor() < o2.getValor()) return 1;
				if(o1.getValor() > o2.getValor()) return -1;
				return 0;
			}
		});
		
		maiores = maiores.subList(0, maiores.size() > 3 ? 3: maiores.size());
		
		valorMedio = somaValores/contaLances;
	}
	
	public List<Lance> getTresMaiores() {
		return maiores;
	}
	
	public double getMaiorLance() { return maiorDetodos; }
	public double getMenorLance() {	return menorDeTodos; }
	public double getValorMedio() {	return valorMedio; }
}
