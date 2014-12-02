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
	
	/**
	 * Nom du périmètre
	 */
	private String nomPerimetre;
	
	/**
	 * Charge initiale de développement du périmètre
	 */
	private float chargeInitDeveloppement;
	
	/**
	 * Ratio de calcul du nombre de jours de retour sur recette
	 */
	private int ratioDevRetourRecette;
	
	/**
	 * Charge calculé de retour sur recette
	 */
	private float chargeRetourRecette;
	
	/**
	 * Ratio de nombre d'anomalies par jour de développement toléré.
	 */
	private int ratioDevAnomalie;

	public PerimetreBean() {
		super();
	}

	/**
	 * @param nomPerimetre
	 * @param chargeInitDeveloppement
	 * @param ratioDevRetourRecette
	 * @param chargeRetourRecette
	 * @param ratioDevAnomalie
	 */
	public PerimetreBean(String nomPerimetre, float chargeInitDeveloppement,
			int ratioDevRetourRecette, float chargeRetourRecette,
			int ratioDevAnomalie) {
		this.nomPerimetre = nomPerimetre;
		this.chargeInitDeveloppement = chargeInitDeveloppement;
		this.ratioDevRetourRecette = ratioDevRetourRecette;
		this.chargeRetourRecette = chargeRetourRecette;
		this.ratioDevAnomalie = ratioDevAnomalie;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Périmètre [");
		builder.append(nomPerimetre);
		builder.append(" - ");
		builder.append(chargeInitDeveloppement);
		builder.append("j.h - ");
		builder.append(ratioDevRetourRecette);
		builder.append("% - ");
		builder.append(chargeRetourRecette);
		builder.append("j.h - ");
		builder.append(ratioDevAnomalie);
		builder.append("%");
		builder.append("]");
		return builder.toString();
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

	/**
	 * @return the chargeInitDeveloppement
	 */
	public float getChargeInitDeveloppement() {
		return chargeInitDeveloppement;
	}

	/**
	 * @param chargeInitDeveloppement the chargeInitDeveloppement to set
	 */
	public void setChargeInitDeveloppement(float chargeInitDeveloppement) {
		this.chargeInitDeveloppement = chargeInitDeveloppement;
	}

	/**
	 * @return the ratioDevRetourRecette
	 */
	public int getRatioDevRetourRecette() {
		return ratioDevRetourRecette;
	}

	/**
	 * @param ratioDevRetourRecette the ratioDevRetourRecette to set
	 */
	public void setRatioDevRetourRecette(int ratioDevRetourRecette) {
		this.ratioDevRetourRecette = ratioDevRetourRecette;
	}

	/**
	 * @return the chargeRetourRecette
	 */
	public float getChargeRetourRecette() {
		return chargeRetourRecette;
	}

	/**
	 * @param chargeRetourRecette the chargeRetourRecette to set
	 */
	public void setChargeRetourRecette(float chargeRetourRecette) {
		this.chargeRetourRecette = chargeRetourRecette;
	}

	/**
	 * @return the ratioDevAnomalie
	 */
	public int getRatioDevAnomalie() {
		return ratioDevAnomalie;
	}

	/**
	 * @param ratioDevAnomalie the ratioDevAnomalie to set
	 */
	public void setRatioDevAnomalie(int ratioDevAnomalie) {
		this.ratioDevAnomalie = ratioDevAnomalie;
	}
}
