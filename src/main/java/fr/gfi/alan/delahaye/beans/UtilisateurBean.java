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
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Utilisateur :  [" + nom + " " + prenom + " - " + adresseMail + "]");
		return stringBuilder.toString();
	}
}
