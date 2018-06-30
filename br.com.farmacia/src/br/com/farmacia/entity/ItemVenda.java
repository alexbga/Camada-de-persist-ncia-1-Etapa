package br.com.farmacia.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class ItemVenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdItemVenda;
    
    @NotNull(message = "Informe o Valor")
    private Double ValorUnitario;
    
    
    @NotNull(message = "Informe o Quantidade")
    private Short Quantidade;
    
    @ManyToOne
    @JoinColumn(name = "IdMedicamento")//FK
    private Medicamento medicamentos;
    
    @ManyToMany(mappedBy = "itensvenda")
    private List<Funcionario> funcionarios;

    public Short getIdItemVenda() {
        return IdItemVenda;
    }

    public void setIdItemVenda(Short IdItemVenda) {
        this.IdItemVenda = IdItemVenda;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitarioo(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public Short getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Short Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Medicamento getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamento medicamentos) {
        this.medicamentos = medicamentos;
    }

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void setValorUnitario(Double valorUnitario) {
		ValorUnitario = valorUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdItemVenda == null) ? 0 : IdItemVenda.hashCode());
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
		ItemVenda other = (ItemVenda) obj;
		if (IdItemVenda == null) {
			if (other.IdItemVenda != null)
				return false;
		} else if (!IdItemVenda.equals(other.IdItemVenda))
			return false;
		return true;
	}

    
    
}
