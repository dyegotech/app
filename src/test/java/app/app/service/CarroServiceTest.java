package app.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarroServiceTest {

    @Autowired
    CarroService carroService;

    @Test
    void verificarNomeEAno(){
        boolean result = this.carroService.verificarCarro("Jeep Compass", 2006);
        Assertions.assertTrue(result);
    }

    @Test
    void verificarNomeEAnoException(){
        Assertions.assertThrows(Exception.class, () -> {
            boolean result = this.carroService.verificarCarro("Jeep Compass", 2005);
        });
    }

}
