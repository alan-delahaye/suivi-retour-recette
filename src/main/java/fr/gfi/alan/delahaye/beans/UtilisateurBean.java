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
}
