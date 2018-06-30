package br.com.farmacia.ejb;

import javax.ejb.*;
import br.com.farmacia.entity.Pessoa;

@Stateless
public class PessoaEJB  extends GenericEJB<Pessoa>{

	public PessoaEJB(){
		   super(Pessoa.class);
		}
}
