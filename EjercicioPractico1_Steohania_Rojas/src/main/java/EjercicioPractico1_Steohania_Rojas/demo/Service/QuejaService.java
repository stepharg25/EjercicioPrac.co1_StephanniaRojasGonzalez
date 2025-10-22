package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Queja;
import java.util.List;
import java.util.Optional;

public interface QuejaService {
    
    List<Queja> findAll();
    
    Optional<Queja> findById(Long id);
    
    Queja save(Queja queja);
    
    void deleteById(Long id);
    
    List<Queja> findByTipo(Queja.Tipo tipo);
    
    List<Queja> findNoTratadas();
    
    long contarNoTratadas();
}