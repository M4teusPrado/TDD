package br.com.value.projects.dominio;

import javax.swing.text.Element;

public class Resultado {

	private Participante participante;
	private double metrica;

	public Resultado(Participante participante, double metrica) {
		setParticipante(participante);
		setMetrica(metrica);

	}

	public Participante getParticipante() {
		return participante;
	}

	public double getMetrica() {
		return metrica;
	}

	public void setMetrica(double metrica) {
		this.metrica = metrica < 0 ? 0 : validarMetrica(metrica);
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	private double validarMetrica(double metrica) {
		if (metrica > 1000)
		{
			metrica = 1000;
		}
		else if (metrica % 1 != 0){
			metrica = 0;
		}
		
		return metrica;
	}

}
