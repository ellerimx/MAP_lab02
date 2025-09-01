package main;

public class Professor {
    private String nome;
    private String idProfessor;
    

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

}
