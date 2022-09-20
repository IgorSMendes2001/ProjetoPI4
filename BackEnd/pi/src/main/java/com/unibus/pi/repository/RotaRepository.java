package com.unibus.pi.repository;

import com.unibus.pi.entities.Rota;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RotaRepository extends JpaRepository<Rota, Integer> {
    public Rota findByNome(String nome);

    @Query("FROM Rota r " +
    "WHERE LOWER(r.nome) like %:termo% ")
    public Page<Rota> search(@Param("termo")String termo, Pageable pageRequest);
     
}
