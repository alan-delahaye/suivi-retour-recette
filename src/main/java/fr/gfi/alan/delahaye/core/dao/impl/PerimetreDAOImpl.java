/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import fr.gfi.alan.delahaye.core.dao.PerimetreDAO;
import fr.gfi.alan.delahaye.core.dao.UtilisateurDAO;
import fr.gfi.alan.delahaye.core.entite.Perimetre;
import fr.gfi.alan.delahaye.core.entite.Utilisateur;

/**
 * @author adelahaye
 *
 */
@Repository
public class PerimetreDAOImpl extends GenericDAOImpl<Perimetre, Long> implements
		PerimetreDAO {

	private Logger logger = LogManager
			.getLogger(PerimetreDAOImpl.class);
	
	/**
	 * Constructeur par défaut
	 */
	public PerimetreDAOImpl() {
		super(Perimetre.class);
	}
	
	@Override
	public Perimetre getPerimetreByNomPerimetre(String nomPerimetre) {
		try{
			Perimetre perimetre = (Perimetre) getEntityManager().createNamedQuery("Perimetre.getPerimetreByNomPerimetre").setParameter("nomPerimetre", nomPerimetre).getSingleResult();
			return perimetre;
		} catch (NoResultException noResultException){ 
			logger.warn(noResultException.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perimetre> recupererLesPerimetresActif() {
		try{
			List<Perimetre> perimetres = (List<Perimetre>) getEntityManager().createNamedQuery("Perimetre.getPerimetresActif").getResultList();
			return perimetres;
		} catch (NoResultException noResultException){ 
			logger.warn(noResultException.getMessage());
			return null;
		}
	}
}
