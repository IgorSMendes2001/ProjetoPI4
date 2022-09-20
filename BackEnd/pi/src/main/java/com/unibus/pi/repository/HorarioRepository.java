package com.unibus.pi.repository;

import com.unibus.pi.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Integer> {
    public Horario getHorarioByDiaSemana(Integer diaSemana);
}
