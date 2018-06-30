package br.com.farmacia.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.farmacia.ejb.SexoEJB;
import br.com.farmacia.entity.Sexo;
import br.com.farmacia.util.MensagemUtil;

@Named
@RequestScoped
public class SexoController {

private Sexo sexo;
    
    @EJB
    private SexoEJB sexoEjb;
    
    public SexoController(){
    	sexo = new Sexo();
    }
    
    public void salvar(){
        String erro = sexoEjb.salvar(sexo);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            sexo = new Sexo();     
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<Sexo> listarSexos(){
        return sexoEjb.todos();
    }
    
    public void editar(Sexo sexo){
        this.sexo = sexo;
    }
    
    public void excluir(Sexo sexo){
    	String erro = sexoEjb.excluir(sexo.getSiglaSexo());
    	if(erro == null){
    		MensagemUtil.sucess("Excluído com sucesso!");
    	}else{
    		MensagemUtil.error(erro);
    	}
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
