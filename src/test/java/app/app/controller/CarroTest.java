package app.app.controller;

import app.app.entity.Carro;
import app.app.entity.Marca;
import app.app.entity.Proprietario;
import app.app.respository.CarroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CarroTest {

    @Autowired
    CarroController carroController;

    @MockBean
    CarroRepository carroRepository;

    @BeforeEach
    void setup(){
        Proprietario proprietario = new Proprietario(1L, "Dyego");
        List<Proprietario> lista = new ArrayList<>();
        Marca m = new Marca();
        m.setId(1L);
        m.setNome("Toyota");
        m.setCnpj("cnpj000");
        lista.add(proprietario);
        Carro corolla = new Carro(1L, "Corolla", 2005, m, lista);
        List<Carro> carros = new ArrayList<>();
        carros.add(corolla);

        when(carroRepository.findAll()).thenReturn(carros); // Retorna sempre que o findAll for invocado
        when(carroRepository.findById(1L)).thenReturn(Optional.of(corolla)); // Retorna sempre que o findById for invocado

    }

    @Test
    void findAllSizeTest(){
        ResponseEntity<List<Carro>> response = this.carroController.findAll();
        assertEquals(1, response.getBody().size());
    }

    @Test
    void findAllStatusCodeTest(){
        ResponseEntity<List<Carro>> response = this.carroController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findByIdTest(){
        ResponseEntity<Carro> response = this.carroController.findById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findByIdBodyTest(){
        ResponseEntity<Carro> response = this.carroController.findById(1L);
        assertEquals("Corolla", response.getBody().getNome());
        assertEquals("Toyota", response.getBody().getMarca().getNome());
    }

}
