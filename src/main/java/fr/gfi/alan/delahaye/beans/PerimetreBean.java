/**
 * 
 */
package fr.gfi.alan.delahaye.beans;

import java.io.Serializable;

/**
 * @author adelahaye
 *
 */
public class PerimetreBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5813716829636720633L;
	
	private String nomPerimetre;

	public PerimetreBean() {
		super();
	}

	/**
	 * @param nomPerimetre
	 */
	public PerimetreBean(String nomPerimetre) {
		this.nomPerimetre = nomPerimetre;
	}


	/**
	 * @return the nomPerimetre
	 */
	public String getNomPerimetre() {
		return nomPerimetre;
	}

	/**
	 * @param nomPerimetre the nomPerimetre to set
	 */
	public void setNomPerimetre(String nomPerimetre) {
		this.nomPerimetre = nomPerimetre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Périmètre [");
		builder.append(nomPerimetre);
		builder.append("]");
		return builder.toString();
	}
}
