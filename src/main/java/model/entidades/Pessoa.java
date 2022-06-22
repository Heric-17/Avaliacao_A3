package model.entidades;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome_completo;

    private String cpf;

    private String email;

    private String telefone;

    @OneToOne
    private Endereco endereco;

    public Pessoa(String nome_completo, String cpf, Endereco endereco, String telefone, String email) {
        this.nome_completo = nome_completo;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa() {

    }

    public int getId() {
        return id;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "matricula: " + id +
                " Nome do Aluno: " + nome_completo +
                " CPF: " + cpf +
                " E-mail: " + email +
                " Telefone: " + telefone +
                " Endereco: " + endereco;
    }
}
