/**
 * 
 */
package fr.gfi.alan.delahaye.utils;

import java.util.ArrayList;
import java.util.List;

import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.entite.EntreePerimetre;
import fr.gfi.alan.delahaye.core.entite.Perimetre;
import fr.gfi.alan.delahaye.core.entite.Utilisateur;

/**
 * Classe utilitaire ce conversion des objets front en entité, et inversement.
 * 
 * @author adelahaye
 *
 */
public abstract class ObjectMapper {

	/**
	 * @param utilisateur
	 * @return
	 */
	public static UtilisateurBean transformUtilisateurToUtilisateurBean(Utilisateur utilisateur){
		final UtilisateurBean utilisateurBean = new UtilisateurBean();
		
		utilisateurBean.setIdUtilisateur(utilisateur.getIdUtilisateur());
		utilisateurBean.setNom(utilisateur.getNom());
		utilisateurBean.setPrenom(utilisateur.getPrenom());
		utilisateurBean.setAdresseMail(utilisateur.getAdresseMail());
		utilisateurBean.setFonction(utilisateur.getFonction());
		utilisateurBean.setNumeroTelephone(utilisateur.getNumeroTelephone());
		utilisateurBean.setImageAvatar(utilisateur.getImageAvatar());
		
		return utilisateurBean;
	}
	
	/**
	 * @param utilisateur
	 * @return
	 */
	public static Utilisateur transformUtilisateurBeanToUtilisateur(UtilisateurBean utilisateurBean){
		final Utilisateur utilisateur = new Utilisateur();
		if(utilisateurBean.getIdUtilisateur() > 0){
			utilisateur.setIdUtilisateur(utilisateurBean.getIdUtilisateur());
		}
		utilisateur.setNom(utilisateurBean.getNom());
		utilisateur.setPrenom(utilisateurBean.getPrenom());
		utilisateur.setAdresseMail(utilisateurBean.getAdresseMail());
		utilisateur.setNumeroTelephone(utilisateurBean.getNumeroTelephone());
		utilisateur.setFonction(utilisateurBean.getFonction());
		utilisateur.setIdentifiant(utilisateurBean.getIdentifiant());
		utilisateur.setMotDePasse(utilisateurBean.getMdp1());
		
		return utilisateur;
	}
	
	/**
	 * @param utilisateur
	 * @return
	 */
	public static PerimetreBean transformPerimetreToPerimetreBean(Perimetre perimetre){
		final PerimetreBean perimetreBean = new PerimetreBean();
		perimetreBean.setIdPerimetre(perimetre.getIdPerimetre());
		perimetreBean.setNomPerimetre(perimetre.getNomPerimetre());
		
		perimetreBean.setChargeInitDeveloppement(perimetre.getChargeInitDeveloppement());
		perimetreBean.setChargeInitDeveloppementForm(Float.toString(perimetre.getChargeInitDeveloppement()));
		
		perimetreBean.setRatioDevRetourRecette(perimetre.getRatioDevRetourRecette());
		perimetreBean.setRatioDevRetourRecetteForm(Integer.toString(perimetre.getRatioDevRetourRecette()));

		perimetreBean.setRatioDevAnomalie(perimetre.getRatioDevAnomalie());
		perimetreBean.setRatioDevAnomalieForm(Integer.toString(perimetre.getRatioDevAnomalie()));
		
		perimetreBean.setChargeRetourRecette(perimetre.getChargeRetourRecette());

		perimetreBean.setChargePassageRecette(perimetre.getChargePassageRecette());
		perimetreBean.setChargePassageRecetteForm(Float.toString(perimetre.getChargePassageRecette()));
		
		perimetreBean.setDateDebut(perimetre.getDateDebut());
		perimetreBean.setDateFin(perimetre.getDateFin());
		
		if((perimetre.getContenu() != null) && (perimetre.getContenu().size() > 0)){
			List<EntreePerimetreBean> leContenu= new ArrayList<EntreePerimetreBean>();
			for(EntreePerimetre entreePerimetre : perimetre.getContenu()){
				leContenu.add(transformEntreePerimetreToEntreePerimetreBean(entreePerimetre));
			}
			perimetreBean.setContenu(leContenu);
		}
		
		if(perimetre.getUtilisateurPrincipaleEnCharge() != null){
			perimetreBean.setUtilisateurPrincipalEnCharge(transformUtilisateurToUtilisateurBean(perimetre.getUtilisateurPrincipaleEnCharge()));
		}
		
		return perimetreBean;
	}
	
	/**
	 * @param utilisateur
	 * @return
	 */
	public static Perimetre transformPerimetreBeanToPerimetre(PerimetreBean perimetreBean){
		final Perimetre perimetre = new Perimetre();
		if(perimetreBean.getIdPerimetre() > 0){
			perimetre.setIdPerimetre(perimetreBean.getIdPerimetre());
		}
		
		perimetre.setNomPerimetre(perimetreBean.getNomPerimetre());
		
		perimetre.setChargeInitDeveloppement(perimetreBean.getChargeInitDeveloppement());
		
		perimetre.setRatioDevRetourRecette(perimetreBean.getRatioDevRetourRecette());

		perimetre.setRatioDevAnomalie(perimetreBean.getRatioDevAnomalie());
		
		perimetre.setChargeRetourRecette(perimetreBean.getChargeRetourRecette());
		
		perimetre.setChargePassageRecette(perimetreBean.getChargePassageRecette());
		
		return perimetre;
	}
	
	/**
	 * @param utilisateur
	 * @return
	 */
	public static EntreePerimetreBean transformEntreePerimetreToEntreePerimetreBean(EntreePerimetre entreePerimetre){
		final EntreePerimetreBean entreePerimetreBean = new EntreePerimetreBean();
		entreePerimetreBean.setIdEntreePerimetre(entreePerimetre.getIdEntreePerimetre());
		entreePerimetreBean.setDateSaisie(entreePerimetre.getDateSaisie());
		entreePerimetreBean.setStockInitial(entreePerimetre.getStockInitial());
		entreePerimetreBean.setNombreCreation(entreePerimetre.getNombreCreation());
		entreePerimetreBean.setNombreRetourKO(entreePerimetre.getNombreRetourKO());
		entreePerimetreBean.setNombreCorrection(entreePerimetre.getNombreCorrection());
		entreePerimetreBean.setNombreCloture(entreePerimetre.getNombreCloture());
		entreePerimetreBean.setChargeTraitement(entreePerimetre.getChargeTraitement());
		entreePerimetreBean.setStockFinal(entreePerimetre.getStockFinal());
		entreePerimetreBean.setVariation(entreePerimetre.getVariation());
		entreePerimetreBean.setChargeRecette(entreePerimetre.getChargeRecette());
		entreePerimetreBean.setRafRecette(entreePerimetre.getRafRecette());
		return entreePerimetreBean;
	}
}
