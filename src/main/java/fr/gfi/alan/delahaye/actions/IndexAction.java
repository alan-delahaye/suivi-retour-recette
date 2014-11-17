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

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.gfi.alan.delahaye.beans.UtilisateurBean;

/**
 * 
 */
public class IndexAction extends ActionSupport implements SessionAware {
    
	private String identifiant;
	
	private String motDePasse;
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 352261149790704498L;

	private SessionMap<String, Object> sessionMap;
	
	public String execute() throws Exception {
		UtilisateurBean utilisateurBean = (UtilisateurBean) sessionMap.get("utilisateur");
		if(utilisateurBean != null){
			identifiant = utilisateurBean.getPrenom();
		}
        return SUCCESS;
    }

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = (SessionMap<String, Object>) arg0;
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
