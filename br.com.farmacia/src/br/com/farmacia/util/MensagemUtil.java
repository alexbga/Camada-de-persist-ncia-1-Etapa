package br.com.farmacia.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	public static void error(String msg){
		
		FacesContext.getCurrentInstance()
        .addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
		}
	
	public static void sucess(String msg){
		
		FacesContext.getCurrentInstance()
        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
		
	}
}
