package ar.edu.davinci.dvds20202cg3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.davinci.dvds20202cg3.model.Prenda;


@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {

}