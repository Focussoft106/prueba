package com.globalhitss.jm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.globalhitss.jm.constantes.ErrorConstant;
import com.globalhitss.jm.dto.DatosPersonalesDto;
import com.globalhitss.jm.service.declare.DatosPersonalesService;
import com.globalhitss.jm.util.Message;

@RestController
@RequestMapping("/api")
public class DatosPersonalesRest {
    @Autowired
    public DatosPersonalesService datosPersonalesService;
    
    @GetMapping("/datos-personales")
    public ResponseEntity<List<DatosPersonalesDto>> getDatosPersonales(){
        try {
            List<DatosPersonalesDto> datosPersonalesDtos = datosPersonalesService.allDatosPersonalesDtos();
            return new ResponseEntity<>(datosPersonalesDtos, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/datos-personales")
	public ResponseEntity<DatosPersonalesDto> saveDatosPersonales(@RequestBody DatosPersonalesDto datosPersonalesDto){
		try {
			if (Boolean.TRUE.equals(datosPersonalesService.validaExistDatosPersonales(datosPersonalesDto.getIdentificacion()))){
				Message message = new Message();
				ErrorConstant errorConstant = new ErrorConstant();
				message.setType(errorConstant.tipoMensajeError);
				message.setMenssage(errorConstant.mensajeErrorDatosGuardados);
				return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
			}
			return ResponseEntity.ok(datosPersonalesService.save(datosPersonalesDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/datos-personales/{id}")
	public ResponseEntity<DatosPersonalesDto> getOneDatosPersonales(@PathVariable Long id){
		try {
			return ResponseEntity.ok(datosPersonalesService.getOneDatosPersonalesById(id));
		}
		catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/datos-personales/{id}")
	public ResponseEntity<DatosPersonalesDto> updateDatosPersonales(@RequestBody DatosPersonalesDto datosPersonalesDto, @PathVariable Long id){
		try {
			return ResponseEntity.ok(datosPersonalesService.update(datosPersonalesDto, id));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/datos-personales/{id}")
	public ResponseEntity<DatosPersonalesDto> deleteDatosPersonales(@PathVariable Long id){
		try {
			datosPersonalesService.deleteDatosPersonalesById(id);
				Message message = new Message();
				message.setMenssage("Dato eliminado");
				message.setMenssage("success");
				return new ResponseEntity(message, HttpStatus.OK);
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
