package br.com.farmacia.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdEndereco;
    
    @NotNull(message = "Informe a Cidade")
    @Size(max = 50, message = "Cidade dever ter até 50 caracteres")
    private String Cidade;
    
    @NotNull(message = "Informe o Logradouro")
    @Size(max = 50, message = "Logradouro dever ter até 80 caracteres")
    private String Logradouro;
    
    @NotNull(message = "Informe o CEP")
    private Short CEP;
    
    @NotNull(message = "Informe o NÃºmero")
    private Short Numero;
    
    private String Complemento;
    
    @NotNull(message = "Informe o Bairro")
    @Size(max = 50, message = "Bairro dever ter até 50 caracteres")
    private String Bairro;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPessoa")//FK
    private Pessoa pessoas;
    
    @ManyToOne
    @JoinColumn(name = "UF")//FK
    private UnidadeFederativa unidadeFederativas;

    public Short getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(Short IdEndereco) {
        this.IdEndereco = IdEndereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public Short getCEP() {
        return CEP;
    }

    public void setCEP(Short CEP) {
        this.CEP = CEP;
    }

    public Short getNumero() {
        return Numero;
    }

    public void setNumero(Short Numero) {
        this.Numero = Numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public Pessoa getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoa pessoas) {
        this.pessoas = pessoas;
    }

    public UnidadeFederativa getUnidadeFederativas() {
        return unidadeFederativas;
    }

    public void setUnidadeFederativas(UnidadeFederativa unidadeFederativas) {
        this.unidadeFederativas = unidadeFederativas;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoas == null) ? 0 : pessoas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (pessoas == null) {
			if (other.pessoas != null)
				return false;
		} else if (!pessoas.equals(other.pessoas))
			return false;
		return true;
	}
    
    
    
    
}

