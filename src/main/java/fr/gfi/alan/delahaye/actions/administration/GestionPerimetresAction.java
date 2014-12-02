/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;

/**
 * @author adelahaye
 *
 */
public class GestionPerimetresAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6804880981328767952L;

	private Logger logger = LogManager.getLogger(AdministrationAction.class);

	public String execute() throws Exception {
		super.init();
		logger.warn("Phase d'initialisation");
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		return SUCCESS;
	}
}
