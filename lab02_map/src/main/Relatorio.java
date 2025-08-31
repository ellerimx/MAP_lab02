package main;

public class Relatorio {

    public static void exibirInformacoesProfessores(ControleAcademico controle) {
        System.out.println("=============== Informacoes dos Professores ===============");
        for (Professor professor : controle.getListaProfessores()) {
            System.out.println("Professor: " + professor.getNome());
            System.out.println("Disciplinas ministradas:");
            for (Turma turma : professor.getTurmas()) {
                System.out.println("\t- " + turma.getDisciplina().getNome() +
                                   " (" + turma.getHorario() + ")");
            }
            System.out.println("------------------------------------------------------------");
        }
    }

    public static void exibirInformacoesDisciplinas(ControleAcademico controle) {
        System.out.println("=============== Informacoes das Disciplinas ===============");
        for (Turma turma : controle.getListaTurmas()) {
            System.out.println("Disciplina: " + turma.getDisciplina().getNome());
            System.out.println("Professor: " + turma.getProfessor().getNome());
            System.out.println("Alunos Matriculados:");
            for (Aluno aluno : turma.getListaDeAlunos()) {
                System.out.println("\t- " + aluno.getNome());
            }
            System.out.println("Numero de alunos: " + turma.getNumeroDeAlunos());
            System.out.println("------------------------------------------------------------");
        }
    }

    public static void exibirInformacoesAlunos(ControleAcademico controle) {
        System.out.println("=============== Informacoes dos Alunos ===============");
        for (Aluno aluno : controle.getListaAlunos()) {
        	System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Disciplinas matriculadas:");
            for (Turma turma : aluno.getTurmas()) {
                System.out.println("\t- " + turma.getDisciplina().getNome() +
                                   " (Professor: " + turma.getProfessor().getNome() +
                                   ", Horário: " + turma.getHorario() + ")");
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
