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

import fr.gfi.alan.delahaye.beans.UtilisateurBean;

/**
 * 
 */
public class LoginAction extends ParentStructsAction {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 352261149790704498L;

	private String identifiant;
	
	private String motDePasse;
	
	public String execute() throws Exception {
		if(sessionMap != null){
			UtilisateurBean utilisateurBean = (UtilisateurBean) sessionMap.get("utilisateur");
			if(utilisateurBean != null){
				identifiant = utilisateurBean.getPrenom();
			}
		}
        return SUCCESS;
    }
	
	public String deconnexion() throws Exception {
		if(sessionMap != null){
			sessionMap.clear();
		}
        return SUCCESS;
    }

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
