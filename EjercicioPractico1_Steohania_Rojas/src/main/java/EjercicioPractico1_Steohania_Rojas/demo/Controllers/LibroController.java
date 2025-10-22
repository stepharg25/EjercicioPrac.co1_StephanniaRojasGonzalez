package EjercicioPractico1_Steohania_Rojas.demo.Controllers;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Libro;
import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import EjercicioPractico1_Steohania_Rojas.demo.Service.LibroService;
import EjercicioPractico1_Steohania_Rojas.demo.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private CategoriaService categoriaService;

    // Página principal - lista todos los libros
    @GetMapping
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.findAll();
        model.addAttribute("libros", libros);
        model.addAttribute("tituloPagina", "Catálogo de Libros");
        return "libros/lista";
    }

    // Formulario para nuevo libro
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoLibro(Model model) {
        Libro libro = new Libro();
        List<Categoria> categorias = categoriaService.findAll();
        
        model.addAttribute("libro", libro);
        model.addAttribute("categorias", categorias);
        model.addAttribute("tituloPagina", "Agregar Nuevo Libro");
        return "libros/formulario";
    }

    // Guardar nuevo libro
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute("libro") Libro libro) {
        // El formulario envía categoria.id; asegurarse de cargar la entidad Categoria
        if (libro.getCategoria() != null && libro.getCategoria().getId() != null) {
            Long catId = libro.getCategoria().getId();
            Optional<Categoria> catOpt = categoriaService.findById(catId);
            catOpt.ifPresent(libro::setCategoria);
        }
        libroService.save(libro);
        return "redirect:/libros";
    }

    // Formulario para editar libro
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarLibro(@PathVariable Long id, Model model) {
        Optional<Libro> libroOpt = libroService.findById(id);
        if (libroOpt.isPresent()) {
            List<Categoria> categorias = categoriaService.findAll();
            model.addAttribute("libro", libroOpt.get());
            model.addAttribute("categorias", categorias);
            model.addAttribute("tituloPagina", "Editar Libro");
            return "libros/formulario";
        }
        return "redirect:/libros";
    }

    // Eliminar libro
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.deleteById(id);
        return "redirect:/libros";
    }

    // Buscar libros
    @GetMapping("/buscar")
    public String buscarLibros(@RequestParam String query, Model model) {
        List<Libro> libros = libroService.buscarPorTituloOAutor(query);
        model.addAttribute("libros", libros);
        model.addAttribute("query", query);
        model.addAttribute("tituloPagina", "Resultados de búsqueda: " + query);
        return "libros/lista";
    }
}