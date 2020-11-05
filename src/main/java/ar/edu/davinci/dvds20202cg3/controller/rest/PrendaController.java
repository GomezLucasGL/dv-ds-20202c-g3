package ar.edu.davinci.dvds20202cg3.controller.rest;

import ar.edu.davinci.dvds20202cg3.controller.TiendaAppRest;
import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.service.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrendaController extends TiendaAppRest {

    @Autowired
    private PrendaService prendaService;

    @GetMapping(name = "/prendas")
    public List<Prenda> getListAll() {

        return prendaService.listAll();

    }

}
