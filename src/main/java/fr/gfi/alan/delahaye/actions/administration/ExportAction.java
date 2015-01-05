/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;

/**
 * @author adelahaye
 *
 */
public class ExportAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3413760816959724533L;

	private Logger logger = LogManager.getLogger(AdministrationAction.class);

	private InputStream fileInputStream;
	
	public String execute() throws Exception {
		super.init();
		logger.warn("Phase d'initialisation");
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		fileInputStream = new FileInputStream(new File("C:\\fics\\ui-danro.jpg"));
		
		return SUCCESS;
	}

	/**
	 * @return the fileInputStream
	 */
	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	/**
	 * @param fileInputStream the fileInputStream to set
	 */
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
}
