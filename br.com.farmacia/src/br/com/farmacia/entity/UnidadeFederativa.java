package br.com.farmacia.entity;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UF == null) ? 0 : UF.hashCode());
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
		UnidadeFederativa other = (UnidadeFederativa) obj;
		if (UF == null) {
			if (other.UF != null)
				return false;
		} else if (!UF.equals(other.UF))
			return false;
		return true;
	}
    
    
}

