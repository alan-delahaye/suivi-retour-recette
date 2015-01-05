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
package fr.gfi.alan.delahaye.actions;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.beans.UtilisateurBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;

public class ValidateLoginAction extends ParentStructsAction {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8947830421648562653L;

	private Logger logger = LogManager.getLogger(ValidateLoginAction.class);
	
    private String motDePasse;
    private String identifiant;
    
    private UtilisateurBean utilisateurBean;
    
    @Autowired
    private AdministrationManager administrationManager;
    
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public String getMotDePasse() { return motDePasse; }
   
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }
    public String getIdentifiant() { return this.identifiant; }
    
    @Override
    public void validate() {
    	logger.warn("Je suis dans le validate");
    	if(StringUtils.isEmpty(identifiant)){
    		addActionError("Le nom d'utilisateur est obligatoire.");
    	}
    	if(StringUtils.isEmpty(motDePasse)){
    		addActionError("Le mot de passe est obligatoire.");
    	}
    	 // Validation de l'utilisateur et du mot de passe :
    	if(!hasErrors()){
    		UtilisateurBean utilisateurBean = administrationManager.identifierUtilisateur(identifiant, motDePasse);
    		if(utilisateurBean == null){
    			addActionError("Le couple utilisateur/mot de passe n'est pas correct.");
    		}
    	}	
    }
    
    
    
    public String execute() throws Exception {
    	logger.warn("Phase d'initialisation");
    	utilisateurBean = administrationManager.identifierUtilisateur(identifiant, motDePasse);
    	sessionMap.put("utilisateur", utilisateurBean);
        return SUCCESS;
    }
    
	/**
	 * @return the utilisateurBean
	 */
	public UtilisateurBean getUtilisateurBean() {
		return utilisateurBean;
	}
	/**
	 * @param utilisateurBean the utilisateurBean to set
	 */
	public void setUtilisateurBean(UtilisateurBean utilisateurBean) {
		this.utilisateurBean = utilisateurBean;
	}
}
