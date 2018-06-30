package br.com.farmacia.entity;

import javax.persistence.*;
import java.util.*;
import java.util.Date;
import javax.validation.constraints.*;


@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdPessoa;
    
    @NotNull(message = "Informe o Nome")
    @Size(max = 50, message = "O nome dever ter até 80 caracteres")
    private String Nome;
    
    @NotNull(message = "Informe a Data De Nascimento")
    @Temporal(TemporalType.DATE)
    private Date DataNascimento;
    
    @NotNull(message = "Informe o CPF")
    private Integer CPF;
    
    @NotNull(message = "Informe o RG")
    private String RG;
    
    @OneToMany(mappedBy = "pessoas")
    private List<Endereco> enderecos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SiglaSexo")//FK
    private Sexo sexos;
    
    @OneToMany(mappedBy = "pessoas")
    private List<Telefone> telefones;
    
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Funcionario funcionario;
    
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Login login;
    
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Fornecedor fornecedor;

	public Integer getIdPessoa() {
		return IdPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		IdPessoa = idPessoa;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public Integer getCPF() {
		return CPF;
	}

	public void setCPF(Integer cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Sexo getSexos() {
		return sexos;
	}

	public void setSexos(Sexo sexos) {
		this.sexos = sexos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
		Pessoa other = (Pessoa) obj;
		if (IdPessoa == null) {
			if (other.IdPessoa != null)
				return false;
		} else if (!IdPessoa.equals(other.IdPessoa))
			return false;
		return true;
	}

 
	
  
}
