/**
 * 
 */
package fr.gfi.alan.delahaye.core.manager;

import java.util.Date;
import java.util.List;

import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.entite.EntreePerimetre;

/**
 * @author adelahaye
 *
 */
public interface PerimetreManager {

	PerimetreBean recupererPerimetreComplet(long idPerimetre);
	
	List<Date> recupereDateDejaSaisie(long idPerimetre);
	
	void enregistrerEntreePerimetre(EntreePerimetreBean entreePerimetreBean);

	EntreePerimetre recupererDerniereEntreePerimetre(long idPerimetre);
	
	boolean mettreAJourEtatPerimetre(long idPerimetre);
	
	List<PerimetreBean> recupererTousLesPerimetresEnCours();
}
