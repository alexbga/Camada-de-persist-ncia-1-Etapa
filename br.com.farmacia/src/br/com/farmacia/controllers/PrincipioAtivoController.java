package br.com.farmacia.controllers;

import javax.inject.Named;
import javax.enterprise.context.*;
import javax.ejb.*;
import java.util.List;
import br.com.farmacia.util.*;
import br.com.farmacia.ejb.PrincipioAtivoEJB;
import br.com.farmacia.entity.PrincipioAtivo;

@Named
@RequestScoped
public class PrincipioAtivoController {

private PrincipioAtivo principioativo;
    
    @EJB
    private PrincipioAtivoEJB principioAtivoEjb;
    
    public PrincipioAtivoController(){
    	principioativo = new PrincipioAtivo();
    }
    
    public void salvar(){
        String erro = principioAtivoEjb.salvar(principioativo);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            principioativo = new PrincipioAtivo();     
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<PrincipioAtivo> listarPrincipioAtivo(){
        return principioAtivoEjb.todos();
    }
    
    public void editar(PrincipioAtivo principioativo){
        this.principioativo = principioativo;
    }
    
    public void excluir(PrincipioAtivo principioativo){
    	String erro = principioAtivoEjb.excluir(principioativo.getIdPrincipioAtivo());
    	if(erro == null){
    		MensagemUtil.sucess("Excluído com sucesso!");
    	}else{
    		MensagemUtil.error(erro);
    	}
    }

    public PrincipioAtivo getPrincipioAtivo() {
        return principioativo;
    }

    public void setPrincipioAtivo(PrincipioAtivo principioativo) {
        this.principioativo = principioativo;
    }
}
