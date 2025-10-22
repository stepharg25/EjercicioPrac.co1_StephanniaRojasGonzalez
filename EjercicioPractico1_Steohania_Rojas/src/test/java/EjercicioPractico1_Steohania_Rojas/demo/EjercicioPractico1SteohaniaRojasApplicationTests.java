package EjercicioPractico1_Steohania_Rojas.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
class EjercicioPractico1SteohaniaRojasApplicationTests {

    @Test
    void contextLoads() {
        // Test mínimo - solo verifica que el contexto carga
        System.out.println("Contexto cargado exitosamente");
    }
}