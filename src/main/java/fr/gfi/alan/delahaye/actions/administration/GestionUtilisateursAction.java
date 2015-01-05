/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;

/**
 * @author adelahaye
 *
 */
public class GestionUtilisateursAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 138791931037255452L;

	private Logger logger = LogManager
			.getLogger(GestionUtilisateursAction.class);

	private List<UtilisateurBean> lesUtilisateurs;
	
	private int idUtilisateur;
	
	@Autowired
	private AdministrationManager administrationManager;
	
	public String execute() throws Exception {
		super.init();
		logger.warn("Phase d'initialisation");
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		lesUtilisateurs = administrationManager.recupererTousLesUtilisateurs();
		return SUCCESS;
	}

	public String supprimerUtilisateur() throws Exception {
		administrationManager.supprimerUtilisateur(idUtilisateur);
        return SUCCESS;
    }
	
	/**
	 * @return the lesUtilisateurs
	 */
	public List<UtilisateurBean> getLesUtilisateurs() {
		return lesUtilisateurs;
	}

	/**
	 * @param lesUtilisateurs the lesUtilisateurs to set
	 */
	public void setLesUtilisateurs(List<UtilisateurBean> lesUtilisateurs) {
		this.lesUtilisateurs = lesUtilisateurs;
	}

	/**
	 * @return the idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
}
