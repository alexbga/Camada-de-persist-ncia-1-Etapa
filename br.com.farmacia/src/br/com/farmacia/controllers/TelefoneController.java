package br.com.farmacia.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.farmacia.ejb.TelefoneEJB;
import br.com.farmacia.entity.Telefone;
import br.com.farmacia.util.MensagemUtil;

@Named
@RequestScoped
public class TelefoneController {

		private Telefone telefone;
		
		@EJB
	    private TelefoneEJB telefoneEjb;
	    
	    public TelefoneController(){
	    	telefone = new Telefone();
	    }
	    
	    public void salvar(){
	        String erro = telefoneEjb.salvar(telefone);
	        
	        if(erro == null){
	            MensagemUtil.sucess("Salvo com sucesso!");
	            telefone = new Telefone();     
	        }else{
	            MensagemUtil.error(erro);
	        }
	    }
	    
	    public List<Telefone> listarTelefones(){
	        return telefoneEjb.todos();
	    }
	    
	    public void editar(Telefone telefone){
	        this.telefone = telefone;
	    }
	    
	    public void excluir(Telefone telefone){
	    	String erro = telefoneEjb.excluir(telefone.getNumeroTelefone());
	    	if(erro == null){
	    		MensagemUtil.sucess("Excluído com sucesso!");
	    	}else{
	    		MensagemUtil.error(erro);
	    	}
	    }

	    public Telefone getTelefone() {
	        return telefone;
	    }

	    public void setTelefone(Telefone telefone) {
	        this.telefone = telefone;
	    }
}
