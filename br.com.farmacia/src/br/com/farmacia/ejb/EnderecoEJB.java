package br.com.farmacia.ejb;

import br.com.farmacia.entity.Endereco;
import javax.ejb.*;

@Stateless
public class EnderecoEJB  extends GenericEJB<Endereco>{

	 public EnderecoEJB(){
	   super(Endereco.class);
	}
	   
}
