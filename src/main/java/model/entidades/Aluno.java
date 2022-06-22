package model.entidades;

import jakarta.persistence.Entity;

@Entity
public class Aluno extends Pessoa {

    public Aluno(String nome_completo, String cpf, Endereco endereco, String telefone, String email) {
        super(nome_completo, cpf, endereco, telefone, email);
    }

    public Aluno() {

    }

}
