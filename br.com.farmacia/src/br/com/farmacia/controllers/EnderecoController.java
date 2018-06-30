package br.com.farmacia.controllers;

import javax.ejb.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import java.util.List;

import br.com.farmacia.ejb.EnderecoEJB;
import br.com.farmacia.entity.Endereco;
import br.com.farmacia.util.*;


@Named
@RequestScoped
public class EnderecoController {

private Endereco endereco;
    
    @EJB
    private EnderecoEJB enderecoEjb;
    
    public EnderecoController(){
    	endereco = new Endereco();
    }
    
    public void salvar(){
        String erro = enderecoEjb.salvar(endereco);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            endereco = new Endereco();     
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<Endereco> listarEnderecos(){
        return enderecoEjb.todos();
    }
    
    public void editar(Endereco endereco){
        this.endereco = endereco;
    }
    
    public void excluir(Endereco endereco){
    	String erro = enderecoEjb.excluir(endereco.getIdEndereco());
    	if(erro == null){
    		MensagemUtil.sucess("Excluído com sucesso!");
    	}else{
    		MensagemUtil.error(erro);
    	}
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
