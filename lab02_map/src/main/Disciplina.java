package main;

public class Disciplina {
    private String nome;
    private String idDisciplina;


   public Disciplina(String nome, String codigoDisciplina) {
        this.nome = nome;
        this.idDisciplina = codigoDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }
}
