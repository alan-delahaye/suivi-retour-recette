/**
 * 
 */
package fr.gfi.alan.delahaye.actions.perimetre;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.actions.administration.AdministrationAction;
import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;

/**
 * @author adelahaye
 *
 */
public class ChangerEtatPerimetreAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8869473766917398137L;

	private Logger logger = LogManager.getLogger(AdministrationAction.class);
	
	@Autowired
	private PerimetreManager perimetreManager;

	private long idPerimetre;
	
	public String execute() throws Exception {
		logger.warn(" ChangerEtatPerimetreAction >> " + idPerimetre);
		
		boolean retour = perimetreManager.mettreAJourEtatPerimetre(idPerimetre);
		if(!retour){
			throw new Exception("La mise à jour de l'état du périmètre est impossible.");
		}
		return SUCCESS;
	}

	/**
	 * @return the idPerimetre
	 */
	public long getIdPerimetre() {
		return idPerimetre;
	}

	/**
	 * @param idPerimetre the idPerimetre to set
	 */
	public void setIdPerimetre(long idPerimetre) {
		this.idPerimetre = idPerimetre;
	}

}
