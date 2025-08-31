package tests;

import static org.junit.jupiter.api.Assertions.*;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleAcademicoTest {
	
	private ControleAcademico controle;

	@BeforeEach
	void setUp() {
		controle = new ControleAcademico();
	}

	// listas vazias - professor, alunos, turmas e disciplinas
	@Test
    void testListasIniciamVazias() {
        assertTrue(controle.getListaProfessores().isEmpty());
        assertTrue(controle.getListaAlunos().isEmpty());
        assertTrue(controle.getListaTurmas().isEmpty());
        assertTrue(controle.getListaDisciplinas().isEmpty());
    }
	
	// teste de adicionar disciplina
	@Test
    void testAdicionarDisciplina() {
        Disciplina d = controle.adicionarDisciplina("SO", "D002");
        assertNotNull(d);
        assertEquals("D002", d.getIdDisciplina());
        assertEquals(1, controle.getListaDisciplinas().size());
    }

	// teste p criar professor
	@Test
    void testCriarProfessor() {
        Professor p = controle.criarProfessor("Fabio", "P003");
        assertNotNull(p);
        assertEquals("Fabio", p.getNome());
        assertEquals(1, controle.getListaProfessores().size());
    }
	
	// teste p criar aluno
	@Test
    void testCriarAluno() {
        Aluno a = controle.criarAluno("Roberta", "A003");
        assertNotNull(a);
        assertEquals("A003", a.getMatricula());
        assertEquals(1, controle.getListaAlunos().size());
    }
	
	//teste p criar turma
	@Test
    void testCriarTurma() {
        Disciplina d = controle.adicionarDisciplina("BD", "D003");
        Professor p = controle.criarProfessor("Fabio", "P003");
        Turma t = controle.criarTurma(d, p, "T003");

        assertNotNull(t);
        assertEquals("T003", t.getIdTurma());
        assertEquals(p, t.getProfessor());
        
        assertTrue(controle.getTurmasDoProfessor(p.getIDProfessor()).contains(t)); // por meio do controle
        assertEquals(1, controle.getListaTurmas().size());
    }

 // codigos de disciplina, aluno, professor e turma
	
    @Test
    void testGetDisciplinaPorCodigo() {
        controle.adicionarDisciplina("MAP", "D001");
        Disciplina d = controle.getDisciplinaPorCodigo("D001");
        assertNotNull(d);
        assertEquals("MAP", d.getNome());
    }
    
    @Test
    void testGetDisciplinaPorCodigoInexistente() {
        assertNull(controle.getDisciplinaPorCodigo("D000"));
    }

    @Test
    void testGetAlunoPorCodigo() {
        controle.criarAluno("João", "A002");
        Aluno a = controle.getAlunoPorCodigo("A002");
        assertNotNull(a);
        assertEquals("João", a.getNome());
    }

    @Test
    void testGetProfessorPorCodigo() {
        controle.criarProfessor("Sabrina", "P001");
        Professor p = controle.getProfessorPorCodigo("P001");
        assertNotNull(p);
        assertEquals("Sabrina", p.getNome());
    }
    
    @Test
    void testGetProfessorCodigoInexistente() {
    	assertNull(controle.getProfessorPorCodigo("P000"));
    }

    @Test
    void testGetTurmaPorCodigo() {
        Disciplina d = controle.adicionarDisciplina("LOGICA", "D003");
        Professor p = controle.criarProfessor("EDSON", "P003");
        
        controle.criarTurma(d, p, "T003");
        
        Turma t = controle.getTurmaPorCodigo("T003");
        assertNotNull(t);
        assertEquals("T003", t.getIdTurma());
    }
    
    @Test
    void testGetTurmaPorCodigoInexistente() {
    	assertNull(controle.getTurmaPorCodigo("T000"));
    }

    //teste de matricular aluno
    @Test
    void testMatricularAlunoEmTurma() {
        Disciplina d = controle.adicionarDisciplina("MAP", "D001");
        Professor p = controle.criarProfessor("Sabrina", "P001");
        
        Turma t = controle.criarTurma(d, p, "T001");
        Aluno a = controle.criarAluno("João", "A002");

        controle.matricularAlunoEmTurma("A002", "T001");

        assertTrue(t.getListaDeAlunos().contains(a));
        assertTrue(controle.getTurmasDoAluno(a.getMatricula()).contains(t));
    }

    @Test
    void testAtribuirProfessorATurma() {
        Disciplina d = controle.adicionarDisciplina("BD", "D004");
        Professor p1 = controle.criarProfessor("Fabio", "P004");
        Professor p2 = controle.criarProfessor("Sabrina", "P001");
        Turma t = controle.criarTurma(d, p1, "T004");

        controle.atribuirProfessorATurma("P001", "T004");

        assertEquals(p2, t.getProfessor());
        
        assertTrue(controle.getTurmasDoProfessor(p2.getIDProfessor()).contains(t));
    }

    @Test
    void testMatricularAlunoQuandoAlunoInexistenteNaoAlteraTurma() {
        Disciplina d = controle.adicionarDisciplina("SO", "D001");
        Professor p = controle.criarProfessor("Sabrina", "P001");
        Turma t = controle.criarTurma(d, p, "T001");

        int antes = t.getNumeroDeAlunos();
        controle.matricularAlunoEmTurma("A999", "T001"); // aluno n cadastrado

        assertEquals(antes, t.getNumeroDeAlunos(), "A turma não deve alterar se o aluno não existe");
        assertTrue(t.getListaDeAlunos().isEmpty(), "Lista deve permanecer vazia");
    }

    @Test
    void testMatricularAlunoEmTurmaInexistenteNaoAlteraAluno() {
        Aluno a = controle.criarAluno("João", "A001");
        int antes = controle.getTurmasDoAluno(a.getMatricula()).size();

        controle.matricularAlunoEmTurma("A001", "T999"); //turma não cadastrada

        assertEquals(antes, controle.getTurmasDoAluno(a.getMatricula()).size(), "Não é possível matricular em turma inexistente");
    }

    @Test
    void testMatricularAlunoDuasVezesMesmaTurmaNaoDuplicaRegistro() {
        Disciplina d = controle.adicionarDisciplina("MAP", "D002");
        Professor p = controle.criarProfessor("Fabio", "P002");
        Turma t = controle.criarTurma(d, p, "T002");
        Aluno a = controle.criarAluno("Maria", "A002");

        controle.matricularAlunoEmTurma("A002", "T002");
        controle.matricularAlunoEmTurma("A002", "T002"); // repetido

        assertEquals(1, t.getNumeroDeAlunos(), "Um mesmo aluno não deve entrar 2x na turma");
        assertEquals(1, controle.getTurmasDoAluno(a.getMatricula()).size(), "Aluno não deve ter a mesma turma 2x");
    } 
    

    @Test
    void testAtribuirProfessorComCodigosInvalidosNaoAlteraTurmaInvalida() {

        //situacao em que professor e turma sao invalidas
        Disciplina d = controle.adicionarDisciplina("BD", "D004");
        Professor p1 = controle.criarProfessor("Fabio", "P004");
        Turma t = controle.criarTurma(d, p1, "T004");


        controle.atribuirProfessorATurma("P999", "T004");
        assertEquals(p1, t.getProfessor(), "Professor com código inválido não deve mudar");


        controle.atribuirProfessorATurma("P004", "T999");
        assertEquals(p1, t.getProfessor(), "Nada deve ser alterado se turma não existe");
    }



}
