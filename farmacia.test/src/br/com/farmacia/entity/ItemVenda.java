package br.com.farmacia.entity;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;

@Entity
public class ItemVenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short IdItemVenda;
    
    @NotNull(message = "Informe o Valor")
    private Double ValorUnitário;
    @NotNull(message = "Informe o Quantidade")
    private Short Quantidade;
    
    @ManyToOne
    @JoinColumn(name = "IdMedicamento")//FK
    private Medicamento medicamentos;
    
    @ManyToOne
    @JoinColumn(name = "NumeroVenda")//FK
    private Venda vendas;

    public Short getIdItemVenda() {
        return IdItemVenda;
    }

    public void setIdItemVenda(Short IdItemVenda) {
        this.IdItemVenda = IdItemVenda;
    }

    public Double getValorUnitário() {
        return ValorUnitário;
    }

    public void setValorUnitário(Double ValorUnitário) {
        this.ValorUnitário = ValorUnitário;
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

    public Venda getVendas() {
        return vendas;
    }

    public void setVendas(Venda vendas) {
        this.vendas = vendas;
    }
    
    
}
