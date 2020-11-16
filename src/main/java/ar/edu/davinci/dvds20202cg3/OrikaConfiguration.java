package ar.edu.davinci.dvds20202cg3;

import ar.edu.davinci.dvds20202cg3.controller.rest.request.PrendaInsertRequest;
import ar.edu.davinci.dvds20202cg3.controller.rest.request.PrendaUpdateRequest;
import ar.edu.davinci.dvds20202cg3.controller.rest.response.PrendaResponse;
import ar.edu.davinci.dvds20202cg3.model.Prenda;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.context.MappingContext;

@Configuration
public class OrikaConfiguration {

    private final ObjectMapper objectMapper;

    public OrikaConfiguration() {
        objectMapper = new ObjectMapper();
    }

    @Bean
    public MapperFacade mapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(Prenda.class, PrendaInsertRequest.class).byDefault().register();
        mapperFactory.classMap(Prenda.class, PrendaUpdateRequest.class).byDefault().register();
        mapperFactory.classMap(Prenda.class, PrendaResponse.class)
                .customize(new CustomMapper<Prenda, PrendaResponse>() {
                    public void mapAtoB(final Prenda prenda, final PrendaResponse prendaResponse, final MappingContext context) {
                        prendaResponse.setId(prenda.getId());
                        prendaResponse.setDescripcion(prenda.getDescripcion());
                        prendaResponse.setTipo(prenda.getTipo().getDescripcion());
                        prendaResponse.setPrecioBase(prenda.getPrecioBase());
                    }
                }).register();


        return mapperFactory.getMapperFacade();
    }
}

