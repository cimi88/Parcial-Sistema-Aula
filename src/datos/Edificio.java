package datos;

import java.util.Set;

public class Edificio {
	private int idEdificio;
	private String edificio;
	private Set<Aula> aulas;

	public Edificio() {
	}

	public Edificio(String edificio, Set<Aula> aulas) {
		this.edificio = edificio;
		this.aulas = aulas;
	}

	/*------------------------------------------------------------------------------*/

	public int getidEdificio() {
		return idEdificio;
	}

	protected void setidEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	/*------------------------------------------------------------------------------*/

	@Override
	public String toString() {
		return "Edificio [idEdificio=" + idEdificio + ", edificio=" + edificio + "]";
	}

}
