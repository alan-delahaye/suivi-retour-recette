package fr.gfi.alan.delahaye.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author adelahaye
 *
 */
public abstract class AbstractGenericDAO<T, PK extends Serializable> {

	/** type */
	private Class<T> type;

	/** the logger */
	private Logger LOG = LogManager
			.getLogger(AbstractGenericDAO.class);

	/**
	 * Constructor par défaut
	 * 
	 * @param t type POJO hibernate
	 */
	public AbstractGenericDAO(Class<T> t) {
		this.type = t;
	}

	public T read(final EntityManager entityManager, final PK id) {
		return entityManager.find(type, id);
	}

	protected void persist(final EntityManager entityManager, final T transientInstance) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Persisting instance of " + transientInstance.getClass().getSimpleName());
		}

		entityManager.persist(transientInstance);
	}

	public void refresh(final EntityManager entityManager, final T instance) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("refreshing instance of " + instance.getClass().getSimpleName());
		}
		entityManager.refresh(instance);
	}

	public void delete(final EntityManager entityManager, final T persistentInstance) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("deleting instance of " + persistentInstance.getClass().getSimpleName());
		}
		entityManager.remove(persistentInstance);
	}

	public void remove(final EntityManager entityManager, final PK id) {
		T attachedInstance = entityManager.find(type, id);
		if (attachedInstance != null) {
			entityManager.remove(attachedInstance);
		}
	}

	public T merge(final EntityManager entityManager, final T detachedInstance) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("merging instance of " + detachedInstance.getClass().getSimpleName());
		}
		return entityManager.merge(detachedInstance);

	}

	public void flush(final EntityManager entityManager) {
		entityManager.flush();
	}

	/**
	 * Permet de tous lister
	 * 
	 * @return
	 */
	@SuppressWarnings(value = "unchecked")
	public List<T> listerTous(final EntityManager entityManager) {
		return (List<T>) entityManager.createQuery("select t from " + type.getSimpleName() + " t").getResultList();
	}

	/**
	 * Permet de tronquer la table (vide tous les enregistrements) (Attention pas en cascade!)
	 * 
	 * @return le nombre d'enregistrements modifiés
	 */
	public long truncate(final EntityManager entityManager) {
		return entityManager.createQuery("truncate table " + type.getSimpleName()).executeUpdate();
	}

	/**
	 * Permet de supprimer tous les enregistrements de la table
	 * 
	 * @return le nombre d'enregistrements modifiés
	 */
	public long deleteAll(final EntityManager entityManager) {
		return entityManager.createQuery("delete from " + type.getSimpleName()).executeUpdate();
	}

	/**
	 * Permet de compter l'ensemble des elements
	 * 
	 * @return le nombre d'enregistrements
	 */
	public long count(final EntityManager entityManager) {
		return (Long) entityManager.createQuery("select count(*) from " + type.getSimpleName()).getSingleResult();
	}

	public Class<T> getType() {
		return type;
	}
	
	
}