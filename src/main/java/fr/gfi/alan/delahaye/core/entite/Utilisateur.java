/**
 * 
 */
package fr.gfi.alan.delahaye.core.entite;

/**
 * @author adelahaye
 *
 */
public class Utilisateur {

	private long idUtilisateur;
	
	private String nom;
	
	private String prenom;
	
	private String adresseMail;
	
	private String numeroTelephone;
	
	private String fonction;

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
			String adresseMail, String numeroTelephone, String fonction) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.numeroTelephone = numeroTelephone;
		this.fonction = fonction;
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
		stringBuilder.append("][@ ");
		stringBuilder.append(adresseMail);
		stringBuilder.append("][Tél. ");
		stringBuilder.append(numeroTelephone);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
}
