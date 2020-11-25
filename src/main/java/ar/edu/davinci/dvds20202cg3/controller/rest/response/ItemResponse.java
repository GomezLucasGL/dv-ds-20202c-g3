package ar.edu.davinci.dvds20202cg3.controller.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponse {

    private Long id;

    private Integer cantidad;

    private PrendaResponse prenda;

    private BigDecimal importe;

}
