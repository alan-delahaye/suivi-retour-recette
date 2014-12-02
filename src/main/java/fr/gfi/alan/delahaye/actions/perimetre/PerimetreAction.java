/**
 * 
 */
package fr.gfi.alan.delahaye.actions.perimetre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.actions.administration.AdministrationAction;
import fr.gfi.alan.delahaye.beans.PerimetreBean;

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

	private Map<String, List<PerimetreBean>> tousLesPerimetres;
	
	public String execute() throws Exception {
		super.init();
		logger.warn("Phase d'initialisation");
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		// TODO
		tousLesPerimetres = new HashMap<String, List<PerimetreBean>>();
		List<PerimetreBean> perimetreBeans = new ArrayList<PerimetreBean>();
		PerimetreBean perimetreBean = new PerimetreBean("Lot 3 P1",100, 20,20,25);
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 3 P2",200, 40,40,25);
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 3 P3",100, 20,20,25);
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 3 P4",200, 40,40,25);
		perimetreBeans.add(perimetreBean);
		tousLesPerimetres.put("1", perimetreBeans);
		
		perimetreBeans = new ArrayList<PerimetreBean>();
		perimetreBean = new PerimetreBean("Lot 4 P1",100, 20,20,25);
		perimetreBeans.add(perimetreBean);
		perimetreBean = new PerimetreBean("Lot 4 P2",200, 40,40,25);
		perimetreBeans.add(perimetreBean);
		tousLesPerimetres.put("2", perimetreBeans);
		
		return SUCCESS;
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
