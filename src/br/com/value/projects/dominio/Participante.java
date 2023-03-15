package br.com.value.projects.dominio;

public class Participante {

	private int id;
	private String nome;

	public Participante(String nome) {
		this.id = 0;
		setNome(nome);
	}

	public Participante(int id, String nome) {
		this.id = id;
		setNome(nome);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.length() > 15 ? nome.substring(0, 14) : nome;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
