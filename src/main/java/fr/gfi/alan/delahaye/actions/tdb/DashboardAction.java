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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.conversion.annotations.Conversion;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;

@Conversion()
public class DashboardAction extends ParentStructsAction {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8273807414373813773L;

	private Logger logger = LogManager.getLogger(DashboardAction.class);
	
   public String execute() throws Exception {
	   	super.init();
    	logger.warn("Phase d'initialisation");
    	if(getUtilisateurBean() == null){
	    	return LOGIN;
    	}
        return SUCCESS;
    }
}
