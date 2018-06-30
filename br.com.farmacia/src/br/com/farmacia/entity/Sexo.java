package br.com.farmacia.entity;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SiglaSexo == null) ? 0 : SiglaSexo.hashCode());
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
		Sexo other = (Sexo) obj;
		if (SiglaSexo == null) {
			if (other.SiglaSexo != null)
				return false;
		} else if (!SiglaSexo.equals(other.SiglaSexo))
			return false;
		return true;
	}
    
}
