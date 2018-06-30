package br.com.farmacia.ejb;

import javax.ejb.*;
import br.com.farmacia.entity.Sexo;

@Stateless
public class SexoEJB  extends GenericEJB<Sexo>{

	public SexoEJB(){
		   super(Sexo.class);
		}
}
