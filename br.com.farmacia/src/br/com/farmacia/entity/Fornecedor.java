package br.com.farmacia.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.*;


@Entity
public class Fornecedor {
    
	@Id
	@Column(name = "IdPessoa", 
			insertable = false, updatable = false)
	private Integer IdPessoa;
    
    @NotNull(message = "Informe o email do fornecedor")
    private String email;
    
    @ManyToMany(mappedBy = "fornecedores")
    private List<Medicamento> medicamentos;
    
    @OneToOne
	@JoinColumn(name = "IdPessoa")
	private Pessoa pessoa;

	public Integer getIdPessoa() {
		return IdPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		IdPessoa = idPessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdPessoa == null) ? 0 : IdPessoa.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (IdPessoa == null) {
			if (other.IdPessoa != null)
				return false;
		} else if (!IdPessoa.equals(other.IdPessoa))
			return false;
		return true;
	}


    
    
}
