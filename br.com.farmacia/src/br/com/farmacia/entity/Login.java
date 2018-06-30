package br.com.farmacia.entity;

import javax.persistence.*;


@Entity
public class Login {
    
	@Id
	@Column(name = "IdPessoa", 
			insertable = false, updatable = false)
	private Integer IdPessoa;
	
	private String login;
	private String senha;
	
	@OneToOne
	@JoinColumn(name = "IdPessoa")
	private Pessoa pessoa;

	public Integer getIdPessoa() {
		return IdPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		IdPessoa = idPessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Login other = (Login) obj;
		if (IdPessoa == null) {
			if (other.IdPessoa != null)
				return false;
		} else if (!IdPessoa.equals(other.IdPessoa))
			return false;
		return true;
	}

	
    
    
}
