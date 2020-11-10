package ar.edu.davinci.dvds20202cg3.controller.rest;

import ar.edu.davinci.dvds20202cg3.controller.TiendaAppRest;
import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.service.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrendaController extends TiendaAppRest{

    @Autowired
    private PrendaService prendaService;

    @GetMapping(path = "/prendas/all")
    public List<Prenda> getListAll() {
        return prendaService.listAll();
    }

    @GetMapping(path = "/prendas")
    public Page<Prenda> getList(Pageable pageable) {
        return prendaService.list(pageable);
    }

}

