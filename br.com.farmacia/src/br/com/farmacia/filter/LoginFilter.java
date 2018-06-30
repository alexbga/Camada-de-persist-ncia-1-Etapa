package br.com.farmacia.filter;

import java.io.IOException;

import javax.faces.bean.ManagedProperty;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controllers.LoginController;

public class LoginFilter implements Filter {
	
	@ManagedProperty(value = "#{loginController}")
	private LoginController LoginController;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		LoginController loginBean = (LoginController)((HttpServletRequest)request).getSession(false).getAttribute("loginController");
		
		if (loginBean == null || loginBean.getUsuarioLogado() == null){
			((HttpServletResponse)response).sendRedirect("http://localhost:8080/br.com.farmacia/login.xhtml");
		}
		chain.doFilter(request, response);
	}
	

}