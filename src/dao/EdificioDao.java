package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Edificio;

public class EdificioDao {
	private static Session session;
	private Transaction tx;
	private static EdificioDao instancia = null;

	protected EdificioDao() {
	}

	public static EdificioDao getInstance() {
		if (instancia == null) {
			instancia = new EdificioDao();
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

	public Edificio traer(int id) {
		Edificio objeto = null;
		
		try {
			iniciarOperacion();
			objeto = (Edificio) session.createQuery("from Edificio e where e.idEdificio=" + id).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Edificio traerEdificioConAulas(int id) {
		Edificio objeto = null;
		
		try {
			iniciarOperacion();
			objeto = (Edificio) session.createQuery("from Edificio e where e.idEdificio=" + id).uniqueResult();
			Hibernate.initialize(objeto.getAulas());
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Edificio> traer() {
		List<Edificio> lista = null;
		
		try {
			iniciarOperacion();
			lista = session.createQuery("from Edificio").list();
		} finally {
			session.close();
		}
		
		return lista;
	}

}
