/**
 * 
 */
package fr.gfi.alan.delahaye.actions.perimetre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.actions.administration.AdministrationAction;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;

/**
 * @author adelahaye
 *
 */
public class PerimetreAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8869473766917398137L;

	private Logger logger = LogManager.getLogger(AdministrationAction.class);

	private UtilisateurBean utilisateurBean;

	private List<UtilisateurBean> tousLesUtilisateurs;

	private Map<String, List<PerimetreBean>> tousLesPerimetres;
	
	public String execute() throws Exception {
		logger.warn("Phase d'initialisation");
		utilisateurBean = (UtilisateurBean) sessionMap.get("utilisateur");
		if (utilisateurBean == null) {
			return LOGIN;
		}
		// TODO:Récupération par un manager
		tousLesUtilisateurs = new ArrayList<UtilisateurBean>();
		UtilisateurBean bean = new UtilisateurBean("Defrance", "Vincent",
				"Chef de Projet");
		tousLesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Delahaye", "Alan",
				"Responsable Intégration");
		tousLesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Medjoudj", "Abderezak",
				"Responsable Développements");
		tousLesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Collet", "François", "Responsable Recettes");
		tousLesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Vion", "Jean-François",
				"Backup Resp. Intégration");
		tousLesUtilisateurs.add(bean);

		//TODO Récupération par un manager
		tousLesPerimetres = new HashMap<String, List<PerimetreBean>>();
		List<PerimetreBean> perimetreBeans = new ArrayList<PerimetreBean>();
		PerimetreBean perimetreBean = new PerimetreBean("Lot 3 P1");
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 3 P2");
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 3 P3");
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 3 P4");
		perimetreBeans.add(perimetreBean);
		tousLesPerimetres.put("1", perimetreBeans);
		
		perimetreBeans = new ArrayList<PerimetreBean>();
		perimetreBean = new PerimetreBean("Lot 4 P1");
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 4 P2");
		perimetreBeans.add(perimetreBean);
		tousLesPerimetres.put("2", perimetreBeans);
		
		return SUCCESS;
	}
	
	/**
	 * @return the utilisateurBean
	 */
	public UtilisateurBean getUtilisateurBean() {
		return utilisateurBean;
	}

	/**
	 * @param utilisateurBean
	 *            the utilisateurBean to set
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
	 * @param tousLesUtilisateurs
	 *            the tousLesUtilisateurs to set
	 */
	public void setTousLesUtilisateurs(List<UtilisateurBean> tousLesUtilisateurs) {
		this.tousLesUtilisateurs = tousLesUtilisateurs;
	}

	/**
	 * @return the tousLesPerimetres
	 */
	public Map<String, List<PerimetreBean>> getTousLesPerimetres() {
		return tousLesPerimetres;
	}

	/**
	 * @param tousLesPerimetres the tousLesPerimetres to set
	 */
	public void setTousLesPerimetres(
			Map<String, List<PerimetreBean>> tousLesPerimetres) {
		this.tousLesPerimetres = tousLesPerimetres;
	}
}
