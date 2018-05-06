package br.com.farmacia.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

public class GenericEJB<T> {
    
    @PersistenceContext
    protected EntityManager em;
    
    private Class<T> classe;
    
    public GenericEJB(Class<T> classe){
        this.classe = classe;
    }
    
    public String salvar(T entidade) {
        try {
            em.merge(entidade);
        } catch (Exception ex) {
            return "Erro ao salvar: " + ex.getMessage();
        }
        return null;
    }
    
    public T consultarPorId(Serializable id){
        T entidade = em.find(classe, id);
        return entidade;
    }
    
    
    public String excluir(Serializable id){
        try{
            T entidade = consultarPorId(id);
            em.remove(entidade);            
            return null;
        }catch(Exception ex){
            return "Erro ao excluir " + ex.getMessage();
        }
    }
    
    public List<T> todos(){
        String nomeClasse = classe.getSimpleName();
        TypedQuery<T> query = em.createQuery("select m from "+nomeClasse+" as m", classe);
        return query.getResultList();
    }
    
    
    
}
