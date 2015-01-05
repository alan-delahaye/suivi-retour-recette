/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;

/**
 * @author adelahaye
 *
 */
public class AjouterPerimetreAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 138791931037255452L;

	private Logger logger = LogManager
			.getLogger(AjouterPerimetreAction.class);

	private PerimetreBean perimetre;
	
	private int idPerimetre;
	
	@Autowired
	private AdministrationManager administrationManager;
	
	public String execute() throws Exception {
		super.init();
		super.retrieveActionErrorToSession();
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		if(idPerimetre > 0){
			perimetre = administrationManager.recupererPerimetreParId(idPerimetre);
		}
		return SUCCESS;
	}

	/**
	 * @return the perimetre
	 */
	public PerimetreBean getPerimetre() {
		return perimetre;
	}

	/**
	 * @param perimetre the perimetre to set
	 */
	public void setPerimetre(PerimetreBean perimetre) {
		this.perimetre = perimetre;
	}

	/**
	 * @return the idPerimetre
	 */
	public int getIdPerimetre() {
		return idPerimetre;
	}

	/**
	 * @param idPerimetre the idPerimetre to set
	 */
	public void setIdPerimetre(int idPerimetre) {
		this.idPerimetre = idPerimetre;
	}
}
