package app.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @NotNull(message = "O ano não pode ser nulo")
    private int ano;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("carros")
    private Marca marca;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "carro_proprietario")
    private List<Proprietario> proprietarios;
}
