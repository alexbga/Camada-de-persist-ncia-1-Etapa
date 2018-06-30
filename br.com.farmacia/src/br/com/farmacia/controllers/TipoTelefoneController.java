package br.com.farmacia.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.com.farmacia.ejb.TipoTelefoneEJB;
import br.com.farmacia.entity.TipoTelefone;
import br.com.farmacia.util.MensagemUtil;

@Named
@RequestScoped
public class TipoTelefoneController {

private TipoTelefone tipoTelefone;
    
    @EJB
    private TipoTelefoneEJB tipoTelefoneEjb;
    
    public TipoTelefoneController(){
    	tipoTelefone = new TipoTelefone();
    }
    
    public void salvar(){
        String erro = tipoTelefoneEjb.salvar(tipoTelefone);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            tipoTelefone = new TipoTelefone();     
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<TipoTelefone> listarTipoTelefones(){
        return tipoTelefoneEjb.todos();
    }
    
    public void editar(TipoTelefone tipoTelefone){
        this.tipoTelefone = tipoTelefone;
    }
    
    public void excluir(TipoTelefone tipoTelefone){
    	String erro = tipoTelefoneEjb.excluir(tipoTelefone.getIdTipoTelefone());
    	if(erro == null){
    		MensagemUtil.sucess("Excluído com sucesso!");
    	}else{
    		MensagemUtil.error(erro);
    	}
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
