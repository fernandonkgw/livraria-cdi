package br.com.alura.livraria.bean;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.com.alura.livraria.dao.UsuarioDao;
import br.com.alura.livraria.helper.MessageHelper;
import br.com.alura.livraria.jsf.annotation.ScopeMap;
import br.com.alura.livraria.jsf.annotation.ScopeMap.Scope;
import br.com.alura.livraria.modelo.Usuario;

@Model
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	
	private UsuarioDao usuarioDAO;

	private MessageHelper helper;

	private Map<String, Object> sessionMap;

	@Inject
	public LoginBean(UsuarioDao usuarioDAO, MessageHelper helper, @ScopeMap(Scope.SESSION) Map<String, Object> sessionMap) {
		this.usuarioDAO = usuarioDAO;
		this.helper = helper;
		this.sessionMap = sessionMap;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		System.out.println("fazendo login do usuario " + this.usuario.getEmail());
		
		boolean existe = usuarioDAO.existe(this.usuario);
		if(existe ) {
			sessionMap.put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}
		
		helper
			.onFlash()
			.addMessage(new FacesMessage("Usuário não encontrado"));
		
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		sessionMap.remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
