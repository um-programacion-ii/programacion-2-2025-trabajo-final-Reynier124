package com.mycompany.myapp.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Evento.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Evento_ {

	public static final String DESCRIPCION = "descripcion";
	public static final String COLUMNA_ASIENTOS = "columnaAsientos";
	public static final String EVENTO_TIPO_NOMBRE = "eventoTipoNombre";
	public static final String ESTADO = "estado";
	public static final String ULTIMA_ACTUALIZACION = "ultimaActualizacion";
	public static final String DIRECCION = "direccion";
	public static final String TITULO = "titulo";
	public static final String IMAGEN = "imagen";
	public static final String RESUMEN = "resumen";
	public static final String PRECIO_ENTRADA = "precioEntrada";
	public static final String FECHA = "fecha";
	public static final String FILA_ASIENTOS = "filaAsientos";
	public static final String ID = "id";
	public static final String EVENTO_TIPO_DESCRIPCION = "eventoTipoDescripcion";
	public static final String INTEGRANTES = "integrantes";

	
	/**
	 * @see com.mycompany.myapp.domain.Evento#descripcion
	 **/
	public static volatile SingularAttribute<Evento, String> descripcion;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#columnaAsientos
	 **/
	public static volatile SingularAttribute<Evento, Integer> columnaAsientos;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#eventoTipoNombre
	 **/
	public static volatile SingularAttribute<Evento, String> eventoTipoNombre;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#estado
	 **/
	public static volatile SingularAttribute<Evento, String> estado;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#ultimaActualizacion
	 **/
	public static volatile SingularAttribute<Evento, LocalDate> ultimaActualizacion;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#direccion
	 **/
	public static volatile SingularAttribute<Evento, String> direccion;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#titulo
	 **/
	public static volatile SingularAttribute<Evento, String> titulo;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#imagen
	 **/
	public static volatile SingularAttribute<Evento, String> imagen;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#resumen
	 **/
	public static volatile SingularAttribute<Evento, String> resumen;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#precioEntrada
	 **/
	public static volatile SingularAttribute<Evento, Double> precioEntrada;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#fecha
	 **/
	public static volatile SingularAttribute<Evento, LocalDate> fecha;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#filaAsientos
	 **/
	public static volatile SingularAttribute<Evento, Integer> filaAsientos;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#id
	 **/
	public static volatile SingularAttribute<Evento, Long> id;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#eventoTipoDescripcion
	 **/
	public static volatile SingularAttribute<Evento, String> eventoTipoDescripcion;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento
	 **/
	public static volatile EntityType<Evento> class_;
	
	/**
	 * @see com.mycompany.myapp.domain.Evento#integrantes
	 **/
	public static volatile SetAttribute<Evento, Integrantes> integrantes;

}

