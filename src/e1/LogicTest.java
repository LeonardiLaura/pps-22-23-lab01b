package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class LogicTest {
    private static final int SIZE = 5;
    private static final int KNIGHT_ROW = 1;
    private static final int KNIGHT_COLUMN = 1;
    private static final int KNIGHT_MOVEMENT_ROW = 2;
    private static final int KNIGHT_MOVEMENT_COLUMN = 3;
    private static final int PAWN_ROW = 4;
    private static final int PAWN_COLUMN = 2;
    public static final int ROW_OUT_OF_BOUND = 2;
    public static final int COLUMN_OUT_OF_BOUND = -1;
    private Logics logic ;

    @BeforeEach
    void beforeEach(){
        this.logic = new LogicsImpl(SIZE, KNIGHT_ROW, KNIGHT_COLUMN, PAWN_ROW, PAWN_COLUMN);
    }

    @Test
    void testKnight(){
        Assertions.assertTrue(this.logic.hasKnight(KNIGHT_ROW, KNIGHT_COLUMN));
    }

    @Test
    void testPawn(){
        Assertions.assertTrue(this.logic.hasPawn(PAWN_ROW, PAWN_COLUMN));
    }

    @Test
    void testHit(){
        Assertions.assertFalse(this.logic.hit(KNIGHT_MOVEMENT_ROW, KNIGHT_MOVEMENT_COLUMN));
        Assertions.assertTrue(this.logic.hit(PAWN_ROW, PAWN_COLUMN));
    }

    @Test
    void testOutOfBound(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(ROW_OUT_OF_BOUND, COLUMN_OUT_OF_BOUND) );
    }
    

}
