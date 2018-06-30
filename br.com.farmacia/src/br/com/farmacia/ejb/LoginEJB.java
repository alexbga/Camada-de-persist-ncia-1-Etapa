package br.com.farmacia.ejb;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.ejb.Stateless;
import br.com.farmacia.entity.Login;


@Stateless
public class LoginEJB extends GenericEJB<Login> {
    public LoginEJB(){
        super(Login.class);
    }


    public Login login(String email, String senha) {
    	try {
    		 TypedQuery<Login> query = em.createQuery("select m from Login as m"
    	          		+ " where m.login = :login and m.senha = :senha", Login.class);
    	          query.setParameter("login", email);
    	          query.setParameter("senha", senha);
    	          return query.getSingleResult();
    	}catch (NoResultException e) {
			return null;
		}
         
    }
}
