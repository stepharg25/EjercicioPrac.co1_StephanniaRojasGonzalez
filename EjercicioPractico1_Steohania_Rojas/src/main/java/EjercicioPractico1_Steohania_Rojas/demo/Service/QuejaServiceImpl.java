package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Queja;
import EjercicioPractico1_Steohania_Rojas.demo.Repository.QuejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuejaServiceImpl implements QuejaService {
    
    @Autowired
    private QuejaRepository quejaRepository;
    
    @Override
    public List<Queja> findAll() {
        return quejaRepository.findAll();
    }
    
    @Override
    public Optional<Queja> findById(Long id) {
        return quejaRepository.findById(id);
    }
    
    @Override
    public Queja save(Queja queja) {
        return quejaRepository.save(queja);
    }
    
    @Override
    public void deleteById(Long id) {
        quejaRepository.deleteById(id);
    }
    
    @Override
    public List<Queja> findByTipo(Queja.Tipo tipo) {
        return quejaRepository.findByTipo(tipo);
    }
    
    @Override
    public List<Queja> findNoTratadas() {
        return quejaRepository.findByTratadoFalse();
    }
    
    @Override
    public long contarNoTratadas() {
        return quejaRepository.countByTratadoFalse();
    }
}