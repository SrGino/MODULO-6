package com.biblioteca;

import com.biblioteca.jdbc.dao.LibroDAO;
import com.biblioteca.jdbc.model.Libro;
import com.biblioteca.jpa.repository.AutorRepository;
import com.biblioteca.jpa.repository.LibroRepository;
import com.biblioteca.jpa.service.LibroServiceJpa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BibliotecaApplicationTests {

    @Autowired
    private LibroDAO libroJdbcDAO;

    @Autowired
    private LibroServiceJpa libroServiceJpa;

    @Autowired
    private AutorRepository autorRepository;
    
    @Autowired
    private LibroRepository libroRepository;

    @Test
    void testJdbcTemplate() {
        // Prueba de inserción y lectura con JDBC
        Libro libro = new Libro(null, "Java JDBC", 2023);
        libroJdbcDAO.insertar(libro);

        var libros = libroJdbcDAO.obtenerTodos();
        Assertions.assertFalse(libros.isEmpty(), "Debería haber libros insertados vía JDBC");
        Assertions.assertEquals("Java JDBC", libros.get(0).getTitulo());
    }

    @Test
    void testTransaccionJpaExitosa() {
        // Caso feliz: todo correcto
        libroServiceJpa.registrarAutorYLibro("Gabriel García Márquez", "Cien Años de Soledad");
        
        Assertions.assertEquals(1, autorRepository.count(), "Debería haber 1 autor");
        Assertions.assertEquals(1, libroRepository.count(), "Debería haber 1 libro");
    }

    @Test
    void testTransaccionJpaRollback() {
        long autoresAntes = autorRepository.count();

        // Caso fallido: Intentamos guardar un autor pero el libro es inválido
        // Esto lanzará IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            libroServiceJpa.registrarAutorYLibro("Autor Fallido", ""); // Título vacío
        });

        // Verificamos que se hizo ROLLBACK
        // Aunque el autor se guardó primero en el código, la transacción lo deshizo
        long autoresDespues = autorRepository.count();
        
        Assertions.assertEquals(autoresAntes, autoresDespues, 
            "El número de autores no debería cambiar debido al rollback");
    }
}