package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short Sequencial;
    
    @NotNull(message = "Informe o Telefone")
    private Short NumeroTelefone;
    
    @ManyToOne
    @JoinColumn(name = "IdTipoTelefone")//FK
    private TipoTelefone tipostelefones;
    
    @ManyToOne
    @JoinColumn(name = "IdPessoaTelefone")//FK
    private Pessoa pessoas;

    public Short getSequencial() {
        return Sequencial;
    }

    public void setSequencial(Short Sequencial) {
        this.Sequencial = Sequencial;
    }

    public Short getNumeroTelefone() {
        return NumeroTelefone;
    }

    public void setNumeroTelefone(Short NumeroTelefone) {
        this.NumeroTelefone = NumeroTelefone;
    }

    public TipoTelefone getTipostelefones() {
        return tipostelefones;
    }

    public void setTipostelefones(TipoTelefone tipostelefones) {
        this.tipostelefones = tipostelefones;
    }

    public Pessoa getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoa pessoas) {
        this.pessoas = pessoas;
    }
    
}
