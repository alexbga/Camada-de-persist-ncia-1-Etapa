package br.com.farmacia.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.farmacia.ejb.ItemVendaEJB;
import br.com.farmacia.entity.ItemVenda;
import br.com.farmacia.util.MensagemUtil;

@Named
@RequestScoped
public class ItemVendaController {
	
private ItemVenda itemVenda;
    
    @EJB
    private ItemVendaEJB itemVendaEjb;
    
    public ItemVendaController(){
    	itemVenda = new ItemVenda();
    }
    
    public void salvar(){
        String erro = itemVendaEjb.salvar(itemVenda);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            itemVenda = new ItemVenda();     
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<ItemVenda> listarItens(){
        return itemVendaEjb.todos();
    }
    
    public void editar(ItemVenda itemVenda){
        this.itemVenda = itemVenda;
    }
    
    public void excluir(ItemVenda itemVenda){
    	String erro = itemVendaEjb.excluir(itemVenda.getIdItemVenda());
    	if(erro == null){
    		MensagemUtil.sucess("Excluído com sucesso!");
    	}else{
    		MensagemUtil.error(erro);
    	}
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

}
