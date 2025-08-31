//package test;
//
//import main.Aluno;
//import main.Disciplina;
//import main.Turma;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class AlunoTest {
//
//	// nome, matricula, turma
//
//    private Aluno aluno;
//    private Turma turmaTeste;
//
//    private static final String MATRICULA_PADRAO = "A002";
//    private static final String NOME_PADRAO = "João";
//
//    @BeforeEach //garante que nenhum valor seja armazenado
//    void setUp() {
//        aluno = new Aluno(NOME_PADRAO, MATRICULA_PADRAO);
//
//        Disciplina disciplinaSO = new Disciplina ("SO", "A002");
//
//        turmaTeste = new Turma(disciplinaSO, "B002");
//    }
//
//    // Construtor e Getters
//    @Test
//    void testConstrutorEGetters() {
//        Assertions.assertEquals(MATRICULA_PADRAO, aluno.getMatricula(), "A matricula deve ser o igual ao do construtor.");
//        Assertions.assertEquals(NOME_PADRAO, aluno.getNome(), "O nome inicial deve ser o mesmo do construtor.");
//        Assertions.assertNotNull(aluno.getTurmas(), "A lista de turma não deve ser nula.");
//        Assertions.assertTrue(aluno.getTurmas().isEmpty(), "A lista de turma deve estar vazia inicialmente.");
//    }
//
//    // Teste 2: add uma turma valida ()
//    @Test
//    void testSetAddTurma() {
//    	aluno.adicionarTurma(turmaTeste);
//
//    	Assertions.assertEquals(1, aluno.getTurmas().size(), "O numero de turmas deve ser 1");
//        Assertions.assertTrue(aluno.getTurmas().contains(turmaTeste), "A lista deve ter a turma adicionada");
//    }
//
//    // teste 3: nao add turma nula
//    @Test
//    void testAdicionarTurma_nula() {
//        int tamanhoInicial = aluno.getTurmas().size();
//
//        aluno.adicionarTurma(null);
//
//        Assertions.assertEquals(tamanhoInicial, aluno.getTurmas().size(), "A lista nao deve ser alterada");
//    }
//
// // teste 4: nao entrar numa turma que o aluno ja esteja
//    @Test
//    void testAdicionarTurma_jaExistente() {
//        aluno.adicionarTurma(turmaTeste);
//        aluno.adicionarTurma(turmaTeste);
//
//        Assertions.assertEquals(1, aluno.getTurmas().size(), "A mesma turma nao pode ser adicionada mais de uma vez");
//    }
//}