package br.com.farmacia.ejb;

import br.com.farmacia.ejb.GenericEJB;
import br.com.farmacia.entity.TipoTelefone;
import javax.ejb.*;

@Stateless
public class TipoTelefoneEJB extends GenericEJB<TipoTelefone>{

	public TipoTelefoneEJB(){
        super(TipoTelefone.class);
    }
}