package main;

import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {
    private List<Professor> listaProfessores;
    private List<Aluno> listaAlunos;
    private List<Turma> listaTurmas;
    private List<Disciplina> listaDisciplinas;

    public ControleAcademico() {
        listaProfessores = new ArrayList<>();
        listaAlunos = new ArrayList<>();
        listaTurmas = new ArrayList<>();
        listaDisciplinas = new ArrayList<>();
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public List<Turma> getListaTurmas() {
        return listaTurmas;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public Disciplina adicionarDisciplina(String nome, String codigoDisciplina) {
        Disciplina novaDisciplina = new Disciplina(nome, codigoDisciplina);
        listaDisciplinas.add(novaDisciplina);
        return novaDisciplina;
    }

    public Professor criarProfessor(String nome, String codigoProf) {
        Professor professor = new Professor(nome, codigoProf);
        listaProfessores.add(professor);
        return professor;
    }

    public Aluno criarAluno(String nome, String matricula) {
        Aluno aluno = new Aluno(nome, matricula);
        listaAlunos.add(aluno);
        return aluno;
    }

    public Turma criarTurma(Disciplina disciplina, Professor professor, String codigoTurma) {
        Turma turma = new Turma(disciplina, codigoTurma);
        turma.setProfessor(professor);
        listaTurmas.add(turma);
        return turma;
    }

    public Disciplina getDisciplinaPorCodigo(String codigoDisciplina) {
        for (Disciplina d : listaDisciplinas) {
            if (d.getIdDisciplina().equals(codigoDisciplina)) {
                return d;
            }
        }
        return null;
    }

    public Aluno getAlunoPorCodigo(String codigo) {
        for (Aluno a : listaAlunos) {
            if (a.getMatricula().equals(codigo)) {
                return a;
            }
        }
        return null;
    }

    public Professor getProfessorPorCodigo(String codigo) {
        for (Professor p : listaProfessores) {
            if (p.getIDProfessor().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public Turma getTurmaPorCodigo(String codigo) {
        for (Turma t : listaTurmas) {
            if (t.getIdTurma().equals(codigo)) {
                return t;
            }
        }
        return null;
    }

    //matricula eh responsabilidade da Turma (creator do Rdm)
    public Rdm matricularAlunoEmTurma(String matriculaAluno, String codigoTurma) {
        Aluno aluno = getAlunoPorCodigo(matriculaAluno);
        Turma turma = getTurmaPorCodigo(codigoTurma);
        if (aluno != null && turma != null) {
            return turma.matricular(aluno); // delega a criação do RDM
        }
        return null;
    }

    public void atribuirProfessorATurma(String codigoProfessor, String codigoTurma) {
        Professor professor = getProfessorPorCodigo(codigoProfessor);
        Turma turma = getTurmaPorCodigo(codigoTurma);
        if (professor != null && turma != null) {
            turma.setProfessor(professor);
        }
    }
}
