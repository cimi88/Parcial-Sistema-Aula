package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaABM {
	private static AulaABM instancia = null;

	protected AulaABM() {}

	public static AulaABM getInstance() {
		if (instancia == null) {
			instancia = new AulaABM();
		}
		return instancia;
	}

	/*------------------------------------------------------------------------------*/
	
	public Aula traer(int id) {
		return AulaDao.getInstance().traer(id);
	}
}
