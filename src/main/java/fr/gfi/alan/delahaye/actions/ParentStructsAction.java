/**
 * 
 */
package fr.gfi.alan.delahaye.actions;

import java.io.Serializable;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Classe parente de toute les actions struts
 * 
 * @author adelahaye
 *
 */
public abstract class ParentStructsAction extends ActionSupport implements SessionAware, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842076032804852900L;

	public static final String LOGIN = "login";

	protected SessionMap<String, Object> sessionMap;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = (SessionMap<String, Object>) arg0;
	}
}
