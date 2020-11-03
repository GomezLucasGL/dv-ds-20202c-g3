package ar.edu.davinci.dvds20202cg3.Service;

import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.repository.PrendaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PrendaServiceImpl implements PrendaService{

    private final PrendaRepository prendaRepository;

    public PrendaServiceImpl(PrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<Prenda> listAll() {
        return prendaRepository.findAll();
    }

    @Override
    public Page<Prenda> list(Pageable pageable) {
        return null;
    }

    @Override
    public Prenda findById(Long id) { return null;
    }

    @Override
    public Prenda save(Prenda prenda) {
        return prendaRepository.save(prenda);
    }

    @Override
    public void delete(Long id) {
        prendaRepository.deleteById(id);
    }
}
