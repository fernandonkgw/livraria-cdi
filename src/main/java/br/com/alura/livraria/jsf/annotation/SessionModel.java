package br.com.alura.livraria.jsf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

@Stereotype
@Named
@SessionScoped
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface SessionModel {

}
