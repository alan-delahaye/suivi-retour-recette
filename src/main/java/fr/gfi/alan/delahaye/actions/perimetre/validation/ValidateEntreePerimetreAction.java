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
package fr.gfi.alan.delahaye.actions.perimetre.validation;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;

public class ValidateEntreePerimetreAction extends ParentStructsAction {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8947830421648562653L;

	private Logger logger = LogManager.getLogger(ValidateEntreePerimetreAction.class);
	
	private EntreePerimetreBean entreePerimetreBean;
	
	@Autowired
	private PerimetreManager perimetreManager;
    
    @Override
    public void validate() {
    	if(StringUtils.isEmpty(entreePerimetreBean.getDateSaisieForm())){
    		addActionError("La date de saisie est obligatoire.");
    		logger.error("Il y a une erreur ici !!!!!!!!!!!<<<<<<<<<<<<<");
    	}
    	if(!StringUtils.isEmpty(entreePerimetreBean.getNombreCreationForm())){
    		String nombreCreationForm = StringUtils.trim(StringUtils.replace(entreePerimetreBean.getNombreCreationForm(), " ", ""));
			if(!nombreCreationForm.matches("[0-9]+")){
				addActionError("Le nombre de création ne respecte pas le format requis (ex.: 25 | 125).");
			}
    	}
    	if(!StringUtils.isEmpty(entreePerimetreBean.getNombreRetourKOForm())){
    		String nombreNombreRetourKOForm = StringUtils.trim(StringUtils.replace(entreePerimetreBean.getNombreRetourKOForm(), " ", ""));
    		if(!nombreNombreRetourKOForm.matches("[0-9]+")){
    			addActionError("Le nombre de retour KO ne respecte pas le format requis (ex.: 25 | 125).");
    		}
    	}
    	if(!StringUtils.isEmpty(entreePerimetreBean.getNombreCorrectionForm())){
    		String nombreCorrectionForm = StringUtils.trim(StringUtils.replace(entreePerimetreBean.getNombreCorrectionForm(), " ", ""));
    		if(!nombreCorrectionForm.matches("[0-9]+")){
    			addActionError("Le nombre de correction ne respecte pas le format requis (ex.: 25 | 125).");
    		}
    	}
    	if(!StringUtils.isEmpty(entreePerimetreBean.getNombreClotureForm())){
    		String nombreClotureForm = StringUtils.trim(StringUtils.replace(entreePerimetreBean.getNombreClotureForm(), " ", ""));
    		if(!nombreClotureForm.matches("[0-9]+")){
    			addActionError("Le nombre de clôture ne respecte pas le format requis (ex.: 25 | 125).");
    		}
    	}
    	if(!StringUtils.isEmpty(entreePerimetreBean.getChargeTraitementForm())){
    		String chargeTraitementForm = StringUtils.trim(StringUtils.replace(entreePerimetreBean.getChargeTraitementForm(), " ", ""));
    		chargeTraitementForm = StringUtils.trim(StringUtils.replace(chargeTraitementForm, "j.h", ""));
    		chargeTraitementForm = StringUtils.trim(StringUtils.replace(chargeTraitementForm, ".", ","));
			if(!chargeTraitementForm.matches("[0-9]+(,[0-9]*)?")){
				addActionError("La charge de traitement ne respecte pas le format requis (ex.: 100 | 100.5 | 100,5 | 100 j.h | 100.5 j.h | 100,5 j.h).");
			}
    	}
    	if(!StringUtils.isEmpty(entreePerimetreBean.getChargeRecetteForm())){
    		String chargeRecetteForm = StringUtils.trim(StringUtils.replace(entreePerimetreBean.getChargeRecetteForm(), " ", ""));
    		chargeRecetteForm = StringUtils.trim(StringUtils.replace(chargeRecetteForm, "j.h", ""));
    		chargeRecetteForm = StringUtils.trim(StringUtils.replace(chargeRecetteForm, ".", ","));
    		if(!chargeRecetteForm.matches("[0-9]+(,[0-9]*)?")){
    			addActionError("La charge de recette ne respecte pas le format requis (ex.: 100 | 100.5 | 100,5 | 100 j.h | 100.5 j.h | 100,5 j.h).");
    		}
    	}
    	if(!StringUtils.isEmpty(entreePerimetreBean.getRafRecetteForm())){
    		String rafRecetteForm = StringUtils.trim(StringUtils.replace(entreePerimetreBean.getRafRecetteForm(), " ", ""));
    		rafRecetteForm = StringUtils.trim(StringUtils.replace(rafRecetteForm, "j.h", ""));
    		rafRecetteForm = StringUtils.trim(StringUtils.replace(rafRecetteForm, ".", ","));
    		if(!rafRecetteForm.matches("[0-9]+(,[0-9]*)?")){
    			addActionError("Le RAF de recette ne respecte pas le format requis (ex.: 100 | 100.5 | 100,5 | 100 j.h | 100.5 j.h | 100,5 j.h).");
    		}
    	}
    	super.saveActionErrorToSession();
    }
    
    public String execute() throws Exception {
    	perimetreManager.enregistrerEntreePerimetre(entreePerimetreBean);
        return SUCCESS;
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
    
}
