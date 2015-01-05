/**
 * 
 */
package fr.gfi.alan.delahaye.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author adelahaye
 *
 */
public class EntreePerimetreBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2121515529246739459L;

	private long idEntreePerimetre;
	
	private Date dateSaisie;
	
	private String dateSaisieForm;

	private int stockInitial;

	private int nombreCreation;

	private String nombreCreationForm;

	private int nombreRetourKO;

	private String nombreRetourKOForm;

	private int nombreCorrection;

	private String nombreCorrectionForm;

	private int nombreCloture;

	private String nombreClotureForm;

	private float chargeTraitement;

	private String chargeTraitementForm;
	
	private float rafRecette;
	
	private String rafRecetteForm;
	
	private int stockFinal;
	
	private int variation;

	private String variationForm;

	private float chargeRecette;

	private String chargeRecetteForm;
	
	private long idPerimetreForm;
	
	/**
	 * 
	 */
	public EntreePerimetreBean() {
		super();
	}

	/**
	 * @param idEntreePerimetre
	 * @param dateSaisie
	 * @param stockInitial
	 * @param nombreCreation
	 * @param nombreRetourKO
	 * @param nombreCorrection
	 * @param nombreCloture
	 * @param chargeTraitement
	 * @param stockFinal
	 * @param variation
	 * @param chargeRecette
	 */
	public EntreePerimetreBean(long idEntreePerimetre, Date dateSaisie,
			int stockInitial, int nombreCreation, int nombreRetourKO,
			int nombreCorrection, int nombreCloture, float chargeTraitement,
			int stockFinal, int variation, float chargeRecette) {
		this.idEntreePerimetre = idEntreePerimetre;
		this.dateSaisie = dateSaisie;
		this.stockInitial = stockInitial;
		this.nombreCreation = nombreCreation;
		this.nombreRetourKO = nombreRetourKO;
		this.nombreCorrection = nombreCorrection;
		this.nombreCloture = nombreCloture;
		this.chargeTraitement = chargeTraitement;
		this.stockFinal = stockFinal;
		this.variation = variation;
		this.chargeRecette = chargeRecette;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntreePerimetreBean [idEntreePerimetre=");
		builder.append(idEntreePerimetre);
		builder.append(", ");
		if (dateSaisie != null) {
			builder.append("dateSaisie=");
			builder.append(dateSaisie);
			builder.append(", ");
		}
		builder.append("stockInitial=");
		builder.append(stockInitial);
		builder.append(", nombreCreation=");
		builder.append(nombreCreation);
		builder.append(", nombreRetourKO=");
		builder.append(nombreRetourKO);
		builder.append(", nombreCorrection=");
		builder.append(nombreCorrection);
		builder.append(", nombreCloture=");
		builder.append(nombreCloture);
		builder.append(", chargeTraitement=");
		builder.append(chargeTraitement);
		builder.append(", stockFinal=");
		builder.append(stockFinal);
		builder.append(", variation=");
		builder.append(variation);
		builder.append(", chargeRecette=");
		builder.append(chargeRecette);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the idEntreePerimetre
	 */
	public long getIdEntreePerimetre() {
		return idEntreePerimetre;
	}

	/**
	 * @param idEntreePerimetre the idEntreePerimetre to set
	 */
	public void setIdEntreePerimetre(long idEntreePerimetre) {
		this.idEntreePerimetre = idEntreePerimetre;
	}

	/**
	 * @return the dateSaisie
	 */
	public Date getDateSaisie() {
		return dateSaisie;
	}

	/**
	 * @param dateSaisie the dateSaisie to set
	 */
	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	/**
	 * @return the stockInitial
	 */
	public int getStockInitial() {
		return stockInitial;
	}

	/**
	 * @param stockInitial the stockInitial to set
	 */
	public void setStockInitial(int stockInitial) {
		this.stockInitial = stockInitial;
	}

	/**
	 * @return the nombreCreation
	 */
	public int getNombreCreation() {
		return nombreCreation;
	}

	/**
	 * @param nombreCreation the nombreCreation to set
	 */
	public void setNombreCreation(int nombreCreation) {
		this.nombreCreation = nombreCreation;
	}

	/**
	 * @return the nombreRetourKO
	 */
	public int getNombreRetourKO() {
		return nombreRetourKO;
	}

	/**
	 * @param nombreRetourKO the nombreRetourKO to set
	 */
	public void setNombreRetourKO(int nombreRetourKO) {
		this.nombreRetourKO = nombreRetourKO;
	}

	/**
	 * @return the nombreCorrection
	 */
	public int getNombreCorrection() {
		return nombreCorrection;
	}

	/**
	 * @param nombreCorrection the nombreCorrection to set
	 */
	public void setNombreCorrection(int nombreCorrection) {
		this.nombreCorrection = nombreCorrection;
	}

	/**
	 * @return the nombreCloture
	 */
	public int getNombreCloture() {
		return nombreCloture;
	}

	/**
	 * @param nombreCloture the nombreCloture to set
	 */
	public void setNombreCloture(int nombreCloture) {
		this.nombreCloture = nombreCloture;
	}

	/**
	 * @return the chargeTraitement
	 */
	public float getChargeTraitement() {
		return chargeTraitement;
	}

	/**
	 * @param chargeTraitement the chargeTraitement to set
	 */
	public void setChargeTraitement(float chargeTraitement) {
		this.chargeTraitement = chargeTraitement;
	}

	/**
	 * @return the stockFinal
	 */
	public int getStockFinal() {
		return stockFinal;
	}

	/**
	 * @param stockFinal the stockFinal to set
	 */
	public void setStockFinal(int stockFinal) {
		this.stockFinal = stockFinal;
	}

	/**
	 * @return the variation
	 */
	public int getVariation() {
		return variation;
	}

	/**
	 * @param variation the variation to set
	 */
	public void setVariation(int variation) {
		this.variation = variation;
	}

	/**
	 * @return the chargeRecette
	 */
	public float getChargeRecette() {
		return chargeRecette;
	}

	/**
	 * @param chargeRecette the chargeRecette to set
	 */
	public void setChargeRecette(float chargeRecette) {
		this.chargeRecette = chargeRecette;
	}

	/**
	 * @return the dateSaisieForm
	 */
	public String getDateSaisieForm() {
		return dateSaisieForm;
	}

	/**
	 * @param dateSaisieForm the dateSaisieForm to set
	 */
	public void setDateSaisieForm(String dateSaisieForm) {
		this.dateSaisieForm = dateSaisieForm;
	}

	/**
	 * @return the nombreCreationForm
	 */
	public String getNombreCreationForm() {
		return nombreCreationForm;
	}

	/**
	 * @param nombreCreationForm the nombreCreationForm to set
	 */
	public void setNombreCreationForm(String nombreCreationForm) {
		this.nombreCreationForm = nombreCreationForm;
	}

	/**
	 * @return the nombreRetourKOForm
	 */
	public String getNombreRetourKOForm() {
		return nombreRetourKOForm;
	}

	/**
	 * @param nombreRetourKOForm the nombreRetourKOForm to set
	 */
	public void setNombreRetourKOForm(String nombreRetourKOForm) {
		this.nombreRetourKOForm = nombreRetourKOForm;
	}

	/**
	 * @return the nombreCorrectionForm
	 */
	public String getNombreCorrectionForm() {
		return nombreCorrectionForm;
	}

	/**
	 * @param nombreCorrectionForm the nombreCorrectionForm to set
	 */
	public void setNombreCorrectionForm(String nombreCorrectionForm) {
		this.nombreCorrectionForm = nombreCorrectionForm;
	}

	/**
	 * @return the nombreClotureForm
	 */
	public String getNombreClotureForm() {
		return nombreClotureForm;
	}

	/**
	 * @param nombreClotureForm the nombreClotureForm to set
	 */
	public void setNombreClotureForm(String nombreClotureForm) {
		this.nombreClotureForm = nombreClotureForm;
	}

	/**
	 * @return the chargeTraitementForm
	 */
	public String getChargeTraitementForm() {
		return chargeTraitementForm;
	}

	/**
	 * @param chargeTraitementForm the chargeTraitementForm to set
	 */
	public void setChargeTraitementForm(String chargeTraitementForm) {
		this.chargeTraitementForm = chargeTraitementForm;
	}

	/**
	 * @return the variationForm
	 */
	public String getVariationForm() {
		return variationForm;
	}

	/**
	 * @param variationForm the variationForm to set
	 */
	public void setVariationForm(String variationForm) {
		this.variationForm = variationForm;
	}

	/**
	 * @return the chargeRecetteForm
	 */
	public String getChargeRecetteForm() {
		return chargeRecetteForm;
	}

	/**
	 * @param chargeRecetteForm the chargeRecetteForm to set
	 */
	public void setChargeRecetteForm(String chargeRecetteForm) {
		this.chargeRecetteForm = chargeRecetteForm;
	}

	/**
	 * @return the idPerimetreForm
	 */
	public long getIdPerimetreForm() {
		return idPerimetreForm;
	}

	/**
	 * @param idPerimetreForm the idPerimetreForm to set
	 */
	public void setIdPerimetreForm(long idPerimetreForm) {
		this.idPerimetreForm = idPerimetreForm;
	}

	/**
	 * @return the rafRecette
	 */
	public float getRafRecette() {
		return rafRecette;
	}

	/**
	 * @param rafRecette the rafRecette to set
	 */
	public void setRafRecette(float rafRecette) {
		this.rafRecette = rafRecette;
	}

	/**
	 * @return the rafRecetteForm
	 */
	public String getRafRecetteForm() {
		return rafRecetteForm;
	}

	/**
	 * @param rafRecetteForm the rafRecetteForm to set
	 */
	public void setRafRecetteForm(String rafRecetteForm) {
		this.rafRecetteForm = rafRecetteForm;
	}

}
