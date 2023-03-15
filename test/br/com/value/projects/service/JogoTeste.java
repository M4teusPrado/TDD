package br.com.value.projects.service;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import br.com.value.projects.builder.CriadorDeJogo;
import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.dominio.Participante;
import br.com.value.projects.dominio.Resultado;

public class JogoTeste {
	
		
	@Test
	public void deveTerJogoComUnicoParticipante() {
		Jogo jogo = new Jogo("Jogo de corrida");
		assertEquals(0, jogo.getResultados().size());

		jogo.anota(new Resultado(new Participante("Leonardo"), 150));

		assertEquals(1, jogo.getResultados().size());

		assertEquals(150.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}
	
	

	@Test
	public void deveTerVariosResultados() {
		Jogo jogo = new CriadorDeJogo()
        .para("Cata moedas")
        .resultado(new Participante("Nelson"), 150.0)
        .resultado(new Participante("Pedro"), 200.0)
        .constroi();

		assertEquals(2, jogo.getResultados().size());
		assertEquals(150.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
		assertEquals(200.0, jogo.getResultados().get(1).getMetrica(), 0.00001);
		
	}
	
	@Test
	public void naoDeveAceitarDoisResultadosDoMesmoParticipante(){

		Jogo jogo = new Jogo("Ca�a pe�as");
		Participante leonardo = new Participante("Leonardo");

		jogo.anota(new Resultado(leonardo, 500.0));
		jogo.anota(new Resultado(leonardo, 600.0));

		assertEquals(1, jogo.getResultados().size());
        assertEquals(500, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}
	
	@Test
	public void deveAceitarResultadoQuandoListaEstiverVazia() {
		
		Jogo jogo = new Jogo("Quebra cabeça");
		Participante mateus = new Participante("Mateus");
		
		jogo.anota(new Resultado(mateus, 100));
		
		assertEquals(1, jogo.getResultados().size());
	}

	@Test
	public void naoDeveAceitarValoresNegativos() {
		
		Jogo jogo = new Jogo("Quebra cabeça");
		Participante mateus = new Participante("Mateus");
		
		jogo.anota(new Resultado(mateus, -100));
		
		assertEquals(0.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}

	
	@Test
	public void naoDeveAceitarValoresMaioresMil() {
		
		Jogo jogo = new Jogo("Quebra cabeça");
		Participante mateus = new Participante("Mateus");
		
		jogo.anota(new Resultado(mateus, 2000));
		
		assertEquals(1000, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}

	@Test
	public void naoDeveAceitarValoresNaoInteiros() {
		
		Jogo jogo = new Jogo("Quebra cabeça");
		Participante leonardo = new Participante("Leonardo");
		
		jogo.anota(new Resultado(leonardo, 650.50));
		
		assertEquals(0, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}


	@Test
	public void naoDeveTerNomesMaioresQueQuinzeCaracteres() {
		
		Jogo jogo = new Jogo("Futebol de Botao");
		Participante rodrigo = new Participante("Rodrigo Abdalla Ramos da Silva");
		
		jogo.anota(new Resultado(rodrigo, 1000));
		
		assertEquals("Rodrigo Abdall", jogo.getResultados().get(0).getParticipante().getNome());
	}

}