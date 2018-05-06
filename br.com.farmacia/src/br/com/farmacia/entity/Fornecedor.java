package br.com.farmacia.entity;

import javax.persistence.*;
import java.util.*;


@Entity
public class Fornecedor {
    
    @Id
    @OneToOne
    private Pessoa pessoa;
    
    @ManyToMany(mappedBy = "fornecedores") // É o mapeamento já criado, ou seja, é o nome da referencia, o nome do objeto la na outra classe;
    private List<Medicamento> medicamentos;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
}
