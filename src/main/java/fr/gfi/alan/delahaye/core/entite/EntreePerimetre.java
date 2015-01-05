/**
 * 
 */
package fr.gfi.alan.delahaye.core.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author adelahaye
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="EntreePerimetre.getLesEntreeParIdPerimetre", query="select e from EntreePerimetre e where e.perimetre.idPerimetre = :idPerimetre"),
	@NamedQuery(name="EntreePerimetre.getLastEntreeParIdPerimetre", query="select e from EntreePerimetre e where e.perimetre.idPerimetre = :idPerimetre order by e.dateSaisie desc")
})
public class EntreePerimetre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEntreePerimetre;

	private Date dateSaisie;

	private int stockInitial;

	private int nombreCreation;

	private int nombreRetourKO;

	private int nombreCorrection;

	private int nombreCloture;

	private float chargeTraitement;
	
	private int stockFinal;
	
	private int variation;

	private float chargeRecette;
	
	private float rafRecette;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Perimetre perimetre;

	/**
	 * 
	 */
	public EntreePerimetre() {
		super();
	}

	/**
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
	public EntreePerimetre(Date dateSaisie, int stockInitial,
			int nombreCreation, int nombreRetourKO, int nombreCorrection,
			int nombreCloture, float chargeTraitement, int stockFinal,
			int variation, float chargeRecette, Perimetre perimetre) {
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
		this.perimetre = perimetre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntreePerimetre [idEntreePerimetre=");
		builder.append(idEntreePerimetre);
		builder.append(", ");
		if (dateSaisie != null) {
			builder.append("dateSaisie=");
			builder.append(dateSaisie);
			builder.append(", ");
		}
		builder.append("stockInitial=");
		builder.append(stockInitial);
		builder.append(" anomalie(s), nombreCreation=");
		builder.append(nombreCreation);
		builder.append(" anomalie(s), nombreRetourKO=");
		builder.append(nombreRetourKO);
		builder.append(" anomalie(s), nombreCorrection=");
		builder.append(nombreCorrection);
		builder.append(" anomalie(s), nombreCloture=");
		builder.append(nombreCloture);
		builder.append(" anomalie(s), chargeTraitement=");
		builder.append(chargeTraitement);
		builder.append(" j.h, stockFinal=");
		builder.append(stockFinal);
		builder.append(" anomalie(s), variation=");
		builder.append(variation);
		builder.append(" anomalie(s), chargeRecette=");
		builder.append(chargeRecette);
		builder.append(" j.h, ");
		builder.append(perimetre);
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
	 * @return the perimetre
	 */
	public Perimetre getPerimetre() {
		return perimetre;
	}

	/**
	 * @param perimetre the perimetre to set
	 */
	public void setPerimetre(Perimetre perimetre) {
		this.perimetre = perimetre;
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
}
