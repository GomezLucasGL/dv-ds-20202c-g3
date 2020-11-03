package ar.edu.davinci.dvds20202cg3.repository;

import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.model.TipoPrenda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert.*;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PrendaRepositoryTests {

    @Autowired
    private PrendaRepository prendaRepository;

    @Test
    void testFindAll(){

        assertNotNull(prendaRepository, "El repositorio es null");
        List<Prenda> prendas = prendaRepository.findAll();

        assertNotNull(prendas, "La Lista es null");
        assertTrue(prendas.size() > 0, "No existen prendas");

    }

    @Test
    void testFindAllById(){

        Long id = 4L;

        Optional<Prenda> prendaOptional = prendaRepository.findById(id);

        if(prendaOptional.isPresent()){
            Prenda prenda = prendaOptional.get();

            assertEquals(TipoPrenda.PANTALON, prenda.getTipo());
        }


    }

}
