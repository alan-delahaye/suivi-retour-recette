/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao.impl;

import javax.persistence.NoResultException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import fr.gfi.alan.delahaye.core.dao.UtilisateurDAO;
import fr.gfi.alan.delahaye.core.entite.Utilisateur;

/**
 * @author adelahaye
 *
 */
@Repository
public class UtilisateurDAOImpl extends GenericDAOImpl<Utilisateur, Long> implements
		UtilisateurDAO {

	private Logger logger = LogManager
			.getLogger(UtilisateurDAOImpl.class);
	
	/**
	 * Constructeur par défaut
	 */
	public UtilisateurDAOImpl() {
		super(Utilisateur.class);
	}
	
	@Override
	public Utilisateur getUtilisateurByIdentifiant(String identifiant) {
		try{
			Utilisateur utilisateur = (Utilisateur) getEntityManager().createNamedQuery("Utilisateur.getUtilisateurByIdentifiant").setParameter("identifiant", identifiant).getSingleResult();
			return utilisateur;
		} catch (NoResultException noResultException){ 
			logger.warn(noResultException.getMessage());
			return null;
		}
	}
}
