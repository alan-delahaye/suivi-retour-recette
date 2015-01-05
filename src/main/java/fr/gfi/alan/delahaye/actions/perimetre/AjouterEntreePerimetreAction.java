/**
 * 
 */
package fr.gfi.alan.delahaye.actions.perimetre;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;

/**
 * @author adelahaye
 *
 */
public class AjouterEntreePerimetreAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 138791931037255452L;

	private Logger logger = LogManager
			.getLogger(AjouterEntreePerimetreAction.class);

	@Autowired
	private PerimetreManager perimetreManager;
	
	private PerimetreBean perimetreBean;
	
	private EntreePerimetreBean entreePerimetreBean;
	
	/**
	 * Perimètre concerné par l'ajout
	 */
	private int idPerimetre;
	
	private int idEntreePerimetre;
	
	@Autowired
	private AdministrationManager administrationManager;
	
	public String execute() throws Exception {
		super.init();
		super.retrieveActionErrorToSession();
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		if(idPerimetre > 0){
			perimetreBean = administrationManager.recupererPerimetreParId(idPerimetre);
		} else {
			if((idEntreePerimetre <= 0) && (entreePerimetreBean == null)) {
				return ERROR;
			} else {
				perimetreBean = administrationManager.recupererPerimetreParId(entreePerimetreBean.getIdPerimetreForm());
			}
		}
		if(idEntreePerimetre > 0){
			// TODO récuperer l'entrée en BDD
			
		
		} else {
			if(entreePerimetreBean == null){
				entreePerimetreBean = new EntreePerimetreBean();
				entreePerimetreBean.setIdPerimetreForm(idPerimetre);
			}
		}
		return SUCCESS;
	}

	/**
	 * @return the perimetre
	 */
	public PerimetreBean getPerimetreBean() {
		return perimetreBean;
	}

	/**
	 * @param perimetre the perimetre to set
	 */
	public void setPerimetreBean(PerimetreBean perimetre) {
		this.perimetreBean = perimetre;
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

	/**
	 * @return the entreePerimetreBean
	 */
	public EntreePerimetreBean getEntreePerimetreBean() {
		return entreePerimetreBean;
	}

	/**
	 * @param entreePerimetreBean the entreePerimetreBean to set
	 */
	public void setEntreePerimetreBean(EntreePerimetreBean entreePerimetreBean) {
		this.entreePerimetreBean = entreePerimetreBean;
	}
	
	public String getBadDates(){
		List<Date> dateDejaRenseignees = perimetreManager.recupereDateDejaSaisie(idPerimetre);
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("[");
		for(Date date : dateDejaRenseignees){
			if(stringBuilder.length() > 1){
				stringBuilder.append(",");
			}
			stringBuilder.append("\"");
			stringBuilder.append(sdf.format(date));
			stringBuilder.append("\"");
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	public String getFirstDate(){
		Date premiereDate = perimetreBean.getDateDebut();
		StringBuilder builder = new StringBuilder();
		builder.append("\"");
		builder.append(sdf.format(premiereDate));
		builder.append("\"");
		return builder.toString();
	}

	/**
	 * @return the idEntreePerimetre
	 */
	public int getIdEntreePerimetre() {
		return idEntreePerimetre;
	}

	/**
	 * @param idEntreePerimetre the idEntreePerimetre to set
	 */
	public void setIdEntreePerimetre(int idEntreePerimetre) {
		this.idEntreePerimetre = idEntreePerimetre;
	}
}
