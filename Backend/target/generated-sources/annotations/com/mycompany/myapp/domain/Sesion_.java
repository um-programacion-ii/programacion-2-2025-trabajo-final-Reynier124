package com.mycompany.myapp.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Sesion.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Sesion_ {

	public static final String ULTIMA_ACTIVIDAD = "ultimaActividad";
	public static final String EVENTO_SELECCIONADO = "eventoSeleccionado";
	public static final String ASIENTOS_SELECCIONADOS = "asientosSeleccionados";
	public static final String ASIENTOS = "asientos";
	public static final String EXPIRA_EN = "expiraEn";
	public static final String ID = "id";
	public static final String ESTADO_FLUJO = "estadoFlujo";
	public static final String TOKEN = "token";

	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#ultimaActividad
	 **/
	public static volatile SingularAttribute<Sesion, LocalDate> ultimaActividad;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#eventoSeleccionado
	 **/
	public static volatile SingularAttribute<Sesion, Long> eventoSeleccionado;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#asientosSeleccionados
	 **/
	public static volatile SingularAttribute<Sesion, String> asientosSeleccionados;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#asientos
	 **/
	public static volatile SetAttribute<Sesion, Asientos> asientos;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#expiraEn
	 **/
	public static volatile SingularAttribute<Sesion, LocalDate> expiraEn;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#id
	 **/
	public static volatile SingularAttribute<Sesion, Long> id;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion
	 **/
	public static volatile EntityType<Sesion> class_;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#estadoFlujo
	 **/
	public static volatile SingularAttribute<Sesion, String> estadoFlujo;
	
	/**
	 * @see com.mycompany.myapp.domain.Sesion#token
	 **/
	public static volatile SingularAttribute<Sesion, String> token;

}

