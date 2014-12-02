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
public class MonCompteAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3288305721954799955L;

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
