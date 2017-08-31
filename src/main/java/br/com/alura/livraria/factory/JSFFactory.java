package br.com.alura.livraria.factory;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.alura.livraria.jsf.annotation.ScopeMap;
import br.com.alura.livraria.jsf.annotation.ScopeMap.Scope;

public class JSFFactory {
	
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public Flash getFlash() {
		return getExternalContext().getFlash();
	}
	
	@Produces
	@ScopeMap(Scope.SESSION)
	public Map<String, Object> sessionMap(){
		return getExternalContext().getSessionMap();
	}

	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
	@Produces
	@ScopeMap(Scope.REQUEST)
	public Map<String, Object> requestMap(){
		return getExternalContext().getRequestMap();
	}
	
	@Produces
	@ScopeMap(Scope.APPLICATION)
	public Map<String, Object> applicationMap() {
		return getExternalContext().getApplicationMap();
	}
	
	@Produces
	public NavigationHandler navigationHandler() {
		return getFacesContext().getApplication().getNavigationHandler();
	}
}
