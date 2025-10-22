package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Libro;
import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import EjercicioPractico1_Steohania_Rojas.demo.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
    
    @Override
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }
    
    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }
    
    @Override
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
    
    @Override
    public List<Libro> findByTituloContaining(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }
    
    @Override
    public List<Libro> findByAutorContaining(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }
    
    @Override
    public List<Libro> findByCategoria(Categoria categoria) {
        return libroRepository.findByCategoria(categoria);
    }
    
    @Override
    public List<Libro> findDisponibles() {
        return libroRepository.findByDisponibleTrue();
    }
    
    @Override
    public List<Libro> buscarPorTituloOAutor(String texto) {
        return libroRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(texto, texto);
    }
}