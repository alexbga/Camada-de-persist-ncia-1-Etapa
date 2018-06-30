package br.com.farmacia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class Medicamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdMedicamento;
    
    @NotNull(message = "Informe o Nome do Medicamento")
    @Size(max = 50, message = "O nome dever ter até 80 caracteres")
    private String NomeMedicamento;
    
    @ManyToOne
    @JoinColumn(name = "PrincipioAtivo")//FK
    private PrincipioAtivo principiosativos;
    
    @OneToMany(mappedBy = "medicamentos")
    private List<ItemVenda> itensvendas;
    
    @ManyToMany
    @JoinTable(name = "Fornecimento", 
                        joinColumns = @JoinColumn(name = "IdMedicamento"),
                        inverseJoinColumns = @JoinColumn(name = "IdPessoaFornecedor"))
    private List<Fornecedor> fornecedores;

    public List<ItemVenda> getItensvendas() {
        return itensvendas;
    }

    public void setItensvendas(List<ItemVenda> itensvendas) {
        this.itensvendas = itensvendas;
    }

    public Short getIdMedicamento() {
        return IdMedicamento;
    }

    public void setIdMedicamento(Short IdMedicamento) {
        this.IdMedicamento = IdMedicamento;
    }

    public String getNomeMedicamento() {
        return NomeMedicamento;
    }

    public void setNomeMedicamento(String NomeMedicamento) {
        this.NomeMedicamento = NomeMedicamento;
    }

    public PrincipioAtivo getPrincipiosativos() {
        return principiosativos;
    }

    public void setPrincipiosativos(PrincipioAtivo principiosativos) {
        this.principiosativos = principiosativos;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdMedicamento == null) ? 0 : IdMedicamento.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (IdMedicamento == null) {
			if (other.IdMedicamento != null)
				return false;
		} else if (!IdMedicamento.equals(other.IdMedicamento))
			return false;
		return true;
	}
    
    
    
}
