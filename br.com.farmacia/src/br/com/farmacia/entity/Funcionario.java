package br.com.farmacia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class Funcionario {
   
	@Id
	@Column(name = "IdPessoa", 
			insertable = false, updatable = false)
	private Integer IdPessoa;
	
	
    @NotNull(message = "Informe o salário")
    private Double Salario;
    
    @NotNull(message = "Informe a Data de Inicio De VigÃªncia")
    @Temporal(TemporalType.DATE)
    private Date InicioVigencia;
    
    @Temporal(TemporalType.DATE)
    private Date FimVigencia;
    
    @ManyToMany
    @JoinTable(name = "Venda", 
                        joinColumns = @JoinColumn(name = "IdPessoa"),
                        inverseJoinColumns = @JoinColumn(name = "IdItemVenda"))
    private List<ItemVenda> itensvenda;
    
    @OneToOne
	@JoinColumn(name = "IdPessoa")
	private Pessoa pessoa;
    
	public Integer getIdPessoa() {
		return IdPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		IdPessoa = idPessoa;
	}

	public Double getSalario() {
		return Salario;
	}

	public void setSalario(Double salario) {
		Salario = salario;
	}

	public Date getInicioVigencia() {
		return InicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		InicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return FimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		FimVigencia = fimVigencia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	public List<ItemVenda> getItensvenda() {
		return itensvenda;
	}

	public void setItensvenda(List<ItemVenda> itensvenda) {
		this.itensvenda = itensvenda;
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
		Funcionario other = (Funcionario) obj;
		if (IdPessoa == null) {
			if (other.IdPessoa != null)
				return false;
		} else if (!IdPessoa.equals(other.IdPessoa))
			return false;
		return true;
	}


    
	
    
}
