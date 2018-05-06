package br.com.farmacia.entity;

import javax.persistence.*;
import java.util.*;
import java.util.Date;
import javax.validation.constraints.*;

@Entity
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short NumeroVenda;
    
    @NotNull(message = "Informe a Data De Nascimento")
    @Temporal(TemporalType.DATE)
    private Date DataVenda;
    
    @OneToMany(mappedBy = "vendas")
    private List<ItemVenda> itensvendas;

    @ManyToOne
    @JoinColumn(name = "IdFuncionario")//FK
    private Funcionario funcionarios;

    public Funcionario getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
    public Short getNumeroVenda() {
        return NumeroVenda;
    }

    public void setNumeroVenda(Short NumeroVenda) {
        this.NumeroVenda = NumeroVenda;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date DataVenda) {
        this.DataVenda = DataVenda;
    }

    public List<ItemVenda> getItensvendas() {
        return itensvendas;
    }

    public void setItensvendas(List<ItemVenda> itensvendas) {
        this.itensvendas = itensvendas;
    }
    
    
}
