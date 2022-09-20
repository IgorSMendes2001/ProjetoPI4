package com.unibus.pi.repository;

import com.unibus.pi.entities.Intinerario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IntinerarioRepository extends JpaRepository <Intinerario,Integer> {
    public Intinerario findByPontoInicial(String pontoInicial);

    public Intinerario findByPontoFinal(String pontoFinal);

    @Query("FROM Intinerario h " +
    "WHERE LOWER(h.pontoInicial) like %:termo% " +
    "OR LOWER(h.pontoFinal) like %:termo%" 
    // +
    // "OR LOWER(h.percurso) like %:termo%"
    )
    public Page<Intinerario> search(@Param("termo")String termo, Pageable pageRequest);


}
