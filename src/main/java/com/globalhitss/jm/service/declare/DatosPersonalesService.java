package com.globalhitss.jm.service.declare;

import java.util.List;

import com.globalhitss.jm.dto.DatosPersonalesDto;

public interface DatosPersonalesService {
    List<DatosPersonalesDto> allDatosPersonalesDtos();

    DatosPersonalesDto save(DatosPersonalesDto datosPersonalesDto);

    DatosPersonalesDto getOneDatosPersonalesById(Long id);

    void deleteDatosPersonalesById(Long id);

    DatosPersonalesDto update(DatosPersonalesDto datosPersonalesDto, Long id);

    Boolean validaExistDatosPersonales(String nombreDatosPersonales);
}
