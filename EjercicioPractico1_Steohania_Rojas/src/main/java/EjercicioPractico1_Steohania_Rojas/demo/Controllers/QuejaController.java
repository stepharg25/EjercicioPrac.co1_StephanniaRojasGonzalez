package EjercicioPractico1_Steohania_Rojas.demo.Controllers;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Queja;
import EjercicioPractico1_Steohania_Rojas.demo.Service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaService quejaService;

    // Mostrar formulario de quejas/sugerencias
    @GetMapping("/formulario")
    public String mostrarFormularioQueja(Model model) {
        Queja queja = new Queja();
        model.addAttribute("queja", queja);
        model.addAttribute("tituloPagina", "Quejas y Sugerencias");
        return "quejas/formulario";
    }

    // Procesar queja/sugerencia
    @PostMapping("/guardar")
    public String guardarQueja(@ModelAttribute("queja") Queja queja, 
                              RedirectAttributes redirectAttributes) {
        quejaService.save(queja);
        redirectAttributes.addFlashAttribute("mensaje", 
            "¡Gracias por tu feedback! Hemos recibido tu " + queja.getTipo().toString().toLowerCase() + ".");
        return "redirect:/quejas/formulario";
    }
}