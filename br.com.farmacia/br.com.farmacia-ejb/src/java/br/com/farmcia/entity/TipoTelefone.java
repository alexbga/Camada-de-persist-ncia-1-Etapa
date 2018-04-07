package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class TipoTelefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdTipoTelefone;
    
    @NotNull(message = "Informe a descrição do Telefone")
    @Size(max = 50, message = "Descrição dever ter até 80 caracteres")
    private String Descricao;
    
    @OneToMany(mappedBy = "tipostelefones")
    private List<Telefone> telefone;

    public Short getIdTipoTelefone() {
        return IdTipoTelefone;
    }

    public void setIdTipoTelefone(Short IdTipoTelefone) {
        this.IdTipoTelefone = IdTipoTelefone;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
    
    
}

