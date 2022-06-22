package model.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo_curso;

    private String nome_curso;

    private short carga_horaria;

    private String descricao;

    @ManyToMany
    private List<Aluno> alunos;

    @OneToOne
    private Professor professor;

    @OneToOne
    private Sala sala;

    public Curso(String nome_curso, short carga_horaria, String descricao, Professor professor, Sala sala) {
        this.nome_curso = nome_curso;
        this.carga_horaria = carga_horaria;
        this.descricao = descricao;
        this.professor = professor;
        this.sala = sala;
    }

    public Curso() {

    }

    public int getCodigo_curso() {
        return codigo_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public short getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(short carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public List<Aluno> getAlunos() {
        if (this.alunos == null) {
            alunos = new ArrayList<>();
        }
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "codigo: "+ codigo_curso + " nome do curso: " + nome_curso + " descrição: " + descricao;
    }
}
