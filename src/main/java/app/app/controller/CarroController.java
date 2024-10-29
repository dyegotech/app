package app.app.controller;

import app.app.entity.Carro;
import app.app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/")
    public ResponseEntity<List<Carro>> findAll(){
        try{
            List<Carro> lista = carroService.findAll();
            return new ResponseEntity<List<Carro>>(lista, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id){
        try{
            Carro carro = carroService.findById(id);
            return new ResponseEntity<Carro>(carro, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try{
            String mensagem = carroService.save(carro);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable Long id){
        try{
            String mensagem = carroService.update(carro, id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            String mensagem = carroService.delete(id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome){
        try{
            List<Carro> lista = this.carroService.findByNome(nome);
            return new ResponseEntity<List<Carro>>(lista, HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam Long id){
        try{
            List<Carro> lista = this.carroService.findByMarca(id);
            return new ResponseEntity<List<Carro>>(lista, HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByAnoAcima")
    public ResponseEntity<List<Carro>> findByAnoAcima(@RequestParam int ano){
        try{
            List<Carro> lista = this.carroService.findByAnoAcima(ano);
            return new ResponseEntity<List<Carro>>(lista, HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
