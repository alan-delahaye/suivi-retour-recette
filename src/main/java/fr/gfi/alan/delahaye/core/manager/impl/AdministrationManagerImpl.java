/**
 * 
 */
package fr.gfi.alan.delahaye.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;

/**
 * @author adelahaye
 *
 */
@Service
public class AdministrationManagerImpl implements AdministrationManager {

	private Logger logger = LogManager
			.getLogger(AdministrationManagerImpl.class);
	
	@Override
	public List<UtilisateurBean> recupererTousLesUtilisateurs() {
		//TODO : Passer par un DAO
		logger.info(">>AdministrationManagerImpl.recupererTousLesUtilisateurs");
		List<UtilisateurBean> lesUtilisateurs = new ArrayList<UtilisateurBean>();
		UtilisateurBean bean = new UtilisateurBean("Defrance", "Vincent",
				"vincent.defrance@gfi.fr", "Chef de Projet", "03.03.03.03.03");
		lesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Delahaye", "Alan", "alan.delahaye@gfi.fr",
				"Responsable Intégration", "03.03.03.03.03");
		lesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Medjoudj", "Abderezak",
				"abderezak.medjoudj@gfi.fr", "Responsable Développements",
				"03.03.03.03.03");
		lesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Collet", "François",
				"francois.collet@gfi.fr", "Responsable Recettes",
				"01.01.01.01.01");
		lesUtilisateurs.add(bean);
		bean = new UtilisateurBean("Vion", "Jean-François",
				"jean-francois.vion@gfi.fr", "Backup Resp. Intégration",
				"03.03.03.03.03");
		lesUtilisateurs.add(bean);
		logger.info("<<AdministrationManagerImpl.recupererTousLesUtilisateurs");
		return lesUtilisateurs;
	}

}
