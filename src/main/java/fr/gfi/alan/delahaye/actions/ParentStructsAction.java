/**
 * 
 */
package fr.gfi.alan.delahaye.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;

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
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	protected void init(){
		initialisationUtilisateurConnecte();
		initialisationMembreNotification();
	}
	
	protected void initialisationMembreNotification(){
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
	}
	
	protected void initialisationUtilisateurConnecte(){
		utilisateurBean = (UtilisateurBean) sessionMap.get("utilisateur");
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
