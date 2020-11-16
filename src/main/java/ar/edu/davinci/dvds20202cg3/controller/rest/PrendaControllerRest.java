package ar.edu.davinci.dvds20202cg3.controller.rest;

import ar.edu.davinci.dvds20202cg3.controller.TiendaAppRest;
import ar.edu.davinci.dvds20202cg3.controller.rest.request.PrendaInsertRequest;
import ar.edu.davinci.dvds20202cg3.controller.rest.request.PrendaUpdateRequest;
import ar.edu.davinci.dvds20202cg3.controller.rest.response.PrendaResponse;
import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.service.PrendaService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PrendaControllerRest extends TiendaAppRest{

    @Autowired
    private PrendaService prendaService;

    @Autowired
    private MapperFacade mapper;

    @GetMapping(path = "/prendas/all")
    public List<Prenda> getListAll() {

        return prendaService.listAll();
    }

    @GetMapping(path = "/prendas")
    public Page<PrendaResponse> getList(Pageable pageable) {

        Page<PrendaResponse> prendaResponse = null;
        Page<Prenda> prendas = null;
        try {
            prendas = prendaService.list(pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Object prenda : prendas) {

            ((Prenda)prenda).getPrecioBase();

        }
        try {
            prendaResponse = prendas.map(prenda -> mapper.map(prenda, PrendaResponse.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prendaResponse;
    }

    @GetMapping(path = "/prendas/{id}")
    public PrendaResponse getPrenda(@PathVariable Long id) {

        PrendaResponse prendaResponse = null;
        Prenda prenda = null;
        try {
            prenda = prendaService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            prendaResponse = mapper.map(prenda, PrendaResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prendaResponse;
    }

    @PostMapping(path = "/prendas")
    public ResponseEntity<PrendaResponse> createPrenda(@RequestBody PrendaInsertRequest datosPrenda) {
        Prenda prenda = null;
        PrendaResponse prendaResponse = null;

        // Convertir PrendaInsertRequest en Prenda
        try {
            prenda = mapper.map(datosPrenda, Prenda.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Grabar el nuevo Prenda
        try {
            prenda = prendaService.save(prenda);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

        // Convertir Prenda en PrendaResponse
        try {
            prendaResponse = mapper.map(prenda, PrendaResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(prendaResponse, HttpStatus.CREATED);
    }

    @PutMapping("/prendas/{id}")
    public ResponseEntity<PrendaResponse> updatePrenda(@PathVariable("id") long id,
                                                       @RequestBody PrendaUpdateRequest datosPrenda) {

        Prenda prendaModifar = null;
        Prenda prendaNuevo = null;
        PrendaResponse prendaResponse = null;

        // Convertir PrendaInsertRequest en Prenda
        try {
            prendaNuevo = mapper.map(datosPrenda, Prenda.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        prendaModifar = prendaService.findById(id);

        if (Objects.nonNull(prendaModifar)) {
            prendaModifar.setDescripcion(prendaNuevo.getDescripcion());
            prendaModifar.setTipo(prendaNuevo.getTipo());
            prendaModifar.setPrecioBase(prendaNuevo.getPrecioBase());
            // Grabar el Prenda Nuevo en Prenda a Modificar
            try {
                prendaModifar = prendaService.save(prendaModifar);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Convertir Prenda en PrendaResponse
        try {
            prendaResponse = mapper.map(prendaModifar, PrendaResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(prendaResponse, HttpStatus.OK);
    }

    @DeleteMapping("/prendas/{id}")
    public ResponseEntity<HttpStatus> deletePrenda(@PathVariable("id") Long id) {
        try {
            prendaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}


