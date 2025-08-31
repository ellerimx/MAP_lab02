//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import main.Aluno;
//import main.Disciplina;
//import main.Professor;
//import main.Turma;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class TurmaTest {
//	//idturma, disciplina, lista alunos, professor, horario
//
//	private Turma turma; // disciplina, idTurma
//	private Disciplina disciplina;
//	private Aluno aluno1;
//	private Aluno aluno2;
//	private Professor professor;
//
//	private static final String ID_TURMA ="T001";
//	private static final String NOME_DISCIPLINA = "MAP";
//	private static final String ID_DISCIPLINA = "D001";
//	private static final String ID_PROF = "P001";
//	private static final String NOME_PROF = "Sabrina";
//
//
//	@BeforeEach
//    void setUp() {
//        disciplina = new Disciplina(NOME_DISCIPLINA, ID_DISCIPLINA);
//        turma = new Turma(disciplina, ID_TURMA);
//        professor = new Professor(ID_PROF, NOME_PROF);
//        aluno1 = new Aluno("A001", "Maria");
//        aluno2 = new Aluno("A002", "João");
//    }
//
//	@Test
//	// construtor e getters
//    void testConstrutorEGetters() {
//        assertEquals(ID_TURMA, turma.getIdTurma(), "O id da turma deve ser o mesmo do construtor");
//        assertEquals(disciplina, turma.getDisciplina(), "A disciplina deve ser a mesma do construtor");
//        assertNotNull(turma.getListaDeAlunos(), "A lista de alunos não deve ser nula");
//        assertTrue(turma.getListaDeAlunos().isEmpty(), "A lista de alunos deve começar vazia");
//        assertNull(turma.getProfessor(), "Professor deve iniciar nulo");
//        assertNull(turma.getHorario(), "Horário deve iniciar nulo");
//    }
//
//	@Test
//	//conferir professor
//    void testSetGetProfessor() {
//        turma.setProfessor(professor);
//        assertEquals(professor, turma.getProfessor(), "O professor deve ser o mesmo que foi definido");
//    }
//
//    @Test
//    // conferir horario
//    void testSetGetHorario() {
//        String horario = "Segunda 10h";
//        turma.setHorario(horario);
//        assertEquals(horario, turma.getHorario(), "O horário deve ser o mesmo que foi definido");
//    }
//
//    @Test
//    // add aluno em turma
//    void testAdicionarAluno() {
//        turma.adicionarAluno(aluno1);
//        assertEquals(1, turma.getNumeroDeAlunos(), "Deve haver 1 aluno apos adicionar");
//        assertTrue(turma.getListaDeAlunos().contains(aluno1), "A lista deve conter o aluno adicionado");
//    }
//
//    @Test
//    // add aluno ja existente
//    void testAdicionarAlunoExistente() {
//        turma.adicionarAluno(aluno1);
//        turma.adicionarAluno(aluno1);
//        assertEquals(1, turma.getNumeroDeAlunos(), "O aluno ja foi adicionado nessa turma");
//    }
//
//    @Test
//    // add aluno nulo
//    void testAdicionarAlunoNulo() {
//        turma.adicionarAluno(null);
//        assertEquals(0, turma.getNumeroDeAlunos(), "Aluno nulo não deve ser adicionado");
//    }
//
//    @Test
//    void testNumeroDeAlunos() {
//        turma.adicionarAluno(aluno1);
//        turma.adicionarAluno(aluno2);
//        assertEquals(2, turma.getNumeroDeAlunos(), "O número de alunos deve ser o total de alunos adicionados");
//    }
//
//}
