/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.test;

import br.com.farmacia.entity.*;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FarmaciaTest {

    public static void main(String[] args) {
        
         //é uma interface do JPA para genrenciamento de contexto de persistência.
        //Ações CRUD
        EntityManager em = Persistence
                .createEntityManagerFactory("farmacia.testPU")
                .createEntityManager();
        
        Pessoa pessoa = new Pessoa();
        Sexo sexo = new Sexo();
        Telefone telefone = new Telefone();
        TipoTelefone tipotefone = new TipoTelefone();
        Endereco endereco = new Endereco();
        Funcionario funcionario = new Funcionario();
        UnidadeFederativa uf = new UnidadeFederativa();
        Fornecedor fornecedor = new Fornecedor();
        Venda venda = new Venda();
        ItemVenda ivenda = new ItemVenda();
        Medicamento medicamento = new Medicamento();
        PrincipioAtivo pAtivo = new PrincipioAtivo();
        Login login = new Login();
        Date date = new Date();
        
        //Tipo Telefone
        tipotefone.setDescricao("Vivo");
        
        //Telefone
        telefone.setNumeroTelefone((short) 91227508 );
        telefone.setTipostelefones(tipotefone);
        
        //Sexo
        sexo.setSiglaSexo("ASg");
        sexo.setDescricao("Masculino");
        
        //Pessoa
        pessoa.setNome("Alex Bruno Gonçalves Almeida");
        pessoa.setDataNascimento(date);
        pessoa.setCPF((short) 777777777);
        pessoa.setRG("MG-1222222");
        pessoa.setSexos(sexo);
        
        //Funcionario
        funcionario.setPessoa(pessoa);
        funcionario.setSalario((Double) 900.00);
        funcionario.setInicioVigencia(date);
        funcionario.setLogins(login);
        
        //Login
        login.setUsuario("alexbga");
        login.setSenha("fd48fd48fd48fd");
        //Fornecedor 
        fornecedor.setPessoa(pessoa);
        
        //Unidade Federativa
        uf.setUF("MG");
        uf.setNomeDoEstado("São Paulo");
        
        //Endereco
        endereco.setPessoas(pessoa);
        endereco.setCidade("Patos de Minas");
        endereco.setLogradouro("Rua Vicente Amancio da Silva");
        endereco.setCEP((short) 38701000);
        endereco.setNumero((short) 222222);
        endereco.setBairro("Guanabara");
        endereco.setUnidadeFederativas(uf);
        
        //Venda
        venda.setDataVenda(date);
        venda.setFuncionarios(funcionario);
        
        //ItemVenda
        ivenda.setMedicamentos(medicamento);
        ivenda.setVendas(venda);
        ivenda.setValorUnitário((double) 10.0 );
        ivenda.setQuantidade((short) 10);
        
        //Principio Ativo
        pAtivo.setDescricão("Serve para matar");
                
                
                
        //Medicamento
        medicamento.setNomeMedicamento("Remedio 1");
        medicamento.setPrincipiosativos(pAtivo);
        
        
        em.getTransaction().begin();
        
        em.persist(endereco);
        em.persist(pessoa);
        em.persist(funcionario);
        em.persist(fornecedor);
        em.persist(uf);
        em.persist(tipotefone);
        em.persist(sexo);
        em.persist(telefone);
        em.persist(pAtivo);
        em.persist(venda);
        em.persist(ivenda);
        em.persist(medicamento);
        em.persist(login);
        
        em.getTransaction().commit(); //os objetos  do  contexto de persistência são enviados ao banco
    }
    
}
