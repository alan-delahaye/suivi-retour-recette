/**
 * 
 */
package fr.gfi.alan.delahaye.core.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.dao.PerimetreDAO;
import fr.gfi.alan.delahaye.core.dao.UtilisateurDAO;
import fr.gfi.alan.delahaye.core.entite.Perimetre;
import fr.gfi.alan.delahaye.core.entite.Utilisateur;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;
import fr.gfi.alan.delahaye.utils.MD5Crypter;
import fr.gfi.alan.delahaye.utils.ObjectMapper;

/**
 * @author adelahaye
 *
 */
@Service
@Transactional
public class AdministrationManagerImpl extends ObjectMapper implements AdministrationManager {

	private Logger logger = LogManager
			.getLogger(AdministrationManagerImpl.class);
	
	@Autowired
	private UtilisateurDAO utilisateurDAO; 
	
	@Autowired
	private PerimetreDAO perimetreDAO; 
	
	/*
	 * Partie Utilisateur
	 */
	
	@Override
	public List<UtilisateurBean> recupererTousLesUtilisateurs() {
		logger.info(">>AdministrationManagerImpl.recupererTousLesUtilisateurs");
		List<UtilisateurBean> lesUtilisateurs = new ArrayList<UtilisateurBean>();
		List<Utilisateur> utilisateurs = utilisateurDAO.listerTous();
		for(Utilisateur utilisateur : utilisateurs){
			lesUtilisateurs.add(transformUtilisateurToUtilisateurBean(utilisateur));
		}
		logger.info("<<AdministrationManagerImpl.recupererTousLesUtilisateurs");
		return lesUtilisateurs;
	}

	@Override
	public UtilisateurBean identifierUtilisateur(String identifiant, String motDePasse) {
		UtilisateurBean utilisateurBean = null;
		Utilisateur utilisateur = utilisateurDAO.getUtilisateurByIdentifiant(identifiant);
		if((utilisateur != null) && (MD5Crypter.estIdentique(motDePasse, utilisateur.getMotDePasse()))){
			utilisateurBean = transformUtilisateurToUtilisateurBean(utilisateur);
		}
		return utilisateurBean;
	}
	
	@Override
	public UtilisateurBean recupererUtilisateurParId(long idIntervenant) {
		UtilisateurBean utilisateurBean = null;
		Utilisateur utilisateur = utilisateurDAO.read(idIntervenant);
		if(utilisateur != null){
			utilisateurBean = transformUtilisateurToUtilisateurBean(utilisateur);
		}
		return utilisateurBean;
	}

	@Override
	public void enregistrerUtilisateur(UtilisateurBean utilisateurBean) {
		normaliserUtilisateur(utilisateurBean);
		if(utilisateurBean.getIdUtilisateur() > 0){
			Utilisateur utilisateur = utilisateurDAO.read(utilisateurBean.getIdUtilisateur());
			utilisateur.setNom(utilisateurBean.getNom());
			utilisateur.setPrenom(utilisateurBean.getPrenom());
			utilisateur.setAdresseMail(utilisateurBean.getAdresseMail());
			utilisateur.setFonction(utilisateurBean.getFonction());
			utilisateur.setNumeroTelephone(utilisateurBean.getNumeroTelephone());
			if(!StringUtils.isEmpty(utilisateurBean.getMdp1())){
				utilisateur.setMotDePasse(utilisateurBean.getMdp1());
			}
			utilisateurDAO.merge(utilisateur);
		} else {
			Utilisateur utilisateur = transformUtilisateurBeanToUtilisateur(utilisateurBean);
			utilisateurDAO.persist(utilisateur);
		}
	}

	@Override
	public void supprimerUtilisateur(long idUtilisateur) {
		// TODO mettre à null toutes les relations filles possibles.
		logger.warn(">> Suppression de l'utilisateur d'id " + idUtilisateur);
		utilisateurDAO.remove(idUtilisateur);
	}

	
	/*
	 * Partie Perimetre
	 * 
	 * TODO à tester
	 */

	@Override
	public List<PerimetreBean> recupererTousLesPerimetres() {
		logger.info(">>AdministrationManagerImpl.recupererTousLesPerimetres");
		List<PerimetreBean> lesPerimetresBean = new ArrayList<PerimetreBean>();
		List<Perimetre> lesPerimetres = perimetreDAO.listerTous();
		for(Perimetre perimetre : lesPerimetres){
			if((perimetre.getContenu() != null) && !Hibernate.isInitialized(perimetre.getContenu())){
				logger.warn(">>>> init Contenu");
				Hibernate.initialize(perimetre.getContenu());
			}
			if((perimetre.getUtilisateurPrincipaleEnCharge() != null) && !Hibernate.isInitialized(perimetre.getUtilisateurPrincipaleEnCharge())){
				logger.warn(">>>> init Utiliateur");
				Hibernate.initialize(perimetre.getUtilisateurPrincipaleEnCharge());
			}
			lesPerimetresBean.add(transformPerimetreToPerimetreBean(perimetre));
		}
		logger.info("<<AdministrationManagerImpl.recupererTousLesPerimetres");
		return lesPerimetresBean;
	}

	@Override
	public void enregistrerPerimetre(PerimetreBean perimetreBean) {
		normaliserPerimetre(perimetreBean);
		if(perimetreBean.getIdPerimetre() > 0){
			Perimetre perimetre = perimetreDAO.read(perimetreBean.getIdPerimetre());
			perimetre.setNomPerimetre(perimetreBean.getNomPerimetre());
			perimetre.setChargeInitDeveloppement(perimetreBean.getChargeInitDeveloppement());
			perimetre.setRatioDevRetourRecette(perimetreBean.getRatioDevRetourRecette());
			perimetre.setChargeRetourRecette(perimetreBean.getChargeRetourRecette());
			perimetre.setRatioDevAnomalie(perimetreBean.getRatioDevAnomalie());
			perimetre.setChargePassageRecette(perimetreBean.getChargePassageRecette());
			// TODO Gestion utilisateur
			perimetreDAO.merge(perimetre);
		} else {
			Perimetre perimetre = transformPerimetreBeanToPerimetre(perimetreBean);
			perimetreDAO.persist(perimetre);
		}
	}

	@Override
	public PerimetreBean recupererPerimetreParId(long idPerimetre) {
		PerimetreBean perimetreBean = null;
		Perimetre perimetre = perimetreDAO.read(idPerimetre);
		if(perimetre != null){
			perimetreBean = transformPerimetreToPerimetreBean(perimetre);
		}
		return perimetreBean;
	}

	@Override
	public void supprimerPerimetre(long idPerimetre) {
		// TODO mettre à null toutes les relations filles possibles.
		logger.warn(">> Suppression du périmètre d'id " + idPerimetre);
		perimetreDAO.remove(idPerimetre);
	}

	@Override
	public void demarrerPerimetre(long idPerimetre) {
		Perimetre perimetre = perimetreDAO.read(idPerimetre);
		perimetre.setDateDebut(new Date());
		perimetreDAO.merge(perimetre);
	}
	
	/*
	 * Méthodes utilitaires
	 */
	
	private void normaliserUtilisateur(UtilisateurBean utilisateurBean){
		utilisateurBean.setNom(WordUtils.capitalizeFully(StringUtils.trim(utilisateurBean.getNom())));
		utilisateurBean.setPrenom(WordUtils.capitalizeFully(StringUtils.trim(utilisateurBean.getPrenom())));
		utilisateurBean.setAdresseMail(StringUtils.lowerCase(StringUtils.trim(utilisateurBean.getAdresseMail())));
		utilisateurBean.setNumeroTelephone(StringUtils.trim(utilisateurBean.getNumeroTelephone()));
		utilisateurBean.setFonction(WordUtils.capitalizeFully(StringUtils.trim(utilisateurBean.getFonction())));
		utilisateurBean.setIdentifiant(genererIdentifiant(utilisateurBean));
		if(!StringUtils.isEmpty(utilisateurBean.getMdp1())){
			utilisateurBean.setMdp1(MD5Crypter.crypterMD5(utilisateurBean.getMdp1()));
		}
	}
	
	private void normaliserPerimetre(PerimetreBean perimetreBean){
		
		perimetreBean.setNomPerimetre(WordUtils.capitalizeFully(StringUtils.trim(perimetreBean.getNomPerimetre())));
		
		String chargeInitDeveloppementForm = StringUtils.trim(StringUtils.replace(perimetreBean.getChargeInitDeveloppementForm(), " ", ""));
		chargeInitDeveloppementForm = StringUtils.trim(StringUtils.replace(chargeInitDeveloppementForm, "j.h", ""));
		chargeInitDeveloppementForm = StringUtils.trim(StringUtils.replace(chargeInitDeveloppementForm, ",", "."));
		
		perimetreBean.setChargeInitDeveloppement(Float.parseFloat(chargeInitDeveloppementForm));
		
		String ratioDevRetourRecetteForm = StringUtils.trim(StringUtils.replace(perimetreBean.getRatioDevRetourRecetteForm(), " ", ""));
		ratioDevRetourRecetteForm = StringUtils.trim(StringUtils.replace(ratioDevRetourRecetteForm, "%", ""));
		
		perimetreBean.setRatioDevRetourRecette(Integer.parseInt(ratioDevRetourRecetteForm));
		
		String ratioDevAnomalieForm = StringUtils.trim(StringUtils.replace(perimetreBean.getRatioDevAnomalieForm(), " ", ""));
		ratioDevAnomalieForm = StringUtils.trim(StringUtils.replace(ratioDevAnomalieForm, "%", ""));
		
		perimetreBean.setRatioDevAnomalie(Integer.parseInt(ratioDevAnomalieForm));
		
		final float chargeRetourRecette = (float) ((perimetreBean.getChargeInitDeveloppement() * perimetreBean.getRatioDevRetourRecette()) / 100);
		
		perimetreBean.setChargeRetourRecette(chargeRetourRecette);
		
		String chargeInitPassageForm = StringUtils.trim(StringUtils.replace(perimetreBean.getChargePassageRecetteForm(), " ", ""));
		chargeInitPassageForm = StringUtils.trim(StringUtils.replace(chargeInitPassageForm, "j.h", ""));
		chargeInitPassageForm = StringUtils.trim(StringUtils.replace(chargeInitPassageForm, ",", "."));
		
		perimetreBean.setChargePassageRecette(Float.parseFloat(chargeInitPassageForm));
	}
	
	private String genererIdentifiant(UtilisateurBean utilisateur){
		StringBuilder identifiant = null;
		String nom = StringUtils.lowerCase(StringUtils.replace(utilisateur.getNom()," ","-"));
		String prenom = StringUtils.lowerCase(utilisateur.getPrenom());
		boolean isOK = false;
		int increment = 0;
		while (!isOK){
			identifiant = new StringBuilder();
			identifiant.append(StringUtils.left(prenom,1));
			identifiant.append(nom);
			if(increment > 0){
				identifiant.append(increment);
			}
			increment++;
			isOK = (utilisateurDAO.getUtilisateurByIdentifiant(identifiant.toString()) == null);
		}
		return identifiant.toString();
	}
}
