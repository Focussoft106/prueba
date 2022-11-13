package com.globalhitss.jm.entity;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.globalhitss.jmenumeration.EstadoCivil;
import com.globalhitss.jmenumeration.Genero;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "datos_personales")
public class DatosPersonales {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;
	
	@Column(name = "identificacion", length = 15)
	private String identificacion;
	
	@Column(name = "primer_nombre", length = 50)
	private String primerNombre;

	@Column(name = "segundo_nombre", length = 50)
	private String segundoNombre;
	
	@Column(name = "primer_apellido", length = 50)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 50)
	private String segundoApellido;
	
	@Column(name = "fecha_nace")
	private Date fechaNace;
	
	@Column(name = "fecha_crea")
	private Instant fechaCrea;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	private EstadoCivil estadoCivil;

	@Enumerated(EnumType.STRING)
	@Column(name = "genero")
	private Genero genero;
	
	@Column(name = "ocupacion", length = 50)
	private String ocupacion;
	
	@Column(name = "fecha_fallece", length = 50)
	private Instant fechaFallece;

	@Column(name = "fecha_Actualiza")
	private Instant fechaActualiza;
}
