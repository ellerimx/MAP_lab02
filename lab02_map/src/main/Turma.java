package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String idTurma;
    private Disciplina disciplina;
    private List<Aluno> listaDeAlunos = new ArrayList<>(); // lista de alunos 
    private Professor professor;
    private String horario;

    //registros de matrículas
    private List<Rdm> rdms = new ArrayList<>();

    public Turma(Disciplina disciplina, String idTurma) {
        this.disciplina = disciplina;
        this.idTurma = idTurma;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        /*if (professor != null) {
            professor.adicionarTurma(this);
        }*/
    }
   

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno != null && !listaDeAlunos.contains(aluno)) {
            listaDeAlunos.add(aluno);
        }
    }
    
    public List<Aluno> getListaDeAlunos(){
    	return listaDeAlunos;
    }

    public int getNumeroDeAlunos() {
        return listaDeAlunos.size();
    }

    //Turma como Creator de Rdm
    public Rdm matricular(Aluno aluno) {
        if ((aluno == null) || listaDeAlunos.contains(aluno)) return null;
        adicionarAluno(aluno);
        
        //listaDeAlunos.add(aluno);
       
        //aluno.adicionarTurma(this);

        Rdm rdm = new Rdm(aluno, this, LocalDate.now());
        rdms.add(rdm);
        
        //aluno.adicionarRdm(rdm);
        
        return rdm;
    }

    // caso precise um dia acessar RDMs
    public List<Rdm> getRdms() {
        return rdms;
    }
    
    @Override
    public String toString() {
        return "Turma " + idTurma + " - " + disciplina.getNome();
        
    }
}
