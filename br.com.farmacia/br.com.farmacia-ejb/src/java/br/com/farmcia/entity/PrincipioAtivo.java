package br.com.farmcia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class PrincipioAtivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdPrincioAtivo;
     
    @NotNull(message = "Informe a Descricao do Principio Ativo")
    @Size(max = 50, message = "Descrição dever ter até 80 caracteres")
    private String Descricão;
    
    @OneToMany(mappedBy = "principiosativos")
    private List<Medicamento> medicamentos;

    public Short getIdPrincioAtivo() {
        return IdPrincioAtivo;
    }

    public void setIdPrincioAtivo(Short IdPrincioAtivo) {
        this.IdPrincioAtivo = IdPrincioAtivo;
    }

    public String getDescricão() {
        return Descricão;
    }

    public void setDescricão(String Descricão) {
        this.Descricão = Descricão;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
}
