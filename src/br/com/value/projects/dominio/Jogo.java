package br.com.value.projects.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {

	private String descricao;
	private List<Resultado> resultados;

	public Jogo(String descricao) {
		this.descricao = descricao;
		this.resultados = new ArrayList<Resultado>();
	}

	public void anota(Resultado resultado) {
		if (resultados.isEmpty()
				|| !resultados.get(ultimoResultadoVisto()).getParticipante().equals(resultado.getParticipante())) {
			resultados.add(resultado);
		}

	}

	private int ultimoResultadoVisto() {
		return resultados.size() - 1;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Resultado> getResultados() {
		return Collections.unmodifiableList(resultados);
	}

	public double media() {
		if(resultados.size() == 0){
			// Em caso de jogos sem resultados, média retorna 0.
			return 0.0;
		}
		else{
			// Cálculo da média dos resultados dos jogos

			double soma = 0;

			for (Resultado resultado : resultados) {
				soma += resultado.getMetrica();
			}

			return soma/resultados.size();
		}
	}


}
