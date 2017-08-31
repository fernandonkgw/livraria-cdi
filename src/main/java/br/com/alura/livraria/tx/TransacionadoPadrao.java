package br.com.alura.livraria.tx;

import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Typed(Transacionado.class)
public class TransacionadoPadrao implements Transacionado {

	private static final long serialVersionUID = 2092976079201998298L;

	@Inject
	protected EntityManager manager;

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
