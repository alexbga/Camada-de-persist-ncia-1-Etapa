package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class UnidadeFederativa {
    
    @Id
    private String UF;
    
    @NotNull(message = "Informe o Nome do Estado")
    @Size(max = 50, message = "O estado dever ter até 30 caracteres")
    private String NomeDoEstado;
    
    @OneToMany(mappedBy = "unidadeFederativas")
    private List<Endereco> enderecos;

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getNomeDoEstado() {
        return NomeDoEstado;
    }

    public void setNomeDoEstado(String NomeDoEstado) {
        this.NomeDoEstado = NomeDoEstado;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
}

