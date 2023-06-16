package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;

public class AulaDao {
	private static Session session;
	private Transaction tx;
	private static AulaDao instancia = null;

	protected AulaDao() {
	}

	public static AulaDao getInstance() {
		if (instancia == null) {
			instancia = new AulaDao();
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
	
	public Aula traer(int id) {
		Aula objeto = null;
		
		try {
			iniciarOperacion();
			objeto = (Aula) session.createQuery("from Aula e where e.idAula=" + id).uniqueResult();
			Hibernate.initialize(objeto.getEdificio());
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aula> traer(){
		List<Aula> lista = null;
		
		try {
			iniciarOperacion();
			lista = session.createQuery("from Aula").list();
		} finally {
			session.close();
		}
		
		return lista;
	}
	
	
}
