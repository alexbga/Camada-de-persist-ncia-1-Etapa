package br.com.farmacia.ejb;

import br.com.farmacia.entity.PrincipioAtivo;
import javax.ejb.*;

@Stateless
public class PrincipioAtivoEJB extends GenericEJB<PrincipioAtivo>{
    
    public PrincipioAtivoEJB(){
        super(PrincipioAtivo.class);
    }
    
}
