package view;

import model.DAO.DAO;
import model.entidades.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);

        String resposta = "";
        while (!resposta.equalsIgnoreCase("sair")) {

            System.out.println("Digite o número da opção desejada \n");

            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Professor");
            System.out.println("4 - Cadastrar Sala");
            System.out.println("5 - Cadastrar Turma");
            System.out.println("6 - Inscrever Aluno em um curso");
            System.out.println("7 - Matricular Aluno em uma turma");
            System.out.println("8 - Registrar Curso em uma Sala");
            System.out.println("9 - Registrar Professor em um curso");
            System.out.println("10 - Listar cursos ativos");
            resposta = entrada.nextLine();

            Endereco endereco;
            Professor professor;
            Aluno aluno;
            Curso curso;
            Turma turma;
            Sala sala;

            DAO<Curso> daoCurso;
            DAO<Aluno> daoAluno;
            DAO<Turma> daoTurma;
            DAO<Sala> daoSala;
            DAO<Professor> daoProfessor;

            int idAluno = 0;
            int idCurso = 0;
            int idTurma = 0;
            int idSala = 0;
            int idProfessor = 0;
            int numeroEscolhido = 0;

            DAO<Object> dao;
            switch (resposta) {
                case "1":
                    aluno = new Aluno();
                    endereco = new Endereco();
                    System.out.println("Digite o nome e sobrenome do aluno: ");
                    String nome = entrada.nextLine();
                    aluno.setNome_completo(nome);

                    System.out.println("Digite o cpf do aluno: ");
                    String cpf = entrada.nextLine();
                    aluno.setCpf(cpf);

                    System.out.println("Digite o e-mail do aluno: ");
                    String email = entrada.nextLine();
                    aluno.setEmail(email);

                    System.out.println("Digite o celular do aluno: ");
                    String telefone = entrada.nextLine();
                    aluno.setTelefone(telefone);

                    System.out.println("Endereco do aluno - ");
                    System.out.println("Digite a rua: ");
                    String rua = entrada.nextLine();
                    endereco.setRua(rua);

                    System.out.println("Digite a cidade: ");
                    String cidade = entrada.nextLine();
                    endereco.setCidade(cidade);

                    System.out.println("Digite o número");
                    String numero = entrada.next();
                    endereco.setNumero(numero);


                    aluno.setEndereco(endereco);
                    dao = new DAO<>();
                    dao.openTransaction().saveEntity(endereco).saveEntity(aluno).closeTransaction();

                    System.out.println("Aluno cadastrado");
                    aluno = null;
                    endereco = null;
                    break;
                case "2":
                    curso = new Curso();
                    System.out.println("Digite o nome do curso: ");
                    String nomeCurso = entrada.nextLine();
                    curso.setNome_curso(nomeCurso);

                    System.out.println("Digite a carga horária do curso: ");
                    short cargaHoraria = entrada.nextShort();
                    entrada.nextLine();
                    curso.setCarga_horaria(cargaHoraria);

                    System.out.println("Digite a descrição do curso: ");
                    String descricao = entrada.nextLine();
                    curso.setDescricao(descricao);

                    dao = new DAO<>();
                    dao.saveOneEntity(curso);

                    System.out.println("Curso cadastrado");
                    curso = null;
                    break;

                case "3":
                    professor = new Professor();
                    endereco = new Endereco();
                    System.out.println("Digite o nome e sobrenome do professor: ");
                    String nomeProf = entrada.nextLine();
                    professor.setNome_completo(nomeProf);

                    System.out.println("Digite o cpf do professor: ");
                    String cpfProf = entrada.nextLine();
                    professor.setCpf(cpfProf);

                    System.out.println("Digite o e-mail do professor: ");
                    String emailProf = entrada.nextLine();
                    professor.setEmail(emailProf);

                    System.out.println("Digite o celular do professor: ");
                    String telefoneProf = entrada.nextLine();
                    professor.setTelefone(telefoneProf);

                    System.out.println("Endereco do Professor - ");
                    System.out.println("Digite a rua: ");
                    String ruaProf = entrada.nextLine();
                    endereco.setRua(ruaProf);

                    System.out.println("Digite a cidade: ");
                    String cidadeProf = entrada.nextLine();
                    endereco.setCidade(cidadeProf);

                    System.out.println("Digite o número");
                    String numeroProf = entrada.next();
                    endereco.setNumero(numeroProf);

                    professor.setEndereco(endereco);

                    dao = new DAO<>();
                    dao.openTransaction().saveEntity(endereco).saveEntity(professor).closeTransaction();

                    System.out.println("Professor cadastrado");
                    professor = null;
                    endereco = null;
                    break;
                case "4":
                    sala = new Sala();
                    System.out.println("Digite o nome da sala: ");
                    String nomeSala = entrada.nextLine();
                    sala.setNome(nomeSala);

                    System.out.println("Digite a capacidade total da sala: ");
                    Long capacidadeSala = entrada.nextLong();
                    entrada.nextLine();
                    sala.setCapacidade_total(capacidadeSala);

                    System.out.println("Digite o local da sala: ");
                    String localSala = entrada.nextLine();
                    sala.setLocal(localSala);

                    dao = new DAO<>();
                    dao.saveOneEntity(sala);
                    System.out.println("Sala cadastrada");
                    sala = null;
                    break;
                case "5":
                    turma = new Turma();
                    System.out.println("Digite o nome da turma: ");
                    String nomeTurma = entrada.nextLine();
                    turma.setNome(nomeTurma);

                    ///////////////////////////////////////////////////////

                    daoCurso = new DAO<Curso>(Curso.class);
                    List<Curso> cursos = daoCurso.getListEntities(0, 5000);

                    if (MetodosControle.isVazio(cursos, "curso")) {
                        break;
                    }
                    for (Curso cursoLista : cursos) {
                        System.out.println(cursoLista);
                    }

                    System.out.println("");
                    while (numeroEscolhido != -2) {
                        System.out.println("Selecione o código do curso desta turma\n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Curso cursoLista : cursos) {
                            if (numeroEscolhido == cursoLista.getCodigo_curso()) {
                                turma.setCurso(cursoLista);
                                numeroEscolhido = -2;
                            }
                        }
                        if (numeroEscolhido != -2) {
                            System.out.println("Este Curso não existe, tente novamente");
                        }
                    }

                    dao = new DAO<>();
                    dao.saveOneEntity(turma);
                    System.out.println("Turma cadastrada");
                    turma = null;
                    break;
                case "6":

                    daoAluno = new DAO<Aluno>(Aluno.class);
                    List<Aluno> alunos = daoAluno.getListEntities(0, 10000);

                    if (MetodosControle.isVazio(alunos, "aluno")) {
                        break;
                    }
                    for (Aluno alunoLista : alunos) {
                        System.out.println(alunoLista);
                    }


                    System.out.println("");
                    while (numeroEscolhido != -1) {
                        System.out.println("Selecione o numero da matricula do aluno desejado \n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Aluno alunoLista : alunos) {
                            if (numeroEscolhido == alunoLista.getId()) {
                                idAluno = alunoLista.getId();
                                numeroEscolhido = -1;
                            }
                        }
                        if (numeroEscolhido != -1) {
                            System.out.println("Este Aluno não existe, tente novamente");
                        }
                    }
                    ////////////////////////////////////////////////

                    daoCurso = new DAO<Curso>(Curso.class);
                    List<Curso> cursos2 = daoCurso.getListEntities(0, 5000);

                    if (MetodosControle.isVazio(cursos2, "curso")) {
                        break;
                    }
                    for (Curso cursoLista : cursos2) {
                        System.out.println(cursoLista);
                    }


                    System.out.println("");
                    while (numeroEscolhido != -2) {
                        System.out.println("Selecione o código do curso desejado\n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Curso cursoLista : cursos2) {
                            if (numeroEscolhido == cursoLista.getCodigo_curso()) {
                                idCurso = cursoLista.getCodigo_curso();
                                numeroEscolhido = -2;
                            }
                        }
                        if (numeroEscolhido != -2) {
                            System.out.println("Este Curso não existe, tente novamente");
                        }
                    }

                    if (idAluno != 0 && idCurso != 0) {
                        Aluno aluno1 = daoAluno.getEntityById(idAluno);
                        Curso curso1 = daoCurso.getEntityById(idCurso);

                        curso1.getAlunos().add(aluno1);
                        daoCurso.updateOneEntity(curso1);

                        System.out.println("Aluno cadastrado corretamente");
                        break;
                    }
                case "7":

                    daoAluno = new DAO<Aluno>(Aluno.class);
                    List<Aluno> alunosTurma = daoAluno.getListEntities(0, 10000);

                    if (MetodosControle.isVazio(alunosTurma, "aluno")) {
                        break;
                    }

                    for (Aluno alunoLista : alunosTurma) {
                        System.out.println(alunoLista);
                    }

                    System.out.println("");
                    while (numeroEscolhido != -1) {
                        System.out.println("Selecione o numero da matricula do aluno desejado \n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Aluno alunoLista : alunosTurma) {
                            if (numeroEscolhido == alunoLista.getId()) {
                                idAluno = alunoLista.getId();
                                numeroEscolhido = -1;
                            }
                        }
                        if (numeroEscolhido != -1) {
                            System.out.println("Este Aluno não existe, tente novamente");
                        }
                    }
                    ////////////////////////////////////////////////

                    daoTurma = new DAO<Turma>(Turma.class);
                    List<Turma> listaTurmas = daoTurma.getListEntities(0, 5000);

                    if (MetodosControle.isVazio(listaTurmas, "turma")) {
                        break;
                    }

                    for (Turma turmaLista : listaTurmas) {
                        System.out.println(turmaLista);
                    }

                    System.out.println("");
                    while (numeroEscolhido != -2) {
                        System.out.println("Selecione o código da turma desejada\n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Turma turmaLista : listaTurmas) {
                            if (numeroEscolhido == turmaLista.getId()) {
                                idTurma = turmaLista.getId();
                                numeroEscolhido = -2;
                            }
                        }
                        if (numeroEscolhido != -2) {
                            System.out.println("Esta turma não existe, tente novamente");
                        }
                    }

                    if (idTurma != 0 && idAluno != 0) {
                        Aluno aluno1 = daoAluno.getEntityById(idAluno);
                        Turma turma1 = daoTurma.getEntityById(idTurma);

                        turma1.getAlunos().add(aluno1);
                        daoTurma.updateOneEntity(turma1);

                        System.out.println("Aluno cadastrado corretamente");
                        break;
                    }

                case "8":
                    daoCurso = new DAO<Curso>(Curso.class);
                    List<Curso> cursos3 = daoCurso.getListEntities(0, 5000);

                    for (Curso cursoLista : cursos3) {
                        System.out.println(cursoLista);
                    }
                    if (MetodosControle.isVazio(cursos3, "curso")) {
                        break;
                    }

                    System.out.println("");
                    while (numeroEscolhido != -2) {
                        System.out.println("Selecione o código do curso desejado\n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Curso cursoLista : cursos3) {
                            if (numeroEscolhido == cursoLista.getCodigo_curso()) {
                                idCurso = cursoLista.getCodigo_curso();
                                numeroEscolhido = -2;
                            }
                        }
                        if (numeroEscolhido != -2) {
                            System.out.println("Este Curso não existe, tente novamente");
                        }
                    }

                    ///////////////////////////////////////////////////

                    daoSala = new DAO<Sala>(Sala.class);
                    List<Sala> salas = daoSala.getListEntities(0, 5000);

                    for (Sala salaLista : salas) {
                        System.out.println(salaLista);
                    }

                    if (MetodosControle.isVazio(salas, "sala")) {
                        break;
                    }

                    System.out.println("");
                    while (numeroEscolhido != -3) {
                        System.out.println("Selecione o código da sala desejada\n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Sala salaLista2 : salas) {
                            if (numeroEscolhido == salaLista2.getId()) {
                                idSala = salaLista2.getId();
                                numeroEscolhido = -3;
                            }
                        }
                        if (numeroEscolhido != -3) {
                            System.out.println("Este Curso não existe, tente novamente");
                        }
                    }

                    if (idSala != 0 && idCurso != 0) {
                        Curso curso1 = daoCurso.getEntityById(idCurso);
                        Sala sala1 = daoSala.getEntityById(idSala);

                        curso1.setSala(sala1);
                        daoCurso.updateOneEntity(curso1);

                        System.out.println("Sala cadastrada corretamente");
                        break;
                    }
                case "9":
                    daoCurso = new DAO<Curso>(Curso.class);
                    List<Curso> cursos4 = daoCurso.getListEntities(0, 5000);

                    for (Curso cursoLista : cursos4) {
                        System.out.println(cursoLista);
                    }

                    if (MetodosControle.isVazio(cursos4, "curso")) {
                        break;
                    }

                    System.out.println("");
                    while (numeroEscolhido != -2) {
                        System.out.println("Selecione o código do curso desejado\n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Curso cursoLista : cursos4) {
                            if (numeroEscolhido == cursoLista.getCodigo_curso()) {
                                idCurso = cursoLista.getCodigo_curso();
                                numeroEscolhido = -2;
                            }
                        }
                        if (numeroEscolhido != -2) {
                            System.out.println("Este Curso não existe, tente novamente");
                        }
                    }

                    ///////////////////////////////////////////////////

                    daoProfessor = new DAO<Professor>(Professor.class);
                    List<Professor> professores = daoProfessor.getListEntities(0, 5000);

                    for (Professor professorLista : professores) {
                        System.out.println(professorLista);
                    }
                    if (MetodosControle.isVazio(professores, "professor")) {
                        break;
                    }


                    System.out.println("");
                    while (numeroEscolhido != -3) {
                        System.out.println("Selecione o código do professor desejado\n");
                        numeroEscolhido = entrada.nextInt();
                        entrada.nextLine();

                        for (Professor professorLista2 : professores) {
                            if (numeroEscolhido == professorLista2.getId()) {
                                idProfessor = professorLista2.getId();
                                numeroEscolhido = -3;
                            }
                        }
                        if (numeroEscolhido != -3) {
                            System.out.println("Este Professor não existe, tente novamente");
                        }
                    }

                    if (idProfessor != 0 && idCurso != 0) {
                        Curso curso1 = daoCurso.getEntityById(idCurso);
                        Professor professor1 = daoProfessor.getEntityById(idProfessor);

                        curso1.setProfessor(professor1);
                        daoCurso.updateOneEntity(curso1);

                        System.out.println("Professor cadastrado corretamente");
                        break;
                    }
                case "10":
                    daoCurso = new DAO<Curso>(Curso.class);
                    List<Curso> cursosA = daoCurso.getEntitiesByJPQL();

                    if (MetodosControle.isVazio(cursosA, "curso")) {
                        break;
                    }

                    for (Curso cursoA : cursosA) {
                        System.out.println(cursoA);
                        System.out.print(cursoA.getProfessor());
                        System.out.println();
                        List<Aluno> alunosA = cursoA.getAlunos();
                        for (Aluno alunoA : alunosA) {
                            System.out.println(alunoA);
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida, digite novamente");
            }

        }

    }
}