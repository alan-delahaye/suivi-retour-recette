/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author adelahaye
 *
 */
public interface GenericDAO<T, PK extends Serializable> {

	/**
	 * persist
	 * 
	 * @param transientInstance objet to persist
	 */
	void persist(T transientInstance);

	/**
	 * refresh
	 * 
	 * @param instance objet to refresh
	 */
	void refresh(T instance);

	/**
	 * delete
	 * 
	 * @param persistentInstance objet to delete
	 */
	void delete(T persistentInstance);

	/**
	 * Remove a detached instance.
	 * 
	 * @param detachedInstance
	 * @param id
	 */
	void remove(PK id);

	/**
	 * merge
	 * 
	 * @param detachedInstance objet to merge
	 * @return merged object
	 */
	T merge(T detachedInstance);

	/**
	 * read
	 * 
	 * @param id of object to read
	 * @return read object
	 */
	T read(PK id);

	/**
	 * flush
	 */
	public void flush();

	/**
	 * Permet de tout lister
	 * 
	 * @return
	 */
	public List<T> listerTous();

	/**
	 * Permet de tronquer la table (vide tous les enregistrements) (Attention pas en cascade!)
	 * 
	 * @return le nombre d'enregistrements modifiés
	 */
	public long truncate();

	/**
	 * Permet de supprimer tous les enregistrements de la table
	 * 
	 * @return le nombre d'enregistrements modifiés
	 */
	public long deleteAll();

	/**
	 * Permet de compter l'ensemble des elements
	 * 
	 * @return le nombre d'enregistrements
	 */
	public long count();

	/**
	 * @return le type de classe utilisée
	 */
	public Class<T> getType();

	public EntityManager getEntityManager();
}