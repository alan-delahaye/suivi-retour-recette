/**
 * 
 */
package fr.gfi.alan.delahaye.core.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author adelahaye
 *
 */
@Entity
public class TypeNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTypeNotification;
	
	private String libelle;
	
	private String texteAAfficher;

	/**
	 * 
	 */
	public TypeNotification() {
		super();
	}

	/**
	 * @param libelle
	 * @param texteAAfficher
	 */
	public TypeNotification(String libelle, String texteAAfficher) {
		this.libelle = libelle;
		this.texteAAfficher = texteAAfficher;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TypeNotification [idTypeNotification=");
		builder.append(idTypeNotification);
		builder.append(", ");
		if (libelle != null) {
			builder.append("libelle=");
			builder.append(libelle);
			builder.append(", ");
		}
		if (texteAAfficher != null) {
			builder.append("texteAAfficher=");
			builder.append(texteAAfficher);
		}
		builder.append("]");
		return builder.toString();
	}
}
