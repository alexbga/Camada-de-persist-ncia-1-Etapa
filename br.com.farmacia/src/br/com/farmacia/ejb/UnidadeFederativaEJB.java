package br.com.farmacia.ejb;

import br.com.farmacia.entity.UnidadeFederativa;
import javax.ejb.*;

@Stateless
public class UnidadeFederativaEJB extends GenericEJB<UnidadeFederativa>{
    
    public UnidadeFederativaEJB(){
        super(UnidadeFederativa.class);
    }
}
