package com.unibus.pi.repository;

import com.unibus.pi.entities.Horario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Integer> {
    public Horario getHorarioByDiaSemana(Integer diaSemana);

    @Query("FROM Horario h " +
    "WHERE LOWER(h.horarios) like %:termo% ")
    public Page<Horario> search(@Param("termo")String termo, Pageable pageRequest);
}
