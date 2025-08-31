package main;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private List<Turma> turmas = new ArrayList<>();

    //histórico de matrículas/rdms
    private List<Rdm> rdms = new ArrayList<>();

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        if (turma != null && !turmas.contains(turma)) {
            turmas.add(turma);
        }
    }

    //registrar o RDM gerado por Turma
    public void adicionarRdm(Rdm rdm) {
        if (rdm != null && !rdms.contains(rdm)) {
            rdms.add(rdm);
        }
    }


}
