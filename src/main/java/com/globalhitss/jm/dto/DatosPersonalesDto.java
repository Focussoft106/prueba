package com.globalhitss.jm.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.Date;

import com.globalhitss.jmenumeration.EstadoCivil;
import com.globalhitss.jmenumeration.Genero;

@Data
@ToString
public class DatosPersonalesDto {

	private Long id;
	
	private String identificacion;
	
	private String primerNombre;

	private String segundoNombre;
	
	private String primerApellido;

	private String segundoApellido;
	
	private Date fechaNace;
	
	private Instant fechaCrea;

	private Instant fechaActualiza;
	
	private EstadoCivil estadoCivil;

	private Genero genero;
	
	private String ocupacion;
	
	private Instant fechaFallece;
		

}
