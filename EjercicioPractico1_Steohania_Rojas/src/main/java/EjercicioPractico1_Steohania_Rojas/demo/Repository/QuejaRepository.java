package EjercicioPractico1_Steohania_Rojas.demo.Repository;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuejaRepository extends JpaRepository<Queja, Long> {
    
    // Encontrar quejas por tipo
    List<Queja> findByTipo(Queja.Tipo tipo);
    
    // Encontrar quejas no tratadas
    List<Queja> findByTratadoFalse();
    
    // Encontrar quejas por email del cliente
    List<Queja> findByEmail(String email);
    
    // Contar quejas no tratadas
    long countByTratadoFalse();
}