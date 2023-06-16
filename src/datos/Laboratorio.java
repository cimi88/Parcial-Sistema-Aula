package datos;

public class Laboratorio extends Aula {
	private int cantPC;
	private int cantSillas;

	public Laboratorio() {
	}

//	public Laboratorio(int numero, Edificio edifcio, int cantPC, int cantSillas) {
//		this.cantPC = cantPC;
//		this.cantSillas = cantSillas;
//	}

	/*------------------------------------------------------------------------------*/
	
	public int getCantPC() {
		return cantPC;
	}

	public void setCantPC(int cantPC) {
		this.cantPC = cantPC;
	}

	public int getCantSillas() {
		return cantSillas;
	}

	public void setCantSillas(int cantSillas) {
		this.cantSillas = cantSillas;
	}

	/*------------------------------------------------------------------------------*/
	
	@Override
	public String toString() {
		return "Laboratorio [idAula=" + getIdAula() + ", numero=" + getNumero() + ", cantPC=" + cantPC + ", cantSillas=" + cantSillas + "]";
	}
}
