package br.com.farmacia.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.farmacia.ejb.PessoaEJB;
import br.com.farmacia.entity.Fornecedor;
import br.com.farmacia.entity.Pessoa;
import br.com.farmacia.util.MensagemUtil;

@Named
@RequestScoped
public class FornecedorController {

private Pessoa pessoa;
    
    @EJB
    private PessoaEJB pessoaEjb;
    
    public FornecedorController(){
    	
    	pessoa = new Pessoa();
    	pessoa.setFornecedor(new Fornecedor());
    }
    
    public void salvar(){
    	
    	pessoa.getFornecedor().setPessoa(pessoa);
        String erro = pessoaEjb.salvar(pessoa);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            pessoa = new Pessoa();
            pessoa.setFornecedor(new Fornecedor());
           
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<Pessoa> listarPessoas(){
        return pessoaEjb.todos();
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

