package br.com.farmacia.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Sequencial;
    
    @ManyToOne
    @JoinColumn(name = "IdPessoaTelefone")//FK
    private Pessoa pessoas;
    
    @NotNull(message = "Informe o Telefone")
    private Integer NumeroTelefone;
    
    @ManyToOne
    @JoinColumn(name = "TipoTelefone")//FK
    private TipoTelefone tipostelefones;
    
    

    public Integer getSequencial() {
        return Sequencial;
    }

    public void setSequencial(Integer Sequencial) {
        this.Sequencial = Sequencial;
    }

    public Integer getNumeroTelefone() {
        return NumeroTelefone;
    }

    public void setNumeroTelefone(Integer NumeroTelefone) {
        this.NumeroTelefone = NumeroTelefone;
    }

    public TipoTelefone getTipostelefones() {
        return tipostelefones;
    }

    public void setTipostelefones(TipoTelefone tipostelefones) {
        this.tipostelefones = tipostelefones;
    }

    public Pessoa getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoa pessoas) {
        this.pessoas = pessoas;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Sequencial == null) ? 0 : Sequencial.hashCode());
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
		Telefone other = (Telefone) obj;
		if (Sequencial == null) {
			if (other.Sequencial != null)
				return false;
		} else if (!Sequencial.equals(other.Sequencial))
			return false;
		if (pessoas == null) {
			if (other.pessoas != null)
				return false;
		} else if (!pessoas.equals(other.pessoas))
			return false;
		return true;
	}
    
    
    
}
