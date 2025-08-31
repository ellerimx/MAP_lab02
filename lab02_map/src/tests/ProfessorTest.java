//package test;
//
//import main.Disciplina;
//import main.Professor;
//import main.Turma;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class ProfessorTest {
//	// nome, id e turmas
//
//    private Professor professor;
//    private Turma turmaTeste;
//
//    private static final String ID_PADRAO = "P001";
//    private static final String NOME_PADRAO = "Sabrina";
//
//  //  private static final String NOME_DISCIPLINA_1 = "MAP";
//
//    @BeforeEach
//    void setUp() {
//        professor = new Professor(NOME_PADRAO, ID_PADRAO);
//        Disciplina disciplina = new Disciplina("MAP","D001");
//        turmaTeste = new Turma(disciplina, "T001");
//    }
//
//    @Test
//    void testConstrutorEGetters() {
//
//        Assertions.assertEquals(NOME_PADRAO, professor.getNome(), "O nome deve ser o mesmo do construtor.");
//        Assertions.assertEquals(ID_PADRAO, professor.getIDProfessor(), "O ID deve ser o mesmo do construtor.");
//
//        Assertions.assertNotNull(professor.getTurmas(), "A lista de turmas não deve ser nula.");
//        Assertions.assertTrue(professor.getTurmas().isEmpty(), "A lista de turma deve estar vazia inicialmente.");
//    }
//
//
//    //add turma
//    @Test
//    void testAdicionarTurma() {
//        professor.adicionarTurma(turmaTeste);
//        Assertions.assertEquals(1, professor.getTurmas().size(), "O número de turmas deve ser 1 apos adicionada");
//        Assertions.assertTrue(professor.getTurmas().contains(turmaTeste), "A lista deve conter a turma adicionada");
//    }
//
//    //add turma nula
//    @Test
//    void testAdicionarTurma_nula() {
//    	int tamanhoInicial = professor.getTurmas().size();
//        professor.adicionarTurma(null);
//
//        Assertions.assertEquals(tamanhoInicial, professor.getTurmas().size(), "A lista nao deve ser alterada ao adicionar uma turma nula");
//   }
//
//    // add turma já existente
//    @Test
//    void testAdicionarTurma_existente() {
//    	professor.adicionarTurma(turmaTeste);
//        professor.adicionarTurma(turmaTeste);
//        Assertions.assertEquals(1, professor.getTurmas().size(), "A mesma turma nao deve ser adicionada mais de uma vez");
//     }
//}