package br.com.farmacia.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.farmacia.ejb.PessoaEJB;
import br.com.farmacia.entity.Funcionario;
import br.com.farmacia.entity.Login;
import br.com.farmacia.entity.Pessoa;
import br.com.farmacia.util.MensagemUtil;

@Named
@RequestScoped
public class PessoaController {

private Pessoa pessoa;
    
    @EJB
    private PessoaEJB pessoaEjb;
    
    public PessoaController(){
    	
    	pessoa = new Pessoa();
    	pessoa.setFuncionario(new Funcionario());
    	pessoa.setLogin(new Login());
    }
    
    public void salvar(){
    	
    	pessoa.getFuncionario().setPessoa(pessoa);
    	pessoa.getLogin().setPessoa(pessoa);
        String erro = pessoaEjb.salvar(pessoa);
        
        if(erro == null){
            MensagemUtil.sucess("Salvo com sucesso!");
            pessoa = new Pessoa();
            pessoa.setLogin(new Login());
            pessoa.setFuncionario(new Funcionario());
           
        }else{
            MensagemUtil.error(erro);
        }
    }
    
    public List<Pessoa> listarPessoas(){
        return pessoaEjb.todos();
    }
    
    public void editar(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    
    public void excluir(Pessoa pessoa){
    	String erro = pessoaEjb.excluir(pessoa.getIdPessoa());
    	if(erro == null){
    		MensagemUtil.sucess("Excluído com sucesso!");
    	}else{
    		MensagemUtil.error(erro);
    	}
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
