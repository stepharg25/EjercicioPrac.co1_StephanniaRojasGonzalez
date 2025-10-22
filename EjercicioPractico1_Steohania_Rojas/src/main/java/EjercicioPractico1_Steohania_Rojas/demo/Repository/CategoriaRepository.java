package EjercicioPractico1_Steohania_Rojas.demo.Repository;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // Encontrar categoría por nombre
    Categoria findByNombre(String nombre);
    
    // Verificar si existe una categoría por nombre
    boolean existsByNombre(String nombre);
    
    // Encontrar categorías que contengan cierto texto en el nombre
    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}