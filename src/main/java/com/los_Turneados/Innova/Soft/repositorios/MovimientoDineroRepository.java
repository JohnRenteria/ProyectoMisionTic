package com.los_Turneados.Innova.Soft.repositorios;

import com.los_Turneados.Innova.Soft.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, String> {
}
