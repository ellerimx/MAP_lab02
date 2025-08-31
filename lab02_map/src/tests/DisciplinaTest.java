package tests;

import main.Disciplina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DisciplinaTest {

	// nome e idDisciplina
    private Disciplina disciplina;

    private static final String NOME_DISCIPLINA_PADRAO = "MAP";
    private static final String ID_DISCIPLINA_PADRAO = "D001";

    @BeforeEach
    void setUp() {
        disciplina = new Disciplina(NOME_DISCIPLINA_PADRAO, ID_DISCIPLINA_PADRAO);
    }

    @Test
    void testConstrutorEGetters() {
        Assertions.assertEquals(NOME_DISCIPLINA_PADRAO, disciplina.getNome(), "O nome deve ser igual ao do construtor.");
        Assertions.assertEquals(ID_DISCIPLINA_PADRAO, disciplina.getIdDisciplina(), "O id deve ser igual ao do construtor.");
    }
}