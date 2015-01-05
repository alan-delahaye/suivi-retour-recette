/**
 * 
 */
package fr.gfi.alan.delahaye.core.entite;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author adelahaye
 *
 */
@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNotification;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TypeNotification typeNotification;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Perimetre perimetre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Utilisateur utilisateur;

	/**
	 * 
	 */
	public Notification() {
		super();
	}

	/**
	 * @param typeNotification
	 * @param perimetre
	 * @param utilisateur
	 */
	public Notification(TypeNotification typeNotification, Perimetre perimetre,
			Utilisateur utilisateur) {
		this.typeNotification = typeNotification;
		this.perimetre = perimetre;
		this.utilisateur = utilisateur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notification [idNotification=");
		builder.append(idNotification);
		builder.append(", ");
		if (typeNotification != null) {
			builder.append("typeNotification=");
			builder.append(typeNotification);
			builder.append(", ");
		}
		if (perimetre != null) {
			builder.append("perimetre=");
			builder.append(perimetre);
			builder.append(", ");
		}
		if (utilisateur != null) {
			builder.append("utilisateur=");
			builder.append(utilisateur);
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the idNotification
	 */
	public long getIdNotification() {
		return idNotification;
	}

	/**
	 * @param idNotification the idNotification to set
	 */
	public void setIdNotification(long idNotification) {
		this.idNotification = idNotification;
	}

	/**
	 * @return the typeNotification
	 */
	public TypeNotification getTypeNotification() {
		return typeNotification;
	}

	/**
	 * @param typeNotification the typeNotification to set
	 */
	public void setTypeNotification(TypeNotification typeNotification) {
		this.typeNotification = typeNotification;
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
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
