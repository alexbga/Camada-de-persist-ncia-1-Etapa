package br.com.farmacia.ejb;

import javax.ejb.*;
import br.com.farmacia.entity.Funcionario;


@Stateless
public class FuncionarioEJB extends GenericEJB<Funcionario>{

	public FuncionarioEJB(){
		   super(Funcionario.class);
		}
}