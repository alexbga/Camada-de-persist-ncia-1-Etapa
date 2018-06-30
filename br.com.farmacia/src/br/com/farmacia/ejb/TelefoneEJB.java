package br.com.farmacia.ejb;

import javax.ejb.*;
import br.com.farmacia.entity.Telefone;

@Stateless
public class TelefoneEJB extends GenericEJB<Telefone>{

	public TelefoneEJB(){
		   super(Telefone.class);
		}
}
