/**
 * 
 */
package fr.gfi.alan.delahaye.core.manager.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.dao.EntreePerimetreDAO;
import fr.gfi.alan.delahaye.core.dao.PerimetreDAO;
import fr.gfi.alan.delahaye.core.entite.EntreePerimetre;
import fr.gfi.alan.delahaye.core.entite.Perimetre;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;
import fr.gfi.alan.delahaye.utils.ObjectMapper;

/**
 * @author adelahaye
 *
 */
@Service
@Transactional
public class PerimetreManagerImpl extends ObjectMapper implements
		PerimetreManager {

	private Logger logger = LogManager.getLogger(PerimetreManagerImpl.class);

	@Autowired
	private PerimetreDAO perimetreDAO;

	@Autowired
	private EntreePerimetreDAO entreePerimetreDAO;

	@Override
	public PerimetreBean recupererPerimetreComplet(long idPerimetre) {
		Perimetre perimetre = perimetreDAO.read(idPerimetre);
		logger.warn(">>>> Contenu : " + perimetre.getContenu());
		if ((perimetre.getContenu() != null)
				&& !Hibernate.isInitialized(perimetre.getContenu())) {
			logger.warn(">>>> init Contenu");
			Hibernate.initialize(perimetre.getContenu());
		}
		logger.warn(">>>> Utilisateur : "
				+ perimetre.getUtilisateurPrincipaleEnCharge());
		if ((perimetre.getUtilisateurPrincipaleEnCharge() != null)
				&& !Hibernate.isInitialized(perimetre
						.getUtilisateurPrincipaleEnCharge())) {
			logger.warn(">>>> init Utiliateur");
			Hibernate.initialize(perimetre.getUtilisateurPrincipaleEnCharge());
		}
		PerimetreBean bean = transformPerimetreToPerimetreBean(perimetre);
		EntreePerimetre entreePerimetre = recupererDerniereEntreePerimetre(bean.getIdPerimetre());
		if(entreePerimetre != null){
			int avancement = (int) (100 - ((entreePerimetre.getRafRecette()/bean.getChargePassageRecette())*100));
			bean.setAvancement(avancement);
			bean.setRafPassage(entreePerimetre.getRafRecette());
		}
		int nombreTotalAno = 0;
		int nombreTotalAnoSansRegul = 0;
		int nombreCorrigee = 0;
		if(bean.getContenu() != null){
			for(EntreePerimetreBean entreePerimetreBean : bean.getContenu()){
				nombreTotalAnoSansRegul += entreePerimetreBean.getNombreCreation();
				nombreTotalAno += entreePerimetreBean.getNombreCreation();
				nombreTotalAno -= entreePerimetreBean.getNombreCloture();
				
				nombreCorrigee += entreePerimetreBean.getNombreCorrection();
				nombreCorrigee -= entreePerimetreBean.getNombreRetourKO();
				
			}
			bean.setNombreAnoSansRegul(nombreTotalAnoSansRegul);
			bean.setNombreAnoTotal(nombreTotalAno);
			bean.setNombreAnoCorrigee(nombreCorrigee);
			if((bean.getNombreAnoTotal()-bean.getNombreAnoCorrigee()) != entreePerimetre.getStockFinal()){
				logger.error("Il y a une incohérence : [nombreTotalAno : " + bean.getNombreAnoTotal() 
						+ ", nombreAnoCorrigee : "+bean.getNombreAnoCorrigee()+", stockFinal : "+entreePerimetre.getStockFinal()+"]");
			}
		}
		return bean;
	}

	@Override
	public List<Date> recupereDateDejaSaisie(long idPerimetre) {
		List<EntreePerimetre> entreePerimetres = entreePerimetreDAO
				.recupereLesEntreeParPerimetre(idPerimetre);
		List<Date> lesDates = new ArrayList<Date>();
		if (entreePerimetres != null) {
			for (EntreePerimetre entreePerimetre : entreePerimetres) {
				lesDates.add(entreePerimetre.getDateSaisie());
			}
		}
		return lesDates;
	}

	@Override
	public void enregistrerEntreePerimetre(
			EntreePerimetreBean entreePerimetreBean) {
		formaliserEntreePerimetreBean(entreePerimetreBean);
		EntreePerimetre entreePerimetre;
		if (entreePerimetreBean.getIdEntreePerimetre() > 0) {
			entreePerimetre = entreePerimetreDAO.read(entreePerimetreBean
					.getIdEntreePerimetre());
		} else {
			entreePerimetre = new EntreePerimetre();
		}
		entreePerimetre.setDateSaisie(entreePerimetreBean.getDateSaisie());
		entreePerimetre.setStockInitial(entreePerimetreBean.getStockInitial());
		entreePerimetre.setNombreCreation(entreePerimetreBean
				.getNombreCreation());
		entreePerimetre.setNombreRetourKO(entreePerimetreBean
				.getNombreRetourKO());
		entreePerimetre.setNombreCorrection(entreePerimetreBean
				.getNombreCorrection());
		entreePerimetre
				.setNombreCloture(entreePerimetreBean.getNombreCloture());
		entreePerimetre.setChargeTraitement(entreePerimetreBean
				.getChargeTraitement());
		entreePerimetre.setStockFinal(entreePerimetreBean.getStockFinal());
		entreePerimetre.setVariation(entreePerimetreBean.getVariation());
		entreePerimetre
				.setChargeRecette(entreePerimetreBean.getChargeRecette());
		entreePerimetre.setRafRecette(entreePerimetreBean.getRafRecette());
		entreePerimetre.setPerimetre(perimetreDAO.read(entreePerimetreBean
				.getIdPerimetreForm()));

		if (entreePerimetre.getIdEntreePerimetre() > 0) {
			entreePerimetreDAO.merge(entreePerimetre);
		} else {
			entreePerimetreDAO.persist(entreePerimetre);
		}
	}

	@Override
	public EntreePerimetre recupererDerniereEntreePerimetre(long idPerimetre){
		return entreePerimetreDAO.recupereLastEntreeParPerimetre(idPerimetre);
	}
	
	private void formaliserEntreePerimetreBean(
			EntreePerimetreBean entreePerimetreBean) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			entreePerimetreBean.setDateSaisie(sdf.parse(entreePerimetreBean
					.getDateSaisieForm()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		entreePerimetreBean.setStockInitial(0);
		
		EntreePerimetre entreePerimetre = recupererDerniereEntreePerimetre(entreePerimetreBean.getIdPerimetreForm());
		
		if(entreePerimetre != null){
			logger.warn("recupererDerniereEntreePerimetre >> date : " + entreePerimetre.getDateSaisie() + " >> stockFinal :" + entreePerimetre.getStockFinal());
			entreePerimetreBean.setStockInitial(entreePerimetre.getStockFinal());
		} 

		String nombreCreationForm = "0";
		if(!StringUtils.isEmpty(entreePerimetreBean.getNombreCreationForm())){
			nombreCreationForm = StringUtils.trim(StringUtils.replace(
				entreePerimetreBean.getNombreCreationForm(), " ", ""));
		}
		entreePerimetreBean.setNombreCreation(Integer
				.parseInt(nombreCreationForm));

		String nombreRetourKOForm = "0";
		if(!StringUtils.isEmpty(entreePerimetreBean.getNombreRetourKOForm())){
			nombreRetourKOForm = StringUtils.trim(StringUtils.replace(
				entreePerimetreBean.getNombreRetourKOForm(), " ", ""));
		}
		entreePerimetreBean.setNombreRetourKO(Integer
				.parseInt(nombreRetourKOForm));

		String nombreCorrectionForm = "0";
		if(!StringUtils.isEmpty(entreePerimetreBean.getNombreCorrectionForm())){
			nombreCorrectionForm = StringUtils
				.trim(StringUtils.replace(
						entreePerimetreBean.getNombreCorrectionForm(), " ", ""));
		}	
		entreePerimetreBean.setNombreCorrection(Integer
				.parseInt(nombreCorrectionForm));

		String nombreClotureForm = "0";
		if(!StringUtils.isEmpty(entreePerimetreBean.getNombreClotureForm())){
			nombreClotureForm = StringUtils.trim(StringUtils.replace(
				entreePerimetreBean.getNombreClotureForm(), " ", ""));
		}
		entreePerimetreBean.setNombreCloture(Integer
				.parseInt(nombreClotureForm));

		String chargeTraitementForm = "0";
		if(!StringUtils.isEmpty(entreePerimetreBean.getChargeTraitementForm())){
			chargeTraitementForm = StringUtils.trim(StringUtils.replace(
				entreePerimetreBean.getChargeTraitementForm(), " ", ""));
			chargeTraitementForm = StringUtils.trim(StringUtils.replace(
				chargeTraitementForm, "j.h", ""));
			chargeTraitementForm = StringUtils.trim(StringUtils.replace(
				chargeTraitementForm, ",", "."));
		}
		entreePerimetreBean.setChargeTraitement(Float
				.parseFloat(chargeTraitementForm));

		int stockFinale = entreePerimetreBean.getStockInitial()
				+ entreePerimetreBean.getNombreCreation()
				+ entreePerimetreBean.getNombreRetourKO()
				- entreePerimetreBean.getNombreCorrection()
				- entreePerimetreBean.getNombreCloture();

		entreePerimetreBean.setStockFinal(stockFinale);
		
		int variation = entreePerimetreBean.getStockFinal() - entreePerimetreBean.getStockInitial();
		
		entreePerimetreBean.setVariation(variation);
		
		String chargeRecetteForm = "0";
		if(!StringUtils.isEmpty(entreePerimetreBean.getChargeRecetteForm())){
			chargeRecetteForm = StringUtils.trim(StringUtils.replace(
				entreePerimetreBean.getChargeRecetteForm(), " ", ""));
			chargeRecetteForm = StringUtils.trim(StringUtils.replace(
				chargeRecetteForm, "j.h", ""));
			chargeRecetteForm = StringUtils.trim(StringUtils.replace(
				chargeRecetteForm, ",", "."));
		}
		entreePerimetreBean.setChargeRecette(Float
				.parseFloat(chargeRecetteForm));
		
		String rafRecetteForm = "0";
		if(!StringUtils.isEmpty(entreePerimetreBean.getRafRecetteForm())){
			rafRecetteForm = StringUtils.trim(StringUtils.replace(
					entreePerimetreBean.getRafRecetteForm(), " ", ""));
			rafRecetteForm = StringUtils.trim(StringUtils.replace(
					rafRecetteForm, "j.h", ""));
			rafRecetteForm = StringUtils.trim(StringUtils.replace(
					rafRecetteForm, ",", "."));
		}
		entreePerimetreBean.setRafRecette(Float
				.parseFloat(rafRecetteForm));
	}

	@Override
	public boolean mettreAJourEtatPerimetre(long idPerimetre) {
		boolean retour = false;
		if(idPerimetre > 0){
			Perimetre perimetre = perimetreDAO.read(idPerimetre);
			if(perimetre!=null){
				if(perimetre.getDateDebut() == null) {
					perimetre.setDateDebut(new Date());
					perimetreDAO.merge(perimetre);
					retour = true;
				} else if(perimetre.getDateFin() == null) {
					perimetre.setDateFin(new Date());
					perimetreDAO.merge(perimetre);
					retour = true;
				} 
			} 
		} 
		return retour;
	}

	@Override
	public List<PerimetreBean> recupererTousLesPerimetresEnCours() {
		List<PerimetreBean> retour = new ArrayList<PerimetreBean>();
		List<Perimetre> lesPerimetres = perimetreDAO.recupererLesPerimetresActif();
		for(Perimetre perimetre : lesPerimetres){
			if ((perimetre.getContenu() != null)
					&& !Hibernate.isInitialized(perimetre.getContenu())) {
				logger.warn(">>>> init Contenu");
				Hibernate.initialize(perimetre.getContenu());
			}
			logger.warn(">>>> Utilisateur : "
					+ perimetre.getUtilisateurPrincipaleEnCharge());
			if ((perimetre.getUtilisateurPrincipaleEnCharge() != null)
					&& !Hibernate.isInitialized(perimetre
							.getUtilisateurPrincipaleEnCharge())) {
				logger.warn(">>>> init Utiliateur");
				Hibernate.initialize(perimetre.getUtilisateurPrincipaleEnCharge());
			}
			PerimetreBean bean = transformPerimetreToPerimetreBean(perimetre);
			EntreePerimetre entreePerimetre = recupererDerniereEntreePerimetre(bean.getIdPerimetre());
			int avancement = 0;
			if(entreePerimetre != null){
				avancement = (int) (100 - ((entreePerimetre.getRafRecette()/bean.getChargePassageRecette())*100));
				bean.setRafPassage(entreePerimetre.getRafRecette());
			}
			bean.setAvancement(avancement);
			
			int nombreTotalAno = 0;
			int nombreCorrigee = 0;
			if(bean.getContenu() != null){
				for(EntreePerimetreBean entreePerimetreBean : bean.getContenu()){
					nombreTotalAno += entreePerimetreBean.getNombreCreation();
					nombreTotalAno -= entreePerimetreBean.getNombreCloture();
					
					nombreCorrigee += entreePerimetreBean.getNombreCorrection();
					nombreCorrigee -= entreePerimetreBean.getNombreRetourKO();
					
				}
				
				bean.setNombreAnoTotal(nombreTotalAno);
				bean.setNombreAnoCorrigee(nombreCorrigee);
				if((bean.getNombreAnoTotal()-bean.getNombreAnoCorrigee()) != entreePerimetre.getStockFinal()){
					logger.error("Il y a une incohérence : [nombreTotalAno : " + bean.getNombreAnoTotal() 
							+ ", nombreAnoCorrigee : "+bean.getNombreAnoCorrigee()+", stockFinal : "+entreePerimetre.getStockFinal()+"]");
				}
			}
			retour.add(bean);
		}
		return retour;
	}
}
