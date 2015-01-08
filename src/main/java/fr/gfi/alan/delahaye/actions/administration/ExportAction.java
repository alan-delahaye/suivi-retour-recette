/**
 * 
 */
package fr.gfi.alan.delahaye.actions.administration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;
import fr.gfi.alan.delahaye.edition.ExportExcel;

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
	
	private long idPerimetre;
	
	private String nomFichier;
	
	@Autowired
	private ExportExcel exportExcel;

	@Autowired
	private PerimetreManager perimetreManager;
	
	public String execute() throws Exception {
		super.init();
		logger.warn("Phase d'initialisation");
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		return SUCCESS;
	}
	
	public String dowloadFic() throws Exception {
		PerimetreBean bean = perimetreManager.recupererPerimetreComplet(idPerimetre);
		nomFichier = "Export " + bean.getNomPerimetre() +" - "+sdfEdition.format(new Date());
		OutputStream out= exportExcel.exporterPerimetre(idPerimetre);
		fileInputStream = new ByteArrayInputStream(((ByteArrayOutputStream)out).toByteArray());
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

	/**
	 * @return the idPerimetre
	 */
	public long getIdPerimetre() {
		return idPerimetre;
	}

	/**
	 * @param idPerimetre the idPerimetre to set
	 */
	public void setIdPerimetre(long idPerimetre) {
		this.idPerimetre = idPerimetre;
	}

	/**
	 * @return the nomFichier
	 */
	public String getNomFichier() {
		return nomFichier;
	}

	/**
	 * @param nomFichier the nomFichier to set
	 */
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
}
