package ar.edu.davinci.dvds20202cg3.repository;

import ar.edu.davinci.dvds20202cg3.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaEfectivoRepository extends JpaRepository<Venta, Long> {
}
