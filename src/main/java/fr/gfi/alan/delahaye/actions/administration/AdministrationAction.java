/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;

/**
 * Action d'accès à l'accueil de l'administration
 * 
 * @author adelahaye
 *
 */
public class AdministrationAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3582437436766636542L;

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
