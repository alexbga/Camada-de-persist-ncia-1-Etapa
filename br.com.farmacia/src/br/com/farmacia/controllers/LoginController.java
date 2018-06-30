package br.com.farmacia.controllers;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.farmacia.ejb.LoginEJB;
import br.com.farmacia.entity.Login;

@ManagedBean
@javax.faces.bean.SessionScoped
public class LoginController {


	private Login usuarioLogado;
	private String email;
	private String senha;
	
	@EJB
	private LoginEJB loginEJB;
	
	public String entrar() {
		usuarioLogado = loginEJB.login(email, senha);
		
		if(usuarioLogado != null) {
			return "index.xhtml";
		}else {
			  FacesContext.getCurrentInstance()
	            .addMessage(null, 
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                                        "Usuário ou senha inválidos.", null
	                                    )
	                        );
			return "login.xhtml";
		}
	}
	
	public String sair() {
		usuarioLogado = null;
		return "login.xhtml";
	}
	
	public Login getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Login usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
