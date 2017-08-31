package br.com.alura.livraria.tx;

import javax.enterprise.inject.Alternative;
import javax.interceptor.InvocationContext;

@Alternative
public class MeuGerenciadorDeTransacao extends TransacionadoPadrao {

	private static final long serialVersionUID = -8590951365580768798L;
	
	@Override
	public Object executaComTransacao(InvocationContext context) {
		
		System.out.println("Abrindo uma transação");
		manager.getTransaction().begin();
		
		try {
			System.out.println("Antes de executar o método interceptor");
			Object resultado = context.proceed();
			
			System.out.println("Antes de commitar a transação");
			manager.getTransaction().commit();
			
			return resultado;
		} catch (Exception e) {
			
			System.out.println("Antes de efetuar o rollback da transacao");
			manager.getTransaction().rollback();
			
			throw new RuntimeException(e);
		}
	}

}
