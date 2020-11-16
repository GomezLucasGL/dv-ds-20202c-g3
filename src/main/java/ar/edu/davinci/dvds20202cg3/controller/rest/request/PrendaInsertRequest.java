package ar.edu.davinci.dvds20202cg3.controller.rest.request;


import ar.edu.davinci.dvds20202cg3.model.TipoPrenda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrendaInsertRequest {

    private BigDecimal precioBase;

    private TipoPrenda tipo;

    private String descripcion;

}
