package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdLogin;
    private String Usuario;
    private String senha;
    
    @OneToMany(mappedBy = "logins")
    private List<Funcionario> funcionarios;

    public int getIdLogin() {
        return IdLogin;
    }

    public void setIdLogin(int IdLogin) {
        this.IdLogin = IdLogin;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
}
