package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovementStrategyTest {

    private static final int NEW_COLUMN = 2;
    private static final int NEW_ROW = 3;
    private static final int PREVIOUS_COLUMN = 1;
    private static final int PREVIOUS_ROW = 1;
    public static final int INVALID_COLUMN = 2;
    public static final int INVALID_ROW = 2;
    private PieceMovementStrategy strategy;

    @BeforeEach
    void beforeEach(){
        this.strategy = new KnightMovementStrategy();
    }

    @Test
    void checkMovementType(){
        Assertions.assertInstanceOf(Boolean.class, this.strategy.checkMovement(PREVIOUS_ROW, PREVIOUS_COLUMN, NEW_ROW, NEW_COLUMN));
    }

    @Test
    void checkMovement(){
        Assertions.assertTrue(this.strategy.checkMovement(PREVIOUS_ROW, PREVIOUS_COLUMN, NEW_ROW, NEW_COLUMN));
    }

    @Test
    void checkInvalidMovement(){
        Assertions.assertFalse(this.strategy.checkMovement(PREVIOUS_ROW, PREVIOUS_COLUMN, INVALID_ROW, INVALID_COLUMN));
    }

}
