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
    @Size(max = 50, message = "Descricao dever ter até 80 caracteres")
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
    
    
}
