package com.mycompany.myapp.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Integrantes.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Integrantes_ {

	public static final String EVENTO = "evento";
	public static final String APELLIDO = "apellido";
	public static final String IDENTIFICACION = "identificacion";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.mycompany.myapp.domain.Integrantes#evento
	 **/
	public static volatile SingularAttribute<Integrantes, Evento> evento;
	
	/**
	 * @see com.mycompany.myapp.domain.Integrantes#apellido
	 **/
	public static volatile SingularAttribute<Integrantes, String> apellido;
	
	/**
	 * @see com.mycompany.myapp.domain.Integrantes#identificacion
	 **/
	public static volatile SingularAttribute<Integrantes, String> identificacion;
	
	/**
	 * @see com.mycompany.myapp.domain.Integrantes#id
	 **/
	public static volatile SingularAttribute<Integrantes, Long> id;
	
	/**
	 * @see com.mycompany.myapp.domain.Integrantes
	 **/
	public static volatile EntityType<Integrantes> class_;
	
	/**
	 * @see com.mycompany.myapp.domain.Integrantes#nombre
	 **/
	public static volatile SingularAttribute<Integrantes, String> nombre;

}

