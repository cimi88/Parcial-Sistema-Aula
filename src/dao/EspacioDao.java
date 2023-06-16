package dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;
import datos.Espacio;

public class EspacioDao {
	private static Session session;
	private Transaction tx;
	private static EspacioDao instancia = null;

	protected EspacioDao() {
	}

	public static EspacioDao getInstance() {
		if (instancia == null) {
			instancia = new EspacioDao();
		}
		return instancia;
	}
	
	/*------------------------------------------------------------------------------*/
	
	protected void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	/*------------------------------------------------------------------------------*/
	
	public Espacio traer(LocalDate fecha, char turno, Aula aula) throws HibernateException{
		Espacio objeto = null;
		
		try {
			iniciarOperacion();
			objeto = (Espacio) session.createQuery("from Espacio e inner join fetch e.aula a where a.idAula=" + aula.getIdAula() +" and e.fecha='" + fecha + "' and e.turno='" + turno + "'").uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public int agregar(Espacio objeto) throws HibernateException {
		int id = 0;
		try {
			iniciarOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		
		return id;
	}
	
	
}
