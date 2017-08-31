package br.com.alura.livraria.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.livraria.jpa.annotation.Query;

public class TypedQueryFactory {

	@Inject
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Produces
	@Query("")
	public <X> TypedQuery<X> factory(InjectionPoint point){
		
		ParameterizedType type = (ParameterizedType) point.getType();
		
		@SuppressWarnings("rawtypes")
		Class classe = (Class) type.getActualTypeArguments()[0];
		
		String jpql = point.getAnnotated().getAnnotation(Query.class).value();
		return em.createQuery(jpql, classe);
	}
}
