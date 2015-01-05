/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.gfi.alan.delahaye.actions.administration.validation;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;

public class ValidatePerimetreAction extends ParentStructsAction {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8947830421648562653L;

	private Logger logger = LogManager.getLogger(ValidatePerimetreAction.class);
	
	private PerimetreBean perimetre;
	
	@Autowired
	private AdministrationManager administrationManager;
    
    @Override
    public void validate() {
    	if(StringUtils.isEmpty(perimetre.getNomPerimetre())){
    		addActionError("Le nom du périmètre est obligatoire.");
    	}
		if(StringUtils.isEmpty(perimetre.getChargeInitDeveloppementForm())){
			addActionError("La charge initiale de développement est obligatoire.");
		} else {
			String chargeInitDeveloppementForm = StringUtils.trim(StringUtils.replace(perimetre.getChargeInitDeveloppementForm(), " ", ""));
			chargeInitDeveloppementForm = StringUtils.trim(StringUtils.replace(chargeInitDeveloppementForm, "j.h", ""));
			chargeInitDeveloppementForm = StringUtils.trim(StringUtils.replace(chargeInitDeveloppementForm, ".", ","));
			if(!chargeInitDeveloppementForm.matches("[0-9]+(,[0-9]*)?")){
				addActionError("La charge initiale de développement ne respecte pas le format requis (ex.: 100 | 100.5 | 100,5 | 100 j.h | 100.5 j.h | 100,5 j.h).");
			}
		}
		if(StringUtils.isEmpty(perimetre.getRatioDevRetourRecetteForm())){
			addActionError("Le ratio DEV/RE7 est obligatoire.");
		} else {
			String ratioDevRetourRecetteForm = StringUtils.trim(StringUtils.replace(perimetre.getRatioDevRetourRecetteForm(), " ", ""));
			ratioDevRetourRecetteForm = StringUtils.trim(StringUtils.replace(ratioDevRetourRecetteForm, "%", ""));
			if(!ratioDevRetourRecetteForm.matches("[0-9]+")){
				addActionError("Le ratio DEV/RE7 ne respecte pas le format requis (ex.: 25 | 25 %).");
			} else {
				int ratioDevRetourRecette = Integer.parseInt(ratioDevRetourRecetteForm);
				if((ratioDevRetourRecette <= 0) || (ratioDevRetourRecette > 100)){
					addActionError("Le ratio DEV/RE7 doit être supérieur à 0 et inférieur ou égale à 100.");
				}
			}
		}
		if(StringUtils.isEmpty(perimetre.getRatioDevAnomalieForm())){
			addActionError("Le ratio DEV/anomalies est obligatoire.");
		} else {
			String ratioDevAnomalieForm = StringUtils.trim(StringUtils.replace(perimetre.getRatioDevAnomalieForm(), " ", ""));
			ratioDevAnomalieForm = StringUtils.trim(StringUtils.replace(ratioDevAnomalieForm, "%", ""));
			if(!ratioDevAnomalieForm.matches("[0-9]+")){
				addActionError("Le ratio DEV/anomalies ne respecte pas le format requis (ex.: 25 | 25 %).");
			} else {
				int ratioDevAnomalie = Integer.parseInt(ratioDevAnomalieForm);
				if((ratioDevAnomalie <= 0) || (ratioDevAnomalie > 100)){
					addActionError("Le ratio DEV/anomalies doit être supérieur à 0 et inférieur ou égale à 100.");
				}
			}
		}
		if(StringUtils.isEmpty(perimetre.getChargeInitDeveloppementForm())){
			addActionError("La charge initiale du passage de la recette est obligatoire.");
		} else {
			String chargeInitPassageRecetteForm = StringUtils.trim(StringUtils.replace(perimetre.getChargePassageRecetteForm(), " ", ""));
			chargeInitPassageRecetteForm = StringUtils.trim(StringUtils.replace(chargeInitPassageRecetteForm, "j.h", ""));
			chargeInitPassageRecetteForm = StringUtils.trim(StringUtils.replace(chargeInitPassageRecetteForm, ".", ","));
			if(!chargeInitPassageRecetteForm.matches("[0-9]+(,[0-9]*)?")){
				addActionError("La charge initiale du passage de la recette ne respecte pas le format requis (ex.: 100 | 100.5 | 100,5 | 100 j.h | 100.5 j.h | 100,5 j.h).");
			}
		}
    	super.saveActionErrorToSession();
    }
    
    public String execute() throws Exception {
    	administrationManager.enregistrerPerimetre(perimetre);
        return SUCCESS;
    }

	/**
	 * @return the perimetre
	 */
	public PerimetreBean getPerimetre() {
		return perimetre;
	}

	/**
	 * @param perimetre the perimetre to set
	 */
	public void setPerimetre(PerimetreBean perimetre) {
		this.perimetre = perimetre;
	}
    
	
}
