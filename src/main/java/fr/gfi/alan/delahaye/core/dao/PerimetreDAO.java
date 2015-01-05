/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao;

import java.util.List;

import fr.gfi.alan.delahaye.core.entite.Perimetre;

/**
 * @author adelahaye
 *
 */
public interface PerimetreDAO extends GenericDAO<Perimetre, Long> {

	Perimetre getPerimetreByNomPerimetre(String nomPerimetre);
	
	List<Perimetre> recupererLesPerimetresActif();
}
