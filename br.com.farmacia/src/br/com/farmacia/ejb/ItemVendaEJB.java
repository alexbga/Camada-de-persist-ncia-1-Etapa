package br.com.farmacia.ejb;

import javax.ejb.Stateless;

import br.com.farmacia.entity.ItemVenda;

@Stateless
public class ItemVendaEJB extends GenericEJB<ItemVenda>{

	public ItemVendaEJB(){
		   super(ItemVenda.class);
		}
}
