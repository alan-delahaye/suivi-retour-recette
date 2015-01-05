/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import fr.gfi.alan.delahaye.core.dao.EntreePerimetreDAO;
import fr.gfi.alan.delahaye.core.dao.PerimetreDAO;
import fr.gfi.alan.delahaye.core.dao.UtilisateurDAO;
import fr.gfi.alan.delahaye.core.entite.EntreePerimetre;
import fr.gfi.alan.delahaye.core.entite.Perimetre;
import fr.gfi.alan.delahaye.core.entite.Utilisateur;

/**
 * @author adelahaye
 *
 */
@Repository
public class EntreePerimetreDAOImpl extends
		GenericDAOImpl<EntreePerimetre, Long> implements EntreePerimetreDAO {

	private Logger logger = LogManager.getLogger(EntreePerimetreDAOImpl.class);

	/**
	 * Constructeur par défaut
	 */
	public EntreePerimetreDAOImpl() {
		super(EntreePerimetre.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntreePerimetre> recupereLesEntreeParPerimetre(long idPerimetre) {
		try {
			List<EntreePerimetre> entreePerimetres = (List<EntreePerimetre>) getEntityManager()
					.createNamedQuery(
							"EntreePerimetre.getLesEntreeParIdPerimetre")
					.setParameter("idPerimetre", idPerimetre).getResultList();
			return entreePerimetres;
		} catch (NoResultException noResultException) {
			logger.warn(noResultException.getMessage());
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public EntreePerimetre recupereLastEntreeParPerimetre(long idPerimetre) {
		try {
			EntreePerimetre entreePerimetre = (EntreePerimetre) getEntityManager()
					.createNamedQuery(
							"EntreePerimetre.getLastEntreeParIdPerimetre")
							.setParameter("idPerimetre", idPerimetre).setMaxResults(1).getSingleResult();
			return entreePerimetre;
		} catch (NoResultException noResultException) {
			logger.warn(noResultException.getMessage());
			return null;
		}
	}

}
