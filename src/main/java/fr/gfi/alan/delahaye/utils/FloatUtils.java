/**
 * 
 */
package fr.gfi.alan.delahaye.utils;

/**
 * @author adelahaye
 *
 */
public abstract class FloatUtils {

	public static float arrondir(float valeur){
		float valeurFloat = valeur * 100;
		int valeurInt = (int) valeurFloat;
		valeurFloat = valeurInt;
		return valeurFloat / 100;
	}
	
}
