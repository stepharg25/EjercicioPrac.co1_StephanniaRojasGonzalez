package EjercicioPractico1_Steohania_Rojas.demo.Repository;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Libro;
import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    
    // Encontrar libros por título (búsqueda parcial case insensitive)
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    
    // Encontrar libros por autor
    List<Libro> findByAutorContainingIgnoreCase(String autor);
    
    // Encontrar libros por categoría
    List<Libro> findByCategoria(Categoria categoria);
    
    // Encontrar libros disponibles
    List<Libro> findByDisponibleTrue();
    
    // Encontrar libros por categoría y disponibilidad
    List<Libro> findByCategoriaAndDisponibleTrue(Categoria categoria);
    
    // Encontrar libros por título o autor
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
}