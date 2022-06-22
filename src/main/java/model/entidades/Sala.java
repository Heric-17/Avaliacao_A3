package model.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private Long capacidade_total;

    private String local;

    public Sala() {

    }

    public Sala(String nome, Long capacidade_total, String local) {
        this.nome = nome;
        this.capacidade_total = capacidade_total;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCapacidade_total() {
        return capacidade_total;
    }

    public void setCapacidade_total(Long capacidade_total) {
        this.capacidade_total = capacidade_total;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Sala: " + nome +
                " Capacidade total: " + capacidade_total +
                " Local: " + local;
    }
}
