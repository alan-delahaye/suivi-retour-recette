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
package fr.gfi.alan.delahaye.actions.tdb;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.conversion.annotations.Conversion;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.UtilisateurBean;

@Conversion()
public class DashboardAction extends ParentStructsAction {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8273807414373813773L;

	private Logger logger = LogManager.getLogger(DashboardAction.class);
	
    private UtilisateurBean utilisateurBean;
    
    private List<UtilisateurBean> tousLesUtilisateurs;
    
   public String execute() throws Exception {
    	logger.warn("Phase d'initialisation");
    	if(sessionMap.get("utilisateur") == null){
	    	return LOGIN;
    	}
    	//TODO:Récupération par un manager
    	tousLesUtilisateurs = new ArrayList<UtilisateurBean>();
    	UtilisateurBean bean = new UtilisateurBean("Defrance","Vincent","Chef de Projet");
    	tousLesUtilisateurs.add(bean);
    	bean = new UtilisateurBean("Delahaye","Alan","Responsable Intégration");
    	tousLesUtilisateurs.add(bean);
    	bean = new UtilisateurBean("Medjoudj","Abderezak","Responsable Développements");
    	tousLesUtilisateurs.add(bean);
    	bean = new UtilisateurBean("Collet","François","Responsable Recettes");
    	tousLesUtilisateurs.add(bean);
    	bean = new UtilisateurBean("Vion","Jean-François","Backup Resp. Intégration");
    	tousLesUtilisateurs.add(bean);
    	
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

	/**
	 * @return the tousLesUtilisateurs
	 */
	public List<UtilisateurBean> getTousLesUtilisateurs() {
		return tousLesUtilisateurs;
	}

	/**
	 * @param tousLesUtilisateurs the tousLesUtilisateurs to set
	 */
	public void setTousLesUtilisateurs(List<UtilisateurBean> tousLesUtilisateurs) {
		this.tousLesUtilisateurs = tousLesUtilisateurs;
	}
}
