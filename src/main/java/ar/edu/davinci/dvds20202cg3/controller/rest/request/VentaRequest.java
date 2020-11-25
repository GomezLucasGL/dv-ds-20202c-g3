package ar.edu.davinci.dvds20202cg3.controller.rest.request;

import ar.edu.davinci.dvds20202cg3.controller.rest.response.ClienteResponse;
import ar.edu.davinci.dvds20202cg3.controller.rest.response.ItemResponse;
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
@SuperBuilder
public class VentaRequest {

    private Long clienteId;

    private String tipoVenta;

}
