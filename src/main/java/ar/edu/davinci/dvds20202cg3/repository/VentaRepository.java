package ar.edu.davinci.dvds20202cg3.repository;

import ar.edu.davinci.dvds20202cg3.model.VentaEfectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<VentaEfectivo, Long> {
}

