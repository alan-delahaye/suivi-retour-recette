/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;

/**
 * @author adelahaye
 *
 */
public class ExportAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3413760816959724533L;

	private Logger logger = LogManager.getLogger(AdministrationAction.class);
	
	 private UtilisateurBean utilisateurBean;
	    
	    private List<UtilisateurBean> tousLesUtilisateurs;
	    
	   public String execute() throws Exception {
	    	logger.warn("Phase d'initialisation");
	    	utilisateurBean = (UtilisateurBean) sessionMap.get("utilisateur");
	    	if(utilisateurBean == null){
		    	return LOGIN;
	    	}
	    	//TODO:Récupération par un manager
	    	tousLesUtilisateurs = new ArrayList<UtilisateurBean>();
	    	UtilisateurBean bean = new UtilisateurBean("Defrance","Vincent","Chef de Projet");
	    	tousLesUtilisateurs.add(bean);
	    	bean = new UtilisateurBean("Delahaye","Alan","Responsable Intégration");
	    	tousLesUtilisateurs.add(bean);
	    	bean = new UtilisateurBean("Medjoudj","Abderezak","Responsable Développements");
	    	tousLesUtilisateurs.add(bean);
	    	bean = new UtilisateurBean("Collet","François","Responsable Recettes");
	    	tousLesUtilisateurs.add(bean);
	    	bean = new UtilisateurBean("Vion","Jean-François","Backup Resp. Intégration");
	    	tousLesUtilisateurs.add(bean);
	    	
	        return SUCCESS;
	    }
	    
		/**
		 * @return the utilisateurBean
		 */
		public UtilisateurBean getUtilisateurBean() {
			return utilisateurBean;
		}
		/**
		 * @param utilisateurBean the utilisateurBean to set
		 */
		public void setUtilisateurBean(UtilisateurBean utilisateurBean) {
			this.utilisateurBean = utilisateurBean;
		}

		/**
		 * @return the tousLesUtilisateurs
		 */
		public List<UtilisateurBean> getTousLesUtilisateurs() {
			return tousLesUtilisateurs;
		}

		/**
		 * @param tousLesUtilisateurs the tousLesUtilisateurs to set
		 */
		public void setTousLesUtilisateurs(List<UtilisateurBean> tousLesUtilisateurs) {
			this.tousLesUtilisateurs = tousLesUtilisateurs;
		}
}
