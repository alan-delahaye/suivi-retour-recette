/**
 * 
 */
package fr.gfi.alan.delahaye.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author adelahaye
 *
 */
public class PerimetreBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5813716829636720633L;
	
	private long idPerimetre;
	
	/**
	 * Nom du périmètre
	 */
	private String nomPerimetre;
	
	/**
	 * Charge initiale de développement du périmètre
	 */
	private float chargeInitDeveloppement;
	
	/**
	 * Charge initiale de développement du périmètre (entrée formulaire)
	 */
	private String chargeInitDeveloppementForm;
	
	/**
	 * Ratio de calcul du nombre de jours de retour sur recette
	 */
	private int ratioDevRetourRecette;
	
	/**
	 * Ratio de calcul du nombre de jours de retour sur recette (entrée formulaire)
	 */
	private String ratioDevRetourRecetteForm;
	
	/**
	 * Charge calculé de retour sur recette (calculé)
	 */
	private float chargeRetourRecette;
	
	/**
	 * Ratio de nombre d'anomalies par jour de développement toléré.  (entrée formulaire)
	 */
	private String ratioDevAnomalieForm;
	
	/**
	 * Ratio de nombre d'anomalies par jour de développement toléré.
	 */
	private int ratioDevAnomalie;
	
	/**
	 * Charge initiale de passage de la recette du périmètre
	 */
	private float chargePassageRecette;
	
	/**
	 * Charge initiale de passage de la recette du périmètre (entrée formulaire)
	 */
	private String chargePassageRecetteForm;
	
	private UtilisateurBean utilisateurPrincipalEnCharge;
	
	private List<EntreePerimetreBean> contenu;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private int avancement;
	
	private float rafPassage;
	
	private int nombreAnoTotal;
	
	private int nombreAnoCorrigee;
	
	private int nombreAnoSansRegul;
	
	private float nombreTotalConsoTraitement;

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
	 * @return the chargeInitDeveloppementForm
	 */
	public String getChargeInitDeveloppementForm() {
		return chargeInitDeveloppementForm;
	}

	/**
	 * @param chargeInitDeveloppementForm the chargeInitDeveloppementForm to set
	 */
	public void setChargeInitDeveloppementForm(String chargeInitDeveloppementForm) {
		this.chargeInitDeveloppementForm = chargeInitDeveloppementForm;
	}

	/**
	 * @return the ratioDevRetourRecetteForm
	 */
	public String getRatioDevRetourRecetteForm() {
		return ratioDevRetourRecetteForm;
	}

	/**
	 * @param ratioDevRetourRecetteForm the ratioDevRetourRecetteForm to set
	 */
	public void setRatioDevRetourRecetteForm(String ratioDevRetourRecetteForm) {
		this.ratioDevRetourRecetteForm = ratioDevRetourRecetteForm;
	}

	/**
	 * @return the ratioDevAnomalieForm
	 */
	public String getRatioDevAnomalieForm() {
		return ratioDevAnomalieForm;
	}

	/**
	 * @param ratioDevAnomalieForm the ratioDevAnomalieForm to set
	 */
	public void setRatioDevAnomalieForm(String ratioDevAnomalieForm) {
		this.ratioDevAnomalieForm = ratioDevAnomalieForm;
	}

	/**
	 * @return the utilisateurPrincipalEnCharge
	 */
	public UtilisateurBean getUtilisateurPrincipalEnCharge() {
		return utilisateurPrincipalEnCharge;
	}

	/**
	 * @param utilisateurPrincipalEnCharge the utilisateurPrincipalEnCharge to set
	 */
	public void setUtilisateurPrincipalEnCharge(
			UtilisateurBean utilisateurPrincipalEnCharge) {
		this.utilisateurPrincipalEnCharge = utilisateurPrincipalEnCharge;
	}

	/**
	 * @return the contenu
	 */
	public List<EntreePerimetreBean> getContenu() {
		return contenu;
	}

	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(List<EntreePerimetreBean> contenu) {
		this.contenu = contenu;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the avancement
	 */
	public int getAvancement() {
		return avancement;
	}

	/**
	 * @param avancement the avancement to set
	 */
	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

	/**
	 * @return the chargePassageRecette
	 */
	public float getChargePassageRecette() {
		return chargePassageRecette;
	}

	/**
	 * @param chargePassageRecette the chargePassageRecette to set
	 */
	public void setChargePassageRecette(float chargePassageRecette) {
		this.chargePassageRecette = chargePassageRecette;
	}

	/**
	 * @return the chargePassageRecetteForm
	 */
	public String getChargePassageRecetteForm() {
		return chargePassageRecetteForm;
	}

	/**
	 * @param chargePassageRecetteForm the chargePassageRecetteForm to set
	 */
	public void setChargePassageRecetteForm(String chargePassageRecetteForm) {
		this.chargePassageRecetteForm = chargePassageRecetteForm;
	}

	/**
	 * @return the rafPassage
	 */
	public float getRafPassage() {
		return rafPassage;
	}

	/**
	 * @param rafPassage the rafPassage to set
	 */
	public void setRafPassage(float rafPassage) {
		this.rafPassage = rafPassage;
	}

	/**
	 * @return the nombreAnoTotal
	 */
	public int getNombreAnoTotal() {
		return nombreAnoTotal;
	}

	/**
	 * @param nombreAnoTotal the nombreAnoTotal to set
	 */
	public void setNombreAnoTotal(int nombreAnoTotal) {
		this.nombreAnoTotal = nombreAnoTotal;
	}

	/**
	 * @return the nombreAnoCorrigee
	 */
	public int getNombreAnoCorrigee() {
		return nombreAnoCorrigee;
	}

	/**
	 * @param nombreAnoCorrigee the nombreAnoCorrigee to set
	 */
	public void setNombreAnoCorrigee(int nombreAnoCorrigee) {
		this.nombreAnoCorrigee = nombreAnoCorrigee;
	}

	/**
	 * @return the nombreAnoSansRegul
	 */
	public int getNombreAnoSansRegul() {
		return nombreAnoSansRegul;
	}

	/**
	 * @param nombreAnoSansRegul the nombreAnoSansRegul to set
	 */
	public void setNombreAnoSansRegul(int nombreAnoSansRegul) {
		this.nombreAnoSansRegul = nombreAnoSansRegul;
	}

	/**
	 * @return the nombreTotalConsoTraitement
	 */
	public float getNombreTotalConsoTraitement() {
		return nombreTotalConsoTraitement;
	}

	/**
	 * @param nombreTotalConsoTraitement the nombreTotalConsoTraitement to set
	 */
	public void setNombreTotalConsoTraitement(float nombreTotalConsoTraitement) {
		this.nombreTotalConsoTraitement = nombreTotalConsoTraitement;
	}
}
