package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    
    List<Categoria> findAll();
    
    Optional<Categoria> findById(Long id);
    
    Categoria save(Categoria categoria);
    
    void deleteById(Long id);
    
    Categoria findByNombre(String nombre);
    
    boolean existsByNombre(String nombre);
}