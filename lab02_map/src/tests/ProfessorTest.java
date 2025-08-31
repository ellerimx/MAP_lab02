package tests;

import main.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfessorTest {
	// nome, id 

    private Professor professor;

    private static final String ID_PADRAO = "P001";
    private static final String NOME_PADRAO = "Sabrina";

  //  private static final String NOME_DISCIPLINA_1 = "MAP";

    @BeforeEach
    void setUp() {
        professor = new Professor(NOME_PADRAO, ID_PADRAO);
        
    }

    @Test
    void testConstrutorEGetters() {

        Assertions.assertEquals(NOME_PADRAO, professor.getNome(), "O nome deve ser o mesmo do construtor.");
        Assertions.assertEquals(ID_PADRAO, professor.getIDProfessor(), "O ID deve ser o mesmo do construtor.");
    }

}