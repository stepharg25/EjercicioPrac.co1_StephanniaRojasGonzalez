package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Libro;
import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface LibroService {
    
    List<Libro> findAll();
    
    Optional<Libro> findById(Long id);
    
    Libro save(Libro libro);
    
    void deleteById(Long id);
    
    List<Libro> findByTituloContaining(String titulo);
    
    List<Libro> findByAutorContaining(String autor);
    
    List<Libro> findByCategoria(Categoria categoria);
    
    List<Libro> findDisponibles();
    
    List<Libro> buscarPorTituloOAutor(String texto);
}