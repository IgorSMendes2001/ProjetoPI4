package com.unibus.pi.repository;

import com.unibus.pi.entities.Intinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntinerarioRepository extends JpaRepository <Intinerario,Integer> {
}
