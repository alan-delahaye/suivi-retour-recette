/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import java.util.List;

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
public class GestionPerimetresAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6804880981328767952L;

	private Logger logger = LogManager.getLogger(AdministrationAction.class);

	private List<PerimetreBean> listePerimetres; 
	
	private long idPerimetre;
	
	@Autowired
	private AdministrationManager administrationManager;
	
	public String execute() throws Exception {
		super.init();
		logger.warn("Phase d'initialisation");
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		listePerimetres = administrationManager.recupererTousLesPerimetres();
		return SUCCESS;
	}

	public String supprimerPerimetre() throws Exception {
		administrationManager.supprimerPerimetre(idPerimetre);
        return SUCCESS;
    }
	
	public String demarrerPerimetre() throws Exception {
		administrationManager.demarrerPerimetre(idPerimetre);
        return SUCCESS;
    }
	
	/**
	 * @return the listePerimetres
	 */
	public List<PerimetreBean> getListePerimetres() {
		return listePerimetres;
	}

	/**
	 * @param listePerimetres the listePerimetres to set
	 */
	public void setListePerimetres(List<PerimetreBean> listePerimetres) {
		this.listePerimetres = listePerimetres;
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
