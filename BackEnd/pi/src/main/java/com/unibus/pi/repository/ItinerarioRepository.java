package com.unibus.pi.repository;

import com.unibus.pi.entities.Itinerario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItinerarioRepository extends JpaRepository <Itinerario,Integer> {
    public Itinerario findByPontoInicial(String pontoInicial);

    public Itinerario findByPontoFinal(String pontoFinal);

    @Query("FROM Itinerario h " +
    "WHERE LOWER(h.pontoInicial) like %:termo% " +
    "OR LOWER(h.pontoFinal) like %:termo%" 
    // +
    // "OR LOWER(h.percurso) like %:termo%"
    )
    public Page<Itinerario> search(@Param("termo")String termo, Pageable pageRequest);


}
