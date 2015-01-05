/**
 * 
 */
package fr.gfi.alan.delahaye.core.manager;

import java.util.List;

import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;

/**
 * TODO JavaDOC
 * @author adelahaye
 *
 */
public interface AdministrationManager {

	/*
	 * Partie Utilisateur
	 */
	
	List<UtilisateurBean> recupererTousLesUtilisateurs();
	
	UtilisateurBean identifierUtilisateur(String identifiant, String motDePasse);
	
	void enregistrerUtilisateur(UtilisateurBean utilisateurBean);
	
	UtilisateurBean recupererUtilisateurParId(long idUtilisateur);
	
	void supprimerUtilisateur(long idUtilisateur);

	/*
	 * Partie Perimetre
	 */
	List<PerimetreBean> recupererTousLesPerimetres();
	
	void enregistrerPerimetre(PerimetreBean perimetreBean);
	
	PerimetreBean recupererPerimetreParId(long idPerimetre);
	
	void supprimerPerimetre(long idPerimetre);
	
	void demarrerPerimetre(long idPerimetre);
	
}
