package ar.edu.davinci.dvds20202cg3.controller.rest.request;

import ar.edu.davinci.dvds20202cg3.controller.rest.response.PrendaResponse;
import ar.edu.davinci.dvds20202cg3.model.Prenda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemInsertRequest {

    private Integer cantidad;

    private Long prendaId;

}
