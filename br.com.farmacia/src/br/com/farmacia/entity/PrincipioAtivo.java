package br.com.farmacia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class PrincipioAtivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdPrincipioAtivo;
     
    @NotNull(message = "Informe a Descricao do Principio Ativo")
    @Size(max = 900, message = "Descricao dever ter até 900 caracteres")
    private String Descricao;
    
    @OneToMany(mappedBy = "principiosativos")
    private List<Medicamento> medicamentos;

    public Short getIdPrincipioAtivo() {
        return IdPrincipioAtivo;
    }

    public void setIdPrincipioAtivo(Short IdPrincipioAtivo) {
        this.IdPrincipioAtivo = IdPrincipioAtivo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdPrincipioAtivo == null) ? 0 : IdPrincipioAtivo.hashCode());
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
		PrincipioAtivo other = (PrincipioAtivo) obj;
		if (IdPrincipioAtivo == null) {
			if (other.IdPrincipioAtivo != null)
				return false;
		} else if (!IdPrincipioAtivo.equals(other.IdPrincipioAtivo))
			return false;
		return true;
	}
    
    
    
}
