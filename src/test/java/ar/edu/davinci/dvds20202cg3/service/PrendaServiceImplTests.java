package ar.edu.davinci.dvds20202cg3.service;

import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.model.TipoPrenda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PrendaServiceImplTests {

    @Autowired
    private PrendaService prendaService;

    @Test
    void testListAll() {

        List<Prenda> prendas = prendaService.listAll();


        assertNotNull(prendas, "Prendas es nulo");
        assertTrue(prendas.size() > 0, "Prendas está vacio");

    }

    @Test
    void testList() {

        Pageable pageable = PageRequest.of(0, 2);
        Page<Prenda> prendas = prendaService.list(pageable);


        Pageable pageable1 = PageRequest.of(1, 2);
        Page<Prenda> prendas1 = prendaService.list(pageable1);


        assertNotNull(prendas, "Prendas es nulo");
        assertTrue(prendas.getSize() > 0, "Prendas está vacio");
    }

    @Test
    void testFindById() {
        Prenda prenda = prendaService.findById(4L);

        assertNotNull(prenda);
        assertEquals(prenda.getDescripcion(), "Pantalon Gabardina Beige");
    }

    @Test
    void testFindById_withError() {
        Prenda prenda = prendaService.findById(0L);

        assertNull(prenda);
    }

    @Test
    void testSave() {


        Prenda prenda = Prenda.builder()
                .descripcion("Tapado Negro")
                .tipo(TipoPrenda.TAPADO)
                .precioBase(BigDecimal.valueOf(234.54D))
                .build();

        Prenda prendaCreada = prendaService.save(prenda);

        assertNotNull(prendaCreada);
        assertEquals(prenda.getDescripcion(), prendaCreada.getDescripcion());




    }

    @Test
    void testDelete() {



        Prenda prenda = prendaService.findById(2L);
        prendaService.delete(prenda);



    }

}
