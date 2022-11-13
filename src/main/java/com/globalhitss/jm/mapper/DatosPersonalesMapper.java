package com.globalhitss.jm.mapper;

import org.mapstruct.Mapper;
import com.globalhitss.jm.dto.DatosPersonalesDto;
import com.globalhitss.jm.entity.DatosPersonales;

@Mapper(componentModel = "spring", uses = {})
public interface DatosPersonalesMapper extends EntityMapper<DatosPersonalesDto, DatosPersonales>{

    default DatosPersonales fromId(Long id){
    	if (id == null) {
            return null;
        }
    	DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setId(id);
        return datosPersonales;
    }
    
}
