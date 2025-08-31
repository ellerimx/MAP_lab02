package main;

//import java.util.ArrayList;
//import java.util.List;

public class Professor {
    private String nome;
    private String idProfessor;
    
    //private List<Turma> turmas = new ArrayList<>();

    public Professor(String nome, String idProfessor) {
        this.nome = nome;
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public String getIDProfessor() {
        return idProfessor;
    }

    /* public List<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        if (turma != null && !turmas.contains(turma)) {
            turmas.add(turma);
        }
    } */
    
}
