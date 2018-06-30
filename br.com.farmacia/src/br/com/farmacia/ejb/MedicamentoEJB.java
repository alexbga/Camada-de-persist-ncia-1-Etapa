package br.com.farmacia.ejb;

import br.com.farmacia.entity.Medicamento;
import javax.ejb.*;

@Stateless
public class MedicamentoEJB extends GenericEJB<Medicamento>{

	 public MedicamentoEJB(){
	   super(Medicamento.class);
	}
}
