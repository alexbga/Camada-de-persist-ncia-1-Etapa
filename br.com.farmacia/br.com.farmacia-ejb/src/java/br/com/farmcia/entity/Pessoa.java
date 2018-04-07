package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import java.util.Date;
import javax.validation.constraints.*;

@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdPessoa;
    
    @NotNull(message = "Informe o Nome")
    @Size(max = 50, message = "O nome dever ter até 80 caracteres")
    private String Nome;
    
    @NotNull(message = "Informe a Data De Nascimento")
    @Temporal(TemporalType.DATE)
    private Date DataNascimento;
    
    @NotNull(message = "Informe o CPF")
    private Short CPF;
    
    @NotNull(message = "Informe o RG")
    private String RG;
    
    @OneToMany(mappedBy = "pessoas")
    private List<Endereco> enderecos;

    @ManyToOne
    @JoinColumn(name = "SiglaSexo")//FK
    private Sexo sexos;
    
    @OneToMany(mappedBy = "pessoas")
    private List<Telefone> telefones;
    

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    
    public Short getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(Short IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public Short getCPF() {
        return CPF;
    }

    public void setCPF(Short CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

     public Sexo getSexos() {
        return sexos;
    }

    public void setSexos(Sexo sexos) {
        this.sexos = sexos;
    }
}
