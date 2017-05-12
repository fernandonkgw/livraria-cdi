package br.com.alura.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.alura.livraria.tx.annotation.Transacional;

@Interceptor
@Transacional
public class GerenciadorDeTransacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public GerenciadorDeTransacao(EntityManager manager) {
		this.manager = manager;
	}
	
	@AroundInvoke
	public Object executaComTransacao(InvocationContext context) {
		manager.getTransaction().begin();
		
		try {
			Object resultado = context.proceed();
			manager.getTransaction().commit();
			
			return resultado;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		
		
	}
}
