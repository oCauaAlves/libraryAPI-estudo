package com.github.ocauaalves.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity //obrigatório pra dizer que é um mapeamento jpa de uma entidade
@Table(name = "autor")
@Getter // Lombok, usando a anotação ao inves de ter que criar os getters
@Setter // Lombok, usando a anotação ao inves de ter que criar os setters
public class Autor {

    @Id
    @Column(name = "id") //Não é necessario,usando mais pra deixar a entity bem definida
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String name;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;
}
