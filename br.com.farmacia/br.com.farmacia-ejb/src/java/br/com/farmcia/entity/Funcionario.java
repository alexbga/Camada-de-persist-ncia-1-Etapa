package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class Funcionario {
   
    @Id
    @OneToOne
    private Pessoa pessoa;
    
    @NotNull(message = "Informe o Salário")
    private Double Salario;
    
    @NotNull(message = "Informe a Data de Inicio De Vigência")
    @Temporal(TemporalType.DATE)
    private Date InicioVigencia;
    
    @Temporal(TemporalType.DATE)
    private Date FimVigencia;
    
    @OneToMany(mappedBy = "funcionarios")
    private List<Venda> vendas;
    
    @ManyToOne
    @JoinColumn(name = "IdLogin")//FK
    private Login logins;

    public Login getLogins() {
        return logins;
    }

    public void setLogins(Login logins) {
        this.logins = logins;
    }

    
    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
     
     
    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public Date getInicioVigencia() {
        return InicioVigencia;
    }

    public void setInicioVigencia(Date InicioVigencia) {
        this.InicioVigencia = InicioVigencia;
    }

    public Date getFimVigencia() {
        return FimVigencia;
    }

    public void setFimVigencia(Date FimVigencia) {
        this.FimVigencia = FimVigencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
