package main;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;

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
    
    public List<Rdm> getRdms() {
        return rdms;
    }
    
    //registrar o RDM gerado por Turma
    public void adicionarRdm(Rdm rdm) {
        if (rdm != null && !rdms.contains(rdm)) {
            rdms.add(rdm);
        }
    }


}
