package br.com.value.projects.dominio;

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
		this.metrica = metrica < 0 ? 0 : validarMetricaMaiorZero(metrica);
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	private double validarMetricaMaiorZero(double metrica) {
		return metrica > 1000 ? 1000 : metrica;
	}

}
