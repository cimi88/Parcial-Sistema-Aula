package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Espacio;

public class EspacioABM {
	private static EspacioABM instancia = null;

	protected EspacioABM() {
	}

	public static EspacioABM getInstance() {
		if (instancia == null) {
			instancia = new EspacioABM();
		}
		return instancia;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {
		if(traer(fecha, turno, aula) != null) {
			throw new Exception("Ya existe este espacio.\n");
		}
		return EspacioDao.getInstance().agregar(new Espacio(fecha, turno, aula, libre));
	}
	
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception {
		LocalDate inicio = LocalDate.of(anio, mes, 1);
		LocalDate fin = LocalDate.of(anio, mes, inicio.lengthOfMonth());
		
		while(!inicio.isEqual(fin.plusDays(1))) {
			agregar(inicio, 'M', aula, true);
			inicio = inicio.plusDays(1);
		}
	}
	
	/*------------------------------------------------------------------------------*/
	
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		return EspacioDao.getInstance().traer(fecha, turno, aula);
	}
	
}
