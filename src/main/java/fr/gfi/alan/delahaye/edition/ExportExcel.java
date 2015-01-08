/**
 * 
 */
package fr.gfi.alan.delahaye.edition;

import java.io.OutputStream;

/**
 * @author adelahaye
 *
 */
public interface ExportExcel {

	OutputStream exporterPerimetre(long idPerimetre);
	
}
