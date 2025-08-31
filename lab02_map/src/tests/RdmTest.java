package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Aluno;
import main.Disciplina;
import main.Turma;
import main.Rdm;

class RdmTest {

    private Aluno aluno;
    private Turma turma;
    private Rdm rdm;
    private LocalDate data;

    @BeforeEach
    void setUp() {
        aluno = new Aluno("Maria", "A001");
        Disciplina disciplina = new Disciplina("MAP", "D001");
        turma = new Turma(disciplina, "T001");
        data = LocalDate.now();
        rdm = new Rdm(aluno, turma, data);
    }

    @Test
    void testCriacaoRdm() {
        assertNotNull(rdm, "Rdm deve ser criado");
        assertEquals(aluno, rdm.getAluno(), "O aluno deve ser o mesmo do construtor");
        assertEquals(turma, rdm.getTurma(), "A turma deve ser a mesma do construtor");
        assertEquals(data, rdm.getData(), "a data deve ser a mesma do construtor");
    }

    @Test
    void testToString() {
        String esperado = aluno.getNome() + " matriculado em " +
                          turma.getDisciplina().getNome() +
                          " (" + turma.getIdTurma() + ") em " + data;
        assertEquals(esperado, rdm.toString(), "deve retornar a descrição certa da matrícula");
    }
}
