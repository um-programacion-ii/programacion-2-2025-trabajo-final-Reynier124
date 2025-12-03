package com.mycompany.myapp.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Usuario.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Usuario_ {

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PASSWORD = "password";
	public static final String FECHA_REGISTRO = "fechaRegistro";
	public static final String NOMBRE_ALUMNO = "nombreAlumno";
	public static final String DESCRIPCION_PROYECTO = "descripcionProyecto";
	public static final String JWT_TOKEN = "jwtToken";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#firstName
	 **/
	public static volatile SingularAttribute<Usuario, String> firstName;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#lastName
	 **/
	public static volatile SingularAttribute<Usuario, String> lastName;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#password
	 **/
	public static volatile SingularAttribute<Usuario, String> password;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#fechaRegistro
	 **/
	public static volatile SingularAttribute<Usuario, LocalDate> fechaRegistro;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#nombreAlumno
	 **/
	public static volatile SingularAttribute<Usuario, String> nombreAlumno;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#descripcionProyecto
	 **/
	public static volatile SingularAttribute<Usuario, String> descripcionProyecto;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#jwtToken
	 **/
	public static volatile SingularAttribute<Usuario, String> jwtToken;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#id
	 **/
	public static volatile SingularAttribute<Usuario, Long> id;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario
	 **/
	public static volatile EntityType<Usuario> class_;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#email
	 **/
	public static volatile SingularAttribute<Usuario, String> email;
	
	/**
	 * @see com.mycompany.myapp.domain.Usuario#username
	 **/
	public static volatile SingularAttribute<Usuario, String> username;

}

