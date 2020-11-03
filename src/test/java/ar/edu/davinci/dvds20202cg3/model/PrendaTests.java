package ar.edu.davinci.dvds20202cg3.model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTests {

    @Test
    void testBuilder() {

        Long id = 1L;
        String camisa = "camisa";
        TipoPrenda tipo = TipoPrenda.CAMISA;
        BigDecimal precio = new BigDecimal(10.2D);

        Prenda testPrenda = new Prenda(1L,new BigDecimal(10.2D),TipoPrenda.CAMISA, "camisa");

     assertNotNull(testPrenda);
     assertEquals(id, testPrenda.getId());

    }
}
