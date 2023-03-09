package br.com.value.projects.dominio;

public class Resultado {

	private Participante participante;
	private double metrica;

	public Resultado(Participante participante, double metrica) {
		this.participante = participante;
		setMetrica(metrica);

	}

	public Participante getParticipante() {
		return participante;
	}

	public double getMetrica() {
		return metrica;
	}

	public void setMetrica(double metrica) {
		this.metrica = metrica >= 0 ? metrica : 0;
	}

}
