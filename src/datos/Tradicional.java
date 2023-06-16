package datos;

public class Tradicional extends Aula {
	private int cantBancos;
	private String pizarron;
	private boolean tieneProyector;

	public Tradicional() {
	}

//	public Tradicional(int numero, Edificio edifcio, int cantBancos, String pizarron, boolean tieneProyector) {
//		this.cantBancos = cantBancos;
//		this.pizarron = pizarron;
//		this.tieneProyector = tieneProyector;
//	}

	/*------------------------------------------------------------------------------*/
	
	public int getCantBancos() {
		return cantBancos;
	}

	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}

	public String getPizarron() {
		return pizarron;
	}

	public void setPizarron(String pizarron) {
		this.pizarron = pizarron;
	}

	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	/*------------------------------------------------------------------------------*/
	
	@Override
	public String toString() {
		return "Tradicional [idAula=" + getIdAula() + ", numero=" + getNumero() + ", cantBancos=" + cantBancos + ", pizzaron="
				+ pizarron + ", tieneProyector=" + tieneProyector + "]";
	}
}
