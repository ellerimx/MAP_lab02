package main;

public class Main {
    public static void main(String[] args) {
        ControleAcademico controle = new ControleAcademico();

        // Criar entidades
        Disciplina d1 = controle.adicionarDisciplina("MAP", "D001");
        Disciplina d2 = controle.adicionarDisciplina("SO", "D002");

        Professor p1 = controle.criarProfessor("Sabrina", "P001");
        Professor p2 = controle.criarProfessor("Dunfrey", "P002");

        Aluno a1 = controle.criarAluno("Maria", "A001");
        Aluno a2 = controle.criarAluno("João", "A002");

        // Criar turmas
        Turma t1 = controle.criarTurma(d1, p1, "T001");
        Turma t2 = controle.criarTurma(d2, p2, "T002");

        t1.setHorario("Segunda 10h-12h");
        t2.setHorario("Quarta 14h-16h");

        // Matricular alunos
        controle.matricularAlunoEmTurma("A001", "T001");
        controle.matricularAlunoEmTurma("A002", "T002");
        controle.matricularAlunoEmTurma("A001", "T002"); // A001 em duas turmas

        // Relatórios básicos
        Relatorio.exibirInformacoesProfessores(controle);
        Relatorio.exibirInformacoesDisciplinas(controle);
        Relatorio.exibirInformacoesAlunos(controle);
    }
}
