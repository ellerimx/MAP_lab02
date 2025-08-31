package main;

import java.time.LocalDate;

//essa classe eh como uma entidade intermediária do vinculo entre um Aluno e uma Turma
// centraliza as regras de matrícula
public class Rdm {
    private final Aluno aluno;
    private final Turma turma;
    private final LocalDate data;

    public Rdm(Aluno aluno, Turma turma, LocalDate data) {
        this.aluno = aluno;
        this.turma = turma;
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public LocalDate getData() {
        return data;
    }
}
