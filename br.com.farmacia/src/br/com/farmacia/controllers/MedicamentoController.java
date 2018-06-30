package br.com.farmacia.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.farmacia.ejb.MedicamentoEJB;
import br.com.farmacia.entity.Medicamento;
import br.com.farmacia.util.MensagemUtil;

@Named
@RequestScoped
public class MedicamentoController {

		
		private Medicamento medicamento;
		
	 	@EJB
	    private MedicamentoEJB medicamentoEjb;
	    
	    public MedicamentoController(){
	    	medicamento = new Medicamento();
	    }
	    
	    public void salvar(){
	        String erro = medicamentoEjb.salvar(medicamento);
	        
	        if(erro == null){
	            MensagemUtil.sucess("Salvo com sucesso!");
	            medicamento = new Medicamento();     
	        }else{
	            MensagemUtil.error(erro);
	        }
	    }
	    
	    public List<Medicamento> listarMedicamentos(){
	        return medicamentoEjb.todos();
	    }
	    
	    public void editar(Medicamento medicamento){
	        this.medicamento = medicamento;
	    }
	    
	    public void excluir(Medicamento medicamento){
	    	String erro = medicamentoEjb.excluir(medicamento.getIdMedicamento());
	    	if(erro == null){
	    		MensagemUtil.sucess("Excluído com sucesso!");
	    	}else{
	    		MensagemUtil.error(erro);
	    	}
	    }

	    public Medicamento getMedicamento() {
	        return medicamento;
	    }

	    public void setMedicamento(Medicamento medicamento) {
	        this.medicamento = medicamento;
	    }
}
