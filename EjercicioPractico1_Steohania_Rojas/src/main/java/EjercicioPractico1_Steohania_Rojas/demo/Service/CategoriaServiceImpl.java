package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import EjercicioPractico1_Steohania_Rojas.demo.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
    
    @Override
    public Categoria findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }
    
    @Override
    public boolean existsByNombre(String nombre) {
        return categoriaRepository.existsByNombre(nombre);
    }
}