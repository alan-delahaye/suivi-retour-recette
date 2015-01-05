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
import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;

public class ValidateUtilisateurAction extends ParentStructsAction {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8947830421648562653L;

	private Logger logger = LogManager.getLogger(ValidateUtilisateurAction.class);
	
	private UtilisateurBean utilisateur;
	
	@Autowired
	private AdministrationManager administrationManager;
    
    @Override
    public void validate() {
    	if(StringUtils.isEmpty(utilisateur.getNom())){
    		addActionError("Le nom de l'utilisateur est obligatoire.");
    	}
		if(StringUtils.isEmpty(utilisateur.getPrenom())){
			addActionError("Le prénom de l'utilisateur est obligatoire.");
		}
		if(StringUtils.isEmpty(utilisateur.getFonction())){
			addActionError("La fonction de l'utilisateur est obligatoire.");
		}
		if(StringUtils.isEmpty(utilisateur.getAdresseMail())){
			addActionError("L'adresse mail de l'utilisateur est obligatoire.");
		}
    	if(StringUtils.isEmpty(utilisateur.getNumeroTelephone())){
    		addActionError("Le numéro de téléphone de l'utilisateur est obligatoire.");
    	}
    	if(StringUtils.isEmpty(utilisateur.getMdp1()) || StringUtils.isEmpty(utilisateur.getMdp2())){
    		if(!(utilisateur.getIdUtilisateur() > 0)) {
    			addActionError("Le mot de passe l'utilisateur est obligatoire.");
    		}
    	}
    	if(StringUtils.isNotEmpty(utilisateur.getMdp1())
    			&& StringUtils.isNotEmpty(utilisateur.getMdp2())
    			&& !utilisateur.getMdp1().equals(utilisateur.getMdp2())){
    		addActionError("Les mots de passe saisies sont différents.");
    	}
    	super.saveActionErrorToSession();
    }
    
    public String execute() throws Exception {
    	administrationManager.enregistrerUtilisateur(utilisateur);
        return getProvenance();
    }
    
	/**
	 * @return the utilisateurBean
	 */
	public UtilisateurBean getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateurBean the utilisateurBean to set
	 */
	public void setUtilisateur(UtilisateurBean utilisateur) {
		this.utilisateur = utilisateur;
	}
}
