package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;


@Entity
public class Sexo {
    
    @Id
    private String SiglaSexo;
    
    @NotNull(message = "Informe o Sexo")
    private String Descricao;
    
    @OneToMany(mappedBy = "sexos")
    private List<Pessoa> pessoas;

    public String getSiglaSexo() {
        return SiglaSexo;
    }

    public void setSiglaSexo(String SiglaSexo) {
        this.SiglaSexo = SiglaSexo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
