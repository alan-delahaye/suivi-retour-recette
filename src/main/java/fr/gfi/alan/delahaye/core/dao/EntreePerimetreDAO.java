/**
 * 
 */
package fr.gfi.alan.delahaye.core.dao;

import java.util.List;

import fr.gfi.alan.delahaye.core.entite.EntreePerimetre;

/**
 * @author adelahaye
 *
 */
public interface EntreePerimetreDAO extends GenericDAO<EntreePerimetre, Long> {

	List<EntreePerimetre> recupereLesEntreeParPerimetre(long idPerimetre);

	EntreePerimetre recupereLastEntreeParPerimetre(long idPerimetre);
}
