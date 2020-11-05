package ar.edu.davinci.dvds20202cg3.service;

import ar.edu.davinci.dvds20202cg3.model.Prenda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PrendaService {

    public List<Prenda> listAll();
    public Page<Prenda> list(Pageable pageable);
    public Prenda findById(Long id);
    public Prenda save(Prenda prenda);
    public void delete(Prenda prenda);

}
