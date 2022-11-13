package com.globalhitss.jm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.globalhitss.jm.entity.DatosPersonales;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, Long>{

    @Query("select dp from DatosPersonales dp where dp.identificacion = ?1")
    List<DatosPersonales> findClienteByIdentificacion(String identificacion);
}
