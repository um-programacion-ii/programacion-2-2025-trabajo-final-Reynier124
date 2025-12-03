package com.mycompany.myapp.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Asientos.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Asientos_ {

	public static final String COLUMNA = "columna";
	public static final String ESTADO = "estado";
	public static final String VENTA = "venta";
	public static final String PERSONA = "persona";
	public static final String SESION = "sesion";
	public static final String FILA = "fila";
	public static final String ID = "id";

	
	/**
	 * @see com.mycompany.myapp.domain.Asientos#columna
	 **/
	public static volatile SingularAttribute<Asientos, Integer> columna;
	
	/**
	 * @see com.mycompany.myapp.domain.Asientos#estado
	 **/
	public static volatile SingularAttribute<Asientos, String> estado;
	
	/**
	 * @see com.mycompany.myapp.domain.Asientos#venta
	 **/
	public static volatile SingularAttribute<Asientos, Venta> venta;
	
	/**
	 * @see com.mycompany.myapp.domain.Asientos#persona
	 **/
	public static volatile SingularAttribute<Asientos, String> persona;
	
	/**
	 * @see com.mycompany.myapp.domain.Asientos#sesion
	 **/
	public static volatile SingularAttribute<Asientos, Sesion> sesion;
	
	/**
	 * @see com.mycompany.myapp.domain.Asientos#fila
	 **/
	public static volatile SingularAttribute<Asientos, Integer> fila;
	
	/**
	 * @see com.mycompany.myapp.domain.Asientos#id
	 **/
	public static volatile SingularAttribute<Asientos, Long> id;
	
	/**
	 * @see com.mycompany.myapp.domain.Asientos
	 **/
	public static volatile EntityType<Asientos> class_;

}

