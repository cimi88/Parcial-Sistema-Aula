package negocio;

import java.util.List;

import dao.EdificioDao;
import datos.Edificio;

public class EdificioABM {
	private static EdificioABM instancia = null;
	
	protected EdificioABM() {}
	
	public static EdificioABM getInstance() {
		if(instancia == null) {
			instancia = new EdificioABM();
		}
		return instancia;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public Edificio traer(int id) {
		return EdificioDao.getInstance().traer(id);
	}
	
	public Edificio traerEdificioConAulas(int id) {
		return EdificioDao.getInstance().traerEdificioConAulas(id);
	}
	
	public List<Edificio> traer(){
		return EdificioDao.getInstance().traer();
	}
	
}
