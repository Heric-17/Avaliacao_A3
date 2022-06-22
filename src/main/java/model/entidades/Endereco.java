package model.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rua;

    private String cidade;

    private String numero;

    public Endereco(String rua, String cidade, String numero) {
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
    }

    public Endereco() {

    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Rua: " + rua + " Cidade: " + cidade + " Numero" + numero;
    }
}
