package ar.edu.davinci.dvds20202cg3.controller.view;

import ar.edu.davinci.dvds20202cg3.controller.TiendaApp;
import ar.edu.davinci.dvds20202cg3.model.Prenda;
import ar.edu.davinci.dvds20202cg3.service.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrendaController extends TiendaApp {

    @Autowired
    private PrendaService prendaService;


    @GetMapping
    public String viewHomePage(Model model) {
        return "index";
    }

    @GetMapping(path = "prendas/list")
    public String showPrendaPage(Model model) {

        Pageable pageable = PageRequest.of(0, 20);
        Page<Prenda> prendas = prendaService.list(pageable);
        model.addAttribute("listPrendas", prendas);
        return "prendas/list_prendas";
    }

    @GetMapping(path = "/prendas/new")
    public String showNewPrendaPage(Model model) {
        Prenda prenda = new Prenda();
        model.addAttribute("prenda", prenda);
        model.addAttribute("tipoPrendas", prendaService.getTipoPrendas());

        return "prendas/new_prendas";
    }

    @PostMapping(value = "/prendas/save")
    public String savePrenda(@ModelAttribute("prenda") Prenda prenda) {
        prendaService.save(prenda);

        return "redirect:/tienda/prendas/list";
    }

    @RequestMapping(value = "/prendas/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditPrendaPage(@PathVariable(name = "id") Long prendaId) {

        ModelAndView mav = new ModelAndView("prendas/edit_prendas");
        Prenda prenda = prendaService.findById(prendaId);
        mav.addObject("prenda", prenda);
        mav.addObject("tipoPrendas", prendaService.getTipoPrendas());
        mav.addObject("tipoPrendaActual", prenda.getTipo());

        return mav;
    }

    @RequestMapping(value = "/prendas/delete/{id}", method = RequestMethod.GET)
    public String deletePrenda(@PathVariable(name = "id") Long prendaId) {
        prendaService.delete(prendaId);
        return "redirect:/tienda/prendas/list";
    }
}

