package com.mycompany.myapp.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Venta.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Venta_ {

	public static final String DESCRIPCION = "descripcion";
	public static final String ESTADO = "estado";
	public static final String VENTA_ID_CATEDRA = "ventaIdCatedra";
	public static final String RESULTADO = "resultado";
	public static final String ASIENTOS = "asientos";
	public static final String CANTIDAD_ASIENTOS = "cantidadAsientos";
	public static final String ID = "id";
	public static final String PRECIO_VENTA = "precioVenta";
	public static final String FECHA_VENTA = "fechaVenta";

	
	/**
	 * @see com.mycompany.myapp.domain.Venta#descripcion
	 **/
	public static volatile SingularAttribute<Venta, String> descripcion;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#estado
	 **/
	public static volatile SingularAttribute<Venta, String> estado;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#ventaIdCatedra
	 **/
	public static volatile SingularAttribute<Venta, Long> ventaIdCatedra;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#resultado
	 **/
	public static volatile SingularAttribute<Venta, Boolean> resultado;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#asientos
	 **/
	public static volatile SetAttribute<Venta, Asientos> asientos;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#cantidadAsientos
	 **/
	public static volatile SingularAttribute<Venta, Integer> cantidadAsientos;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#id
	 **/
	public static volatile SingularAttribute<Venta, Long> id;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#precioVenta
	 **/
	public static volatile SingularAttribute<Venta, Double> precioVenta;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta
	 **/
	public static volatile EntityType<Venta> class_;
	
	/**
	 * @see com.mycompany.myapp.domain.Venta#fechaVenta
	 **/
	public static volatile SingularAttribute<Venta, LocalDate> fechaVenta;

}

