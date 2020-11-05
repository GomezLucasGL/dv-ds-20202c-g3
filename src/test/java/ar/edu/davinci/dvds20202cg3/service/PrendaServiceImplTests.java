package ar.edu.davinci.dvds20202cg3.service;

import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.model.TipoPrenda;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import java.math.BigDecimal;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrendaServiceImplTests {

    @Autowired
    private PrendaService prendaService;

    @Test
    void testListAll(){

        List<Prenda> prendas = prendaService.listAll();

        assertNotNull(prendas, "Prendas es null");
        assertTrue(prendas.size() > 0 , "Prenda esta vacio");

    }

    @Test
    void testList(){
        Pageable pageable = PageRequest.of(0, 2);
        Page<Prenda> prendas = prendaService.list(pageable);

        assertNotNull(prendas, "Prendas es null");
        assertTrue(prendas.getSize() > 0 , "Prenda esta vacio");

    }

    @Test
    void testSave(){

        Prenda prenda = Prenda.builder()
                .descripcion("Tapado")
                .tipo(TipoPrenda.TAPADO)
                .precioBase(BigDecimal.valueOf(240.2D))
                .build();

        Prenda prendaCreada = prendaService.save(prenda);

        assertNotNull(prendaCreada);
        assertEquals(prenda.getDescripcion(), prendaCreada.getDescripcion());

    }

}
