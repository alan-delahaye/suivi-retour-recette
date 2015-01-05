/**
 * 
 */
package fr.gfi.alan.delahaye.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.gfi.alan.delahaye.core.dao.impl.GenericDAOImpl;

/**
 * Classe utilitaire pour MD5
 * 
 * @author adelahaye
 *
 */
public abstract class MD5Crypter {

	/** the logger */
	private static final Logger LOG = LogManager
			.getLogger(MD5Crypter.class);
	
	public static String crypterMD5(final String chaineACrypter) {
		if (chaineACrypter != null) {
			final byte[] uniqueKey = chaineACrypter.getBytes();
			byte[] hash = null;

			try {
				// on récupère un objet qui permettra de crypter la chaine
				hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
			} catch (final NoSuchAlgorithmException e) {
				LOG.warn("no MD5 support in this VM");
			}

			final StringBuffer hashString = new StringBuffer();

			if (hash != null) {
				for (int i = 0; i < hash.length; ++i) {
					final String hex = Integer.toHexString(hash[i]);
					if (hex.length() == 1) {
						hashString.append('0');
						hashString.append(hex.charAt(hex.length() - 1));
					} else {
						hashString.append(hex.substring(hex.length() - 2));
					}
				}
			}

			return hashString.toString();
		}
		return null;
	}
	
	public static boolean estIdentique(String mdpClair, String mdpCrypter){
		String empreinteMDPClair = crypterMD5(mdpClair);
		return empreinteMDPClair.equals(mdpCrypter);
	}
	
}
