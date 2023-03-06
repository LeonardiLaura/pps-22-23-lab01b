package e1;

import org.junit.jupiter.api.BeforeEach;

public class MovementStrategyTest {

    private PieceMovementStrategy strategy;

    @BeforeEach
    void beforeEach(){
        this.strategy = new KnightMovementStrategy();
    }


}
