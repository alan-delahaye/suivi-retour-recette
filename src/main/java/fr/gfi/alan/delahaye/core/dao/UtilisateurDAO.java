/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao;

import fr.gfi.alan.delahaye.core.entite.Utilisateur;

/**
 * @author adelahaye
 *
 */
public interface UtilisateurDAO extends GenericDAO<Utilisateur, Long> {

	Utilisateur getUtilisateurByIdentifiant(String identifiant);
}
