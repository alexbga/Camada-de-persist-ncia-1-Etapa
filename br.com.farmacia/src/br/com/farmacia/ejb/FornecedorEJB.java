package br.com.farmacia.ejb;

import javax.ejb.Stateless;

import br.com.farmacia.entity.Fornecedor;

@Stateless
public class FornecedorEJB extends GenericEJB<Fornecedor>{
	
	 public FornecedorEJB(){
		   super(Fornecedor.class);
		}

}
