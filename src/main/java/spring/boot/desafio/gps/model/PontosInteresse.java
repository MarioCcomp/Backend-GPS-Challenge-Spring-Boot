package spring.boot.desafio.gps.model;


import jakarta.persistence.*;

@Entity()
@Table(name = "pontos_interesse")
public class PontosInteresse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long x;
    private Long y;

    public PontosInteresse(){}

    public PontosInteresse(String nome, Long x, Long y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

}
