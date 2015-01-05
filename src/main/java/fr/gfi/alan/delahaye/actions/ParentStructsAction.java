/**
 * 
 */
package fr.gfi.alan.delahaye.actions;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;

/**
 * Classe parente de toute les actions struts
 * 
 * @author adelahaye
 *
 */
public abstract class ParentStructsAction extends ActionSupport implements SessionAware, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842076032804852900L;

	public static final String LOGIN = "login";

	protected SessionMap<String, Object> sessionMap;

	private UtilisateurBean utilisateurBean;

	private List<UtilisateurBean> tousLesUtilisateurs;

	private List<PerimetreBean> tousLesPerimetresEnCours;
	
	private String provenance;
	
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	protected SimpleDateFormat sdfGraphe = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private AdministrationManager administrationManager;
	
	@Autowired
	private PerimetreManager perimetreManager;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	protected void init(){
		initialisationUtilisateurConnecte();
		initialisationMembreNotification();
		initialisationPerimetreNotification();
	}
	
	protected void initialisationMembreNotification(){
		tousLesUtilisateurs = administrationManager.recupererTousLesUtilisateurs();
	}
	
	protected void initialisationPerimetreNotification(){
		tousLesPerimetresEnCours = perimetreManager.recupererTousLesPerimetresEnCours();
	}
	
	protected void initialisationUtilisateurConnecte(){
		utilisateurBean = (UtilisateurBean) sessionMap.get("utilisateur");
	}

	protected void saveActionErrorToSession(){
		sessionMap.put("ActionError", getActionErrors());
	}
	
	@SuppressWarnings("unchecked")
	protected void retrieveActionErrorToSession(){
		if(sessionMap.get("ActionError") != null){
			setActionErrors((Collection<String>) sessionMap.get("ActionError"));
			sessionMap.remove("ActionError");
		}
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

	/**
	 * @return the provenance
	 */
	public String getProvenance() {
		return provenance;
	}

	/**
	 * @param provenance the provenance to set
	 */
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	
	public String getUrlAvatar(){
		// TODO Structuration properties
		String url = "file:///C:/fics/ui-danro.jpg";
		if(utilisateurBean != null && !StringUtils.isEmpty(utilisateurBean.getImageAvatar())){
			url = utilisateurBean.getImageAvatar();
		}
		return url;
	}

	/**
	 * @return the tousLesPerimetresEnCours
	 */
	public List<PerimetreBean> getTousLesPerimetresEnCours() {
		return tousLesPerimetresEnCours;
	}

	/**
	 * @param tousLesPerimetresEnCours the tousLesPerimetresEnCours to set
	 */
	public void setTousLesPerimetresEnCours(
			List<PerimetreBean> tousLesPerimetresEnCours) {
		this.tousLesPerimetresEnCours = tousLesPerimetresEnCours;
	}
	
	public int getNbPerimetreEnCours(){
		return tousLesPerimetresEnCours.size();
	}
}
