package tests;

import static org.junit.jupiter.api.Assertions.*;

import main.Aluno;
import main.Disciplina;
import main.Professor;
import main.Rdm;
import main.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurmaTest {
	//idturma, disciplina, lista alunos, professor, horario

	private Turma turma; // disciplina, idTurma
	private Disciplina disciplina;
	private Aluno aluno1;
	private Aluno aluno2;
	private Professor professor;

	private static final String ID_TURMA ="T001";
	private static final String NOME_DISCIPLINA = "MAP";
	private static final String ID_DISCIPLINA = "D001";
	private static final String ID_PROF = "P001";
	private static final String NOME_PROF = "Sabrina";


	@BeforeEach
    void setUp() {
        disciplina = new Disciplina(NOME_DISCIPLINA, ID_DISCIPLINA);
        turma = new Turma(disciplina, ID_TURMA);
        professor = new Professor(ID_PROF, NOME_PROF);
        aluno1 = new Aluno("A001", "Maria");
        aluno2 = new Aluno("A002", "João");
    }

	@Test
	// construtor e getters
    void testConstrutorEGetters() {
		assertEquals(ID_TURMA, turma.getIdTurma());
        assertEquals(disciplina, turma.getDisciplina());
        assertNotNull(turma.getListaDeAlunos());
        assertTrue(turma.getListaDeAlunos().isEmpty());
        assertNull(turma.getProfessor());
        assertNull(turma.getHorario());
        assertNotNull(turma.getRdms());
        assertTrue(turma.getRdms().isEmpty());
    }

	@Test
	//conferir professor
    void testSetGetProfessor() {
        turma.setProfessor(professor);
        assertEquals(professor, turma.getProfessor(), "O professor deve ser o mesmo que foi definido");
    }

    @Test
    // conferir horario
    void testSetGetHorario() {
        String horario = "Segunda 10h";
        turma.setHorario(horario);
        assertEquals(horario, turma.getHorario(), "O horário deve ser o mesmo que foi definido");
    }

    //matricular aluno
    @Test
    void testMatricularAluno() {
        Rdm rdm = turma.matricular(aluno1);
        assertNotNull(rdm, "Rdm deve ser criado");
        assertEquals(1, turma.getNumeroDeAlunos());
        assertTrue(turma.getListaDeAlunos().contains(aluno1));
        assertEquals(1, turma.getRdms().size());
        assertEquals(aluno1, rdm.getAluno());
        assertEquals(turma, rdm.getTurma());
    }
    

    @Test
    void testMatricularAlunoDuplicado() {
        turma.matricular(aluno1);
        Rdm rdmDuplicado = turma.matricular(aluno1);
        assertNull(rdmDuplicado);
        assertEquals(1, turma.getNumeroDeAlunos());
        assertEquals(1, turma.getRdms().size());
    }

    @Test
    void testMatricularAlunoNulo() {
        Rdm rdm = turma.matricular(null);
        assertNull(rdm, "Não deve criar rdm para aluno nulo");
        assertEquals(0, turma.getNumeroDeAlunos());
        assertTrue(turma.getListaDeAlunos().isEmpty());
        assertTrue(turma.getRdms().isEmpty());
    }

  
    @Test
    void testNumeroDeAlunos() {
        turma.matricular(aluno1);
        turma.matricular(aluno2);
        assertEquals(2, turma.getNumeroDeAlunos(), "O número de alunos deve ser o total de alunos adicionados");
    }

}
