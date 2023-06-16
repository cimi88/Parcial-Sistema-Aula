package test;

import java.time.LocalDate;
import java.util.logging.Level;

import datos.*;
import negocio.AulaABM;
import negocio.EdificioABM;
import negocio.EspacioABM;

public class Test {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		Edificio edificio = EdificioABM.getInstance().traerEdificioConAulas(1);
		System.out.println(edificio + ", Aulas:");
		mostrarAulas(edificio);
		
		Aula aula = AulaABM.getInstance().traer(3);
		System.out.println("\n" + aula + " se encuentra en " + aula.getEdificio());
		
		Espacio espacio = EspacioABM.getInstance().traer(LocalDate.of(2022, 05, 01), 'M', aula);
		System.out.println("\n" + espacio + "\n");
		
		try {
			EspacioABM.getInstance().agregar(LocalDate.of(2022, 05, 01), 'M', aula, true);
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		try {
			EspacioABM.getInstance().agregarEspacioMes(5, 2022, 'M', aula);
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	public static void mostrarAulas(Edificio e) {
		for(Aula a: e.getAulas()) {
			System.out.println(a.toString());
		}
	}
}
