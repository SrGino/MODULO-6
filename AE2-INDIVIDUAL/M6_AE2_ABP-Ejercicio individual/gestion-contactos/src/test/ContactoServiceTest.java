

import com.startup.gestion.modelo.Contacto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ContactoServiceTest {

    @Autowired
    private ContactoService contactoService;

    @Test
    public void testAgregarYListarContactos() {
        // 1. Crear un contacto de prueba
        Contacto nuevo = new Contacto("Test User", "test@test.com", "12345");
        
        // 2. Obtener tamaño inicial
        int tamanoInicial = contactoService.obtenerTodos().size();
        
        // 3. Agregar
        contactoService.agregarContacto(nuevo);
        
        // 4. Verificar que la lista creció
        List<Contacto> lista = contactoService.obtenerTodos();
        Assertions.assertEquals(tamanoInicial + 1, lista.size(), "La lista debería tener un elemento más");
        
        // 5. Verificar que el contacto existe
        Contacto encontrado = contactoService.buscarPorNombre("Test User");
        Assertions.assertNotNull(encontrado, "El contacto debería encontrarse");
        Assertions.assertEquals("test@test.com", encontrado.getCorreo());
    }
}