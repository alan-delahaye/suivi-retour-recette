/**
 * 
 */
package fr.gfi.alan.delahaye.core.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @author adelahaye
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Utilisateur.getUtilisateurByIdentifiant", query="select u from Utilisateur u where u.identifiant = :identifiant")
})
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUtilisateur;
	
	private String nom;
	
	private String prenom;
	
	private String adresseMail;
	
	private String numeroTelephone;
	
	private String fonction;
	
	private String identifiant;
	
	private String motDePasse;
	
	private String imageAvatar;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateurPrincipaleEnCharge")
	private List<Perimetre> lesPerimetres;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	private List<Notification> lesNotification;

	/**
	 * Constructeur par défaut
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * @param idUtilisateur
	 * @param nom
	 * @param prenom
	 * @param adresseMail
	 * @param numeroTelephone
	 * @param fonction
	 */
	public Utilisateur(String nom, String prenom,
			String adresseMail, String numeroTelephone, String fonction, String identifiant) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.numeroTelephone = numeroTelephone;
		this.fonction = fonction;
		this.identifiant = identifiant;
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
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Utilisateur(entite) :  [");
		stringBuilder.append(idUtilisateur);
		stringBuilder.append(" - ");
		stringBuilder.append(nom);
		stringBuilder.append(" ");
		stringBuilder.append(prenom);
		stringBuilder.append(" - ");
		stringBuilder.append(fonction);
		stringBuilder.append("][Log: ");
		stringBuilder.append(identifiant);
		stringBuilder.append("][@ ");
		stringBuilder.append(adresseMail);
		stringBuilder.append("][Tél. ");
		stringBuilder.append(numeroTelephone);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	/**
	 * @return the lesPerimetres
	 */
	public List<Perimetre> getLesPerimetres() {
		return lesPerimetres;
	}

	/**
	 * @param lesPerimetres the lesPerimetres to set
	 */
	public void setLesPerimetres(List<Perimetre> lesPerimetres) {
		this.lesPerimetres = lesPerimetres;
	}

	/**
	 * @return the lesNotification
	 */
	public List<Notification> getLesNotification() {
		return lesNotification;
	}

	/**
	 * @param lesNotification the lesNotification to set
	 */
	public void setLesNotification(List<Notification> lesNotification) {
		this.lesNotification = lesNotification;
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
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
