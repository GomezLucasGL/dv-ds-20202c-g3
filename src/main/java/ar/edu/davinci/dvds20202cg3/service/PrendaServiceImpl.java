package ar.edu.davinci.dvds20202cg3.service;

import java.util.List;
import java.util.Optional;

import ar.edu.davinci.dvds20202cg3.model.TipoPrenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.repository.PrendaRepository;
import org.springframework.stereotype.Service;

@Service
public class PrendaServiceImpl implements PrendaService {

    private final PrendaRepository prendaRepository;

    @Autowired
    public PrendaServiceImpl(final PrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<Prenda> listAll() {
        return prendaRepository.findAll();
    }

    @Override
    public Page<Prenda> list(Pageable pageable) {
        return prendaRepository.findAll(pageable);
    }

    @Override
    public Prenda findById(Long id) {
        Optional<Prenda> prendaOptional = prendaRepository.findById(id);
        if (prendaOptional.isPresent()) {
            return prendaOptional.get();
        }
        return null;
    }

    @Override
    public Prenda save(Prenda prenda) {
        return prendaRepository.save(prenda);
    }

    @Override
    public void delete(Prenda prenda) {
        prendaRepository.delete(prenda);
    }

    @Override
    public void delete(Long id) {
        prendaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return prendaRepository.count();
    }

    @Override
    public List<TipoPrenda> getTipoPrendas() {
        return TipoPrenda.getTipoPrendas();
    }


}

