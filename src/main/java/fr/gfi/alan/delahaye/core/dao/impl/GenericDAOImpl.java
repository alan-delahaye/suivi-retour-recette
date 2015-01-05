/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.core.dao.GenericDAO;

/**
 * @author adelahaye
 *
 */
public class GenericDAOImpl<T, PK extends Serializable> extends AbstractGenericDAO<T, Serializable> implements GenericDAO<T, PK> {

	/** type */
	private Class<T> type;

	@PersistenceContext(unitName = "goreDB")
	private EntityManager entityManager;

	/** the logger */
	private Logger LOG = LogManager
			.getLogger(GenericDAOImpl.class);

	/**
	 * Constructor par défaut
	 * 
	 * @param t type POJO hibernate
	 */
	public GenericDAOImpl(Class<T> t) {
		super(t);
		this.type = t;
	}

	public T read(PK id) {
		return super.read(entityManager, id);
	}

	public void persist(T transientInstance) {
		persist(entityManager, transientInstance);
	}

	public void refresh(T instance) {
		super.refresh(entityManager, instance);
	}

	public void delete(T persistentInstance) {
		super.delete(entityManager, persistentInstance);
	}
	
	public void remove(PK id) {
		super.remove(entityManager, id);
	}

	public T merge(T detachedInstance) {
		return super.merge(entityManager, detachedInstance);
	}
	
	public void flush() {
		entityManager.flush();
	}
	
	/**
	 * Permet de tous lister
	 * 
	 * @return
	 */
	public List<T> listerTous() {
		return super.listerTous(entityManager);
	}
	
	/**
	 * Permet de tronquer la table (vide tous les enregistrements) (Attention pas en cascade!)
	 * 
	 * @return le nombre d'enregistrements modifiés
	 */
	public long truncate() {
		return super.truncate(entityManager);
	}
	
	/**
	 * Permet de supprimer tous les enregistrements de la table
	 * 
	 * @return le nombre d'enregistrements modifiés
	 */
	public long deleteAll() {
		return super.deleteAll(entityManager);
	}

	/**
	 * Permet de compter l'ensemble des elements
	 * 
	 * @return le nombre d'enregistrements
	 */
	public long count() {
		return super.count(entityManager);
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getType() {
		return type;
	}
	
	/**
	 * @return le logger
	 */
	public Logger getLOG(){
		return LOG;
	}	
}