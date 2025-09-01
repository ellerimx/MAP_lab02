package tests;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private ControleAcademico controle;
    private Aluno aluno;
    private Turma turmaTeste;

    private static final String MATRICULA_PADRAO = "A002";
    private static final String NOME_PADRAO = "João";

    @BeforeEach
    void setUp() {
        controle = new ControleAcademico();
        aluno = controle.criarAluno(NOME_PADRAO, MATRICULA_PADRAO);

        Disciplina disciplinaSO = controle.adicionarDisciplina("SO", "D002");
        Professor professor = controle.criarProfessor("Fabio", "P001");
        turmaTeste = controle.criarTurma(disciplinaSO, professor, "T002");
    }

    @Test
    void testConstrutorEGetters() {
        assertEquals(MATRICULA_PADRAO, aluno.getMatricula());
        assertEquals(NOME_PADRAO, aluno.getNome());
    }

    @Test
    void testMatricularAlunoEmTurma() {
        controle.matricularAlunoEmTurma(aluno.getMatricula(), turmaTeste.getIdTurma());

        assertTrue(turmaTeste.getListaDeAlunos().contains(aluno));
        assertTrue(controle.getTurmasDoAluno(aluno.getMatricula()).contains(turmaTeste));
    }

    @Test
    void testMatricularAlunoDuasVezesMesmaTurmaNaoDuplica() {
        controle.matricularAlunoEmTurma(aluno.getMatricula(), turmaTeste.getIdTurma());
        controle.matricularAlunoEmTurma(aluno.getMatricula(), turmaTeste.getIdTurma()); // repetido

        assertEquals(1, turmaTeste.getNumeroDeAlunos());
        assertEquals(1, controle.getTurmasDoAluno(aluno.getMatricula()).size());
    }

}
