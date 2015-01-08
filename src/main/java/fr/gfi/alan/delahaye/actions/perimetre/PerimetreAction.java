/**
 * 
 */
package fr.gfi.alan.delahaye.actions.perimetre;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gfi.alan.delahaye.actions.ParentStructsAction;
import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.manager.AdministrationManager;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;
import fr.gfi.alan.delahaye.utils.FloatUtils;

/**
 * @author adelahaye
 *
 */
public class PerimetreAction extends ParentStructsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8869473766917398137L;

	private Logger logger = LogManager.getLogger(PerimetreAction.class);
	
	@Autowired
	private AdministrationManager administrationManager;
	
	@Autowired
	private PerimetreManager perimetreManager;

	private List<PerimetreBean> lesPerimetre;
	
	private long idPerimetre;
	
	private PerimetreBean perimetreBean;
	
	private EntreePerimetreBean entreePerimetreBean;
	
	private float cumulConso;
	
	private float cumulPassage;
	
	private float tempsMoyenTraitement;
	
	private float rafImmediat;
	
	private float nombreMoyenCreation;

	private float rafProjection;

	private float variation;
	
	private int ratio;
	
	public String execute() throws Exception {
		super.init();
		logger.warn("Phase d'initialisation PerimetreAction [idPerimetre "+idPerimetre+"][EntreePerimetre "+entreePerimetreBean+"]");
		if (getUtilisateurBean() == null) {
			return LOGIN;
		}
		lesPerimetre = administrationManager.recupererTousLesPerimetres();
		if(idPerimetre > 0){
			perimetreBean = perimetreManager.recupererPerimetreComplet(idPerimetre);
			logger.warn("perimetre id " + perimetreBean.getContenu());
		} else if(entreePerimetreBean != null){
			perimetreBean = perimetreManager.recupererPerimetreComplet(entreePerimetreBean.getIdPerimetreForm());
			logger.warn("perimetre bean"  + perimetreBean.getContenu());
		}
		if(perimetreBean != null){
			calculerDonnees();
		}
		return SUCCESS;
	}

	private void calculerDonnees() {
		cumulConso = 0;
		cumulPassage = 0;
		
		if( perimetreBean.getContenu() != null){
			for(EntreePerimetreBean bean : perimetreBean.getContenu()){
				cumulConso = cumulConso + bean.getChargeTraitement();
				cumulPassage = cumulPassage + bean.getChargeRecette();
			}
		}
		tempsMoyenTraitement = perimetreBean.getNombreAnoCorrigee() / cumulConso;
		logger.warn("Temps Moyen de traitement = " + perimetreBean.getNombreAnoCorrigee() + "/" + cumulConso + " = " + tempsMoyenTraitement);
		
		rafImmediat = (perimetreBean.getNombreAnoTotal() - perimetreBean.getNombreAnoCorrigee()) / tempsMoyenTraitement;
		logger.warn("RAF immediat = " +"("+perimetreBean.getNombreAnoTotal() +"-"+ perimetreBean.getNombreAnoCorrigee()+") / "+tempsMoyenTraitement + " = "+ rafImmediat);
		
		nombreMoyenCreation = perimetreBean.getNombreAnoTotal() / cumulPassage;
		logger.warn("Nombre moyen création = " + perimetreBean.getNombreAnoTotal() +"/"+ cumulPassage + " = " + nombreMoyenCreation);
		
		float anomaliesAVenir = perimetreBean.getRafPassage() * nombreMoyenCreation;
		logger.warn("Nombre anomalies à venir = " + perimetreBean.getRafPassage() +"*"+ nombreMoyenCreation + " = " + anomaliesAVenir);
		
		rafProjection = ((perimetreBean.getNombreAnoTotal() - perimetreBean.getNombreAnoCorrigee()) + anomaliesAVenir) / tempsMoyenTraitement;
		logger.warn("Raf Projection = " + "((" + perimetreBean.getNombreAnoTotal() + "-" + perimetreBean.getNombreAnoCorrigee() + ") +" + anomaliesAVenir + ")" + "/" + tempsMoyenTraitement + " = " +rafProjection);
		
		variation = (cumulConso + rafProjection) - perimetreBean.getChargeRetourRecette();
		
		ratio = (int) ((perimetreBean.getNombreAnoTotal() * 100) / perimetreBean.getChargeInitDeveloppement());
		logger.warn("Ratio = "+"(("+perimetreBean.getNombreAnoTotal() +"* 100) / "+perimetreBean.getChargeInitDeveloppement()+") = "+ratio);
	}

	/**
	 * @return the lesPerimetre
	 */
	public List<PerimetreBean> getLesPerimetre() {
		return lesPerimetre;
	}

	/**
	 * @param lesPerimetre the lesPerimetre to set
	 */
	public void setLesPerimetre(List<PerimetreBean> lesPerimetre) {
		this.lesPerimetre = lesPerimetre;
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
	 * @return the perimetreBean
	 */
	public PerimetreBean getPerimetreBean() {
		return perimetreBean;
	}

	/**
	 * @param perimetreBean the perimetreBean to set
	 */
	public void setPerimetreBean(PerimetreBean perimetreBean) {
		this.perimetreBean = perimetreBean;
	}

	/**
	 * @return the entreePerimetreBean
	 */
	public EntreePerimetreBean getEntreePerimetreBean() {
		return entreePerimetreBean;
	}

	/**
	 * @param entreePerimetreBean the entreePerimetreBean to set
	 */
	public void setEntreePerimetreBean(EntreePerimetreBean entreePerimetreBean) {
		this.entreePerimetreBean = entreePerimetreBean;
	}
	
	public String getXKeyTendanceJournaliere(){
		return "'date'";
	}
	
	public String getYKeysTendanceJournaliere(){
		return "['creation', 'correction', 'retourKO', 'cloture']";
	}
	
	public String getLabelsTendanceJournaliere(){
		return "['Création', 'Correction', 'Retour KO', 'Clôture']";
	}
	
	public String getLineColorsTendanceJournaliere(){
		return "['#4a8bc2', '#a9d86e', '#ff6c60', '#EA46EA']";
	}
	
	public String getDonneesTendanceJournaliere(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		if(perimetreBean != null){
			for(EntreePerimetreBean bean : perimetreBean.getContenu()){
				if(stringBuilder.length() > 1){
					stringBuilder.append(",");
				}
				stringBuilder.append(addDataGrapheTendanceJournaliere(bean));
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	private String addDataGrapheTendanceJournaliere(EntreePerimetreBean entreePerimetre){
		// Exemple : {date: '2010 Q1', creation: 2666, correction: null, retourKO: 2647, cloture: 0}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		stringBuilder.append("date: '");
		stringBuilder.append(sdfGraphe.format(entreePerimetre.getDateSaisie()));
		stringBuilder.append("', ");
		stringBuilder.append("creation: ");
		stringBuilder.append(entreePerimetre.getNombreCreation());
		stringBuilder.append(", ");
		stringBuilder.append("correction: ");
		stringBuilder.append(entreePerimetre.getNombreCorrection());
		stringBuilder.append(", ");
		stringBuilder.append("retourKO: ");
		stringBuilder.append(entreePerimetre.getNombreRetourKO());
		stringBuilder.append(", ");
		stringBuilder.append("cloture: ");
		stringBuilder.append(entreePerimetre.getNombreCloture());
		stringBuilder.append("}");
		
		return stringBuilder.toString();
	}
	
	public String getXKeyEvolutionCharge(){
		return "'date'";
	}
	
	public String getYKeysEvolutionCharge(){
		return "['initiale', 'consommee']";
	}
	
	public String getLabelsEvolutionCharge(){
		return "['Charge initiale', 'Charge consommée']";
	}
	
	public String getLineColorsEvolutionCharge(){
		return "['#ff6c60','#4a8bc2']";
	}
	
	public String getDonneesEvolutionCharge(){
		float cumulConso = 0;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		if(perimetreBean != null){
			for(EntreePerimetreBean bean : perimetreBean.getContenu()){
				if(stringBuilder.length() > 1){
					stringBuilder.append(",");
				}
				cumulConso = cumulConso + bean.getChargeTraitement();
				stringBuilder.append("{");
				stringBuilder.append("date: '");
				stringBuilder.append(sdfGraphe.format(bean.getDateSaisie()));
				stringBuilder.append("', ");
				stringBuilder.append("initiale: ");
				stringBuilder.append(perimetreBean.getChargeRetourRecette());
				stringBuilder.append(", ");
				stringBuilder.append("consommee: ");
				stringBuilder.append(cumulConso);
				stringBuilder.append("}");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	public String getRafImmediat(){
		return Float.toString(FloatUtils.arrondir(rafImmediat));
	}
	
	public String getRafProjection(){
		return Float.toString(FloatUtils.arrondir(rafProjection));
	}
	
	public String getVariationCharge(){
		return Float.toString(FloatUtils.arrondir(variation));
	}
	
	public String getNombreMoyenTraitement(){
		return Float.toString(FloatUtils.arrondir(tempsMoyenTraitement));
	}

	public String getNombreMoyenCreation(){
		return Float.toString(FloatUtils.arrondir(nombreMoyenCreation));
	}
	
	public String getRatioDevAnomalie(){
		return Integer.toString(ratio);
	}
}
