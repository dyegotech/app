package app.app.service;

import app.app.entity.Carro;
import app.app.entity.Marca;
import app.app.respository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> findAll(){
        try{
            return carroRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String save(Carro carro){
        try{
            carroRepository.save(carro);
            return "Carro salvo com sucesso";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String delete(Long id){
        try{
            carroRepository.deleteById(id);
            return "Carro deletado com sucesso";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Carro findById(Long id){
        try {
            return this.carroRepository.findById(id).get();
        }catch (NoSuchElementException nf){
            throw new RuntimeException("Não foi encontrado resultado para o id " + id);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String update(Carro carro, Long id){
        try{
            carro.setId(id);
            this.carroRepository.save(carro);
            return "Carro atualizado com sucesso";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Carro> findByNome(String nome){
        try{
            return this.carroRepository.findByNome(nome);
        }catch (Exception e){
            throw new RuntimeException("Nenhum resultado para o nome " + nome);
        }
    }

    public List<Carro> findByMarca(Long id){
        try{
            Marca m = new Marca();
            m.setId(id);
            return this.carroRepository.findByMarca(m);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Carro> findByAnoAcima(int ano){
        try{
            return this.carroRepository.findAnoAcima(ano);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
