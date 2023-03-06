package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovementStrategyTest {

    private static final Object NEW_COLUMN = 2;
    private static final Object NEW_ROW = 3;
    private static final Object PREVIOUS_COLUMN = 1;
    private static final Object PREVIOUS_ROW = 1;
    private PieceMovementStrategy strategy;

    @BeforeEach
    void beforeEach(){
        this.strategy = new KnightMovementStrategy();
    }

    @Test
    void checkMovementType(){
        Assertions.assertInstanceOf(Boolean.class, this.strategy.checkMovement(PREVIOUS_ROW, PREVIOUS_COLUMN, NEW_ROW, NEW_COLUMN));
    }

}
