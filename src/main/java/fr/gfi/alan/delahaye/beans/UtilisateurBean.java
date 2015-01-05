/**
 * 
 */
package fr.gfi.alan.delahaye.beans;

import java.io.Serializable;

/**
 *	Bean représentant un utilisateur de l'application 
 * 
 * @author alandelahaye
 */
public class UtilisateurBean implements Serializable {

	/**
	 * Numéro de version auto généré
	 */
	private static final long serialVersionUID = 1610290526088335208L;

	private long idUtilisateur;
	
	/**
	 * Nom de l'utilisateur
	 */
	private String nom;
	
	/**
	 * Prénom de l'utilisateur
	 */
	private String prenom;
	
	/**
	 * Adresse mail de l'utilisateur
	 */
	private String adresseMail;
	
	/**
	 * Fonction de l'utilisateur
	 */
	private String fonction;
	
	/**
	 * Numero de téléphone de l'utilisateur
	 */
	private String numeroTelephone;
	
	private String identifiant;
	
	private String imageAvatar;
	
	/**
	 * Premier mot de passe du formulaire
	 */
	private String mdp1;
	
	/**
	 * second mot de passe du formulaire (pour vérification)
	 */
	private String mdp2;
	
	public UtilisateurBean() {
		super();
	}
	
	public UtilisateurBean(String nom, String prenom, String adresseMail, String fonction, String numeroTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.fonction = fonction;
		this.numeroTelephone = numeroTelephone;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("UtilisateurBean :  [");
		stringBuilder.append(nom);
		stringBuilder.append(" ");
		stringBuilder.append(prenom);
		stringBuilder.append(" - ");
		stringBuilder.append(fonction);
		stringBuilder.append("][@ ");
		stringBuilder.append(adresseMail);
		stringBuilder.append("][Tél. ");
		stringBuilder.append(numeroTelephone);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the adresseMail
	 */
	public String getAdresseMail() {
		return adresseMail;
	}
	/**
	 * @param adresseMail the adresseMail to set
	 */
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	

	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * @param fonction the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * @return the numeroTelephone
	 */
	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	/**
	 * @param numeroTelephone the numeroTelephone to set
	 */
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	/**
	 * @return the mdp1
	 */
	public String getMdp1() {
		return mdp1;
	}

	/**
	 * @param mdp1 the mdp1 to set
	 */
	public void setMdp1(String mdp1) {
		this.mdp1 = mdp1;
	}

	/**
	 * @return the mdp2
	 */
	public String getMdp2() {
		return mdp2;
	}

	/**
	 * @param mdp2 the mdp2 to set
	 */
	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}

	/**
	 * @return the idUtilisateur
	 */
	public long getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the imageAvatar
	 */
	public String getImageAvatar() {
		return imageAvatar;
	}

	/**
	 * @param imageAvatar the imageAvatar to set
	 */
	public void setImageAvatar(String imageAvatar) {
		this.imageAvatar = imageAvatar;
	}
}
