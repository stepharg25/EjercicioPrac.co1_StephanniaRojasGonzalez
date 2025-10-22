package EjercicioPractico1_Steohania_Rojas.demo.Controllers;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Libro;
import EjercicioPractico1_Steohania_Rojas.demo.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private LibroService libroService;

    // Página de inicio
    @GetMapping("/")
    public String home(Model model) {
        // Obtener algunos libros para mostrar en la página principal
        List<Libro> librosDestacados = libroService.findDisponibles();
        
        model.addAttribute("librosDestacados", librosDestacados);
        model.addAttribute("tituloPagina", "Biblioteca Digital");
        return "home";
    }

    // Acerca de
    @GetMapping("/acerca")
    public String acerca(Model model) {
        model.addAttribute("tituloPagina", "Acerca de Nosotros");
        return "acerca";
    }
}