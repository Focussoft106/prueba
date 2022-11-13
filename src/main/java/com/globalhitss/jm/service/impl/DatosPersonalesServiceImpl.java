package com.globalhitss.jm.service.impl;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalhitss.jm.dto.DatosPersonalesDto;
import com.globalhitss.jm.entity.DatosPersonales;
import com.globalhitss.jm.mapper.DatosPersonalesMapper;
import com.globalhitss.jm.repository.DatosPersonalesRepository;
import com.globalhitss.jm.service.declare.DatosPersonalesService;

@Service
public class DatosPersonalesServiceImpl implements DatosPersonalesService{

    @Autowired
    private DatosPersonalesMapper datosPersonalesMapper;

    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;

    @Override
    public List<DatosPersonalesDto> allDatosPersonalesDtos() {
        try {
			List<DatosPersonales> listaDatosPersonales = datosPersonalesRepository.findAll();
			return datosPersonalesMapper.toDto(listaDatosPersonales);
		} catch (Exception e) {
			return Collections.emptyList();
		}
    }

    @Override
    public DatosPersonalesDto save(DatosPersonalesDto datosPersonalesDto) {
        DatosPersonales datosPersonales = datosPersonalesMapper.toEntity(datosPersonalesDto);
		datosPersonales.setFechaCrea(Instant.now());
		return datosPersonalesMapper.toDto(datosPersonalesRepository.save(datosPersonales));
    }

    @Override
    public DatosPersonalesDto getOneDatosPersonalesById(Long id) {
		DatosPersonales datosPersonales = datosPersonalesRepository.getReferenceById(id);
		return datosPersonalesMapper.toDto(datosPersonales);
    }

    @Override
    public DatosPersonalesDto update(DatosPersonalesDto datosPersonalesDto, Long id) {
        DatosPersonales datosPersonales = datosPersonalesRepository.getReferenceById(id);
        if (datosPersonales != null){
            datosPersonales.setIdentificacion(datosPersonalesDto.getIdentificacion());
            datosPersonales.setPrimerNombre(datosPersonalesDto.getPrimerNombre());
            datosPersonales.setSegundoNombre(datosPersonalesDto.getSegundoNombre());
            datosPersonales.setPrimerApellido(datosPersonalesDto.getPrimerApellido());
            datosPersonales.setSegundoApellido(datosPersonalesDto.getSegundoApellido());
            datosPersonales.setFechaNace(datosPersonalesDto.getFechaNace());
            datosPersonales.setFechaActualiza(Instant.now());
            datosPersonales.setEstadoCivil(datosPersonalesDto.getEstadoCivil());
            datosPersonales.setGenero(datosPersonalesDto.getGenero());
            datosPersonales.setOcupacion(datosPersonalesDto.getOcupacion());
            datosPersonales.setFechaFallece(datosPersonalesDto.getFechaFallece());
            return datosPersonalesMapper.toDto(datosPersonalesRepository.save(datosPersonales));
        }
        return null;
    }

    @Override
    public Boolean validaExistDatosPersonales(String nombreDatosPersonales) {
		List<DatosPersonales> listaDatosPersonales = datosPersonalesRepository.findClienteByIdentificacion(nombreDatosPersonales);
        Boolean success = false;
        if (!listaDatosPersonales.isEmpty()){
            success = true;
        } 
        return success;
    }

    @Override
    public void deleteDatosPersonalesById(Long id){
        datosPersonalesRepository.deleteById(id);
    }
}
