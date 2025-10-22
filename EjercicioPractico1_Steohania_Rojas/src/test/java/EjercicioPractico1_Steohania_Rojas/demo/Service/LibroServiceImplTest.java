package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Libro;
import EjercicioPractico1_Steohania_Rojas.demo.Repository.LibroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LibroServiceImplTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_shouldReturnList() {
        Libro l1 = new Libro(); l1.setId(1L); l1.setTitulo("A");
        Libro l2 = new Libro(); l2.setId(2L); l2.setTitulo("B");
        when(libroRepository.findAll()).thenReturn(Arrays.asList(l1, l2));

        List<Libro> result = libroService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(libroRepository, times(1)).findAll();
    }

    @Test
    void findById_shouldReturnOptional() {
        Libro l = new Libro(); l.setId(5L);
        when(libroRepository.findById(5L)).thenReturn(Optional.of(l));

        Optional<Libro> opt = libroService.findById(5L);

        assertTrue(opt.isPresent());
        assertEquals(5L, opt.get().getId());
        verify(libroRepository).findById(5L);
    }

    @Test
    void save_shouldReturnSavedEntity() {
        Libro l = new Libro(); l.setTitulo("New");
        when(libroRepository.save(any(Libro.class))).thenAnswer(inv -> {
            Libro arg = inv.getArgument(0);
            arg.setId(10L);
            return arg;
        });

        Libro saved = libroService.save(l);

        assertNotNull(saved);
        assertEquals(10L, saved.getId());
        verify(libroRepository).save(l);
    }

    @Test
    void deleteById_shouldCallRepository() {
        doNothing().when(libroRepository).deleteById(7L);

        libroService.deleteById(7L);

        verify(libroRepository).deleteById(7L);
    }

    @Test
    void findByTituloContaining_shouldDelegate() {
        when(libroRepository.findByTituloContainingIgnoreCase("abc")).thenReturn(Arrays.asList());

        List<Libro> res = libroService.findByTituloContaining("abc");

        assertNotNull(res);
        verify(libroRepository).findByTituloContainingIgnoreCase("abc");
    }

}
