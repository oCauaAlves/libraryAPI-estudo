package com.github.ocauaalves.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import javax.naming.Name;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Data // é o mesmo que usar @Getter | @Setter | @ToString | @EqualsAndHashCode | @RequiredArgsConstructor
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco; //BigDecimal é Melhor pra trablahar com preco pois tem mais precisão
    //private Double preco;     se for usar double precisa tirar o scale = 2 e tbm trabalhar com numeros menores

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;
}
