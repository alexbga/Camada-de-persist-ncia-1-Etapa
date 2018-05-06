package br.com.farmacia.controllers;

import javax.inject.Named;
import javax.enterprise.context.*;
import javax.ejb.*;
import java.util.List;
import br.com.farmacia.util.*;
import br.com.farmacia.ejb.UnidadeFederativaEJB;
import br.com.farmacia.entity.UnidadeFederativa;

@Named
@RequestScoped
public class UnidadeFederativaController {

private UnidadeFederativa unidadeFederativa;
    
    @EJB
    private UnidadeFederativaEJB unidadeFederativaEjb;
    
    public UnidadeFederativaController(){
    	unidadeFederativa = new UnidadeFederativa();
    }
    
    public void salvar(){
        String erro = unidadeFederativaEjb.salvar(unidadeFederativa);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            unidadeFederativa = new UnidadeFederativa();     
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<UnidadeFederativa> listarUnidadesFederativas(){
        return unidadeFederativaEjb.todos();
    }
    
    public void editar(UnidadeFederativa unidadeFederativa){
        this.unidadeFederativa = unidadeFederativa;
    }
    
    public void excluir(UnidadeFederativa unidadeFederativa){
    	String erro = unidadeFederativaEjb.excluir(unidadeFederativa.getUF());
    	if(erro == null){
    		MensagemUtil.sucess("Excluído com sucesso!");
    	}else{
    		MensagemUtil.error(erro);
    	}
    }

    public UnidadeFederativa getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }
}
