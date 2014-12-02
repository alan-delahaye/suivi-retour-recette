/**
 * 
 */
package fr.gfi.alan.delahaye.core.manager;

import java.util.List;

import fr.gfi.alan.delahaye.beans.UtilisateurBean;

/**
 * @author adelahaye
 *
 */
public interface AdministrationManager {

	List<UtilisateurBean> recupererTousLesUtilisateurs();
	
}
