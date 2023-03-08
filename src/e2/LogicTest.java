package e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogicTest {

    private static final int SIZE = 7;
    private static final int MINES = 5;
    private Logics logic;

    @BeforeEach
    void beforeEach(){
        this.logic = new LogicsImpl(SIZE, MINES);
    }

    @Test
    void checkMinesNumber(){
        Assertions.assertEquals(this.logic.getActiveMinesNumber(),MINES);
    }
}
