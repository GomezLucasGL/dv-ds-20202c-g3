package ar.edu.davinci.dvds20202cg3.Service;

import ar.edu.davinci.dvds20202cg3.model.Prenda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrendaService {

    public List<Prenda> listAll();
    public Page<Prenda> list(Pageable pageable);
    public Prenda findById(Long id);
    public Prenda save(Prenda prenda);
    public void delete(Long id);

}
