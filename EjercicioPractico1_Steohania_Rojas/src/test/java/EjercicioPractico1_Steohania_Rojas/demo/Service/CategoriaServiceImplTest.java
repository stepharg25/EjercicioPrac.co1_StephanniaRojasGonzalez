package EjercicioPractico1_Steohania_Rojas.demo.Service;

import EjercicioPractico1_Steohania_Rojas.demo.Domain.Categoria;
import EjercicioPractico1_Steohania_Rojas.demo.Repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaServiceImplTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_shouldReturnList() {
        Categoria c1 = new Categoria(); c1.setId(1L); c1.setNombre("C1");
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(c1));

        List<Categoria> res = categoriaService.findAll();

        assertNotNull(res);
        assertEquals(1, res.size());
        verify(categoriaRepository).findAll();
    }

    @Test
    void findById_shouldReturnOptional() {
        Categoria c = new Categoria(); c.setId(3L);
        when(categoriaRepository.findById(3L)).thenReturn(Optional.of(c));

        Optional<Categoria> opt = categoriaService.findById(3L);

        assertTrue(opt.isPresent());
        assertEquals(3L, opt.get().getId());
        verify(categoriaRepository).findById(3L);
    }

    @Test
    void save_shouldReturnEntity() {
        Categoria c = new Categoria(); c.setNombre("X");
        when(categoriaRepository.save(any(Categoria.class))).thenAnswer(inv -> {
            Categoria arg = inv.getArgument(0);
            arg.setId(11L);
            return arg;
        });

        Categoria saved = categoriaService.save(c);

        assertNotNull(saved);
        assertEquals(11L, saved.getId());
        verify(categoriaRepository).save(c);
    }

    @Test
    void existsByNombre_shouldReturn() {
        when(categoriaRepository.existsByNombre("X")).thenReturn(true);

        boolean exists = categoriaService.existsByNombre("X");

        assertTrue(exists);
        verify(categoriaRepository).existsByNombre("X");
    }

}
