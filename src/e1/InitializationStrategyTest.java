package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class InitializationStrategyTest {
    
    private static final int PIECE_1_ROW = 1;
    private static final int PIECE_1_COLUMN = 1;
    private static final int PIECE_2_ROW = 4;
    private static final int PIECE_2_COLUMN = 2;

    private static final int PIECE_1_INVALID_ROW = -1;
    private static final int PIECE_1_INVALID_COLUMN = -2;
    private static final int PIECE_2_INVALID_ROW = 5;
    private static final int PIECE_2_INVALID_COLUMN = 7;
    private static final int SIZE = 5;
    private InitializationStrategy strategy;


    @Test
    void checkDefinedStrategyOk(){
        Pair<Integer, Integer> piece1 = new Pair<>(PIECE_1_ROW, PIECE_1_COLUMN);
        Pair<Integer, Integer> piece2 = new Pair<>(PIECE_2_ROW, PIECE_2_COLUMN);
        Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> placement = new Pair<>(piece1,piece2);
        this.strategy = new DefinedInitializatonStrategy(SIZE, PIECE_1_ROW, PIECE_1_COLUMN, PIECE_2_ROW, PIECE_2_COLUMN);
        Assertions.assertEquals(placement, this.strategy.place());
    }

    @Test
    void checkDefinedStrategyOutOfBound(){
        this.strategy = new DefinedInitializatonStrategy(SIZE, PIECE_1_INVALID_ROW, PIECE_1_INVALID_COLUMN, PIECE_2_INVALID_ROW, PIECE_2_INVALID_COLUMN);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.place());
    }

    @Test
    void checkDefinedStrategyNotEquals(){
        this.strategy = new DefinedInitializatonStrategy(SIZE, PIECE_1_ROW, PIECE_1_COLUMN, PIECE_1_ROW, PIECE_1_COLUMN);
        Assertions.assertThrows(Exception.class, () -> this.strategy.place());
    }

    @Test
    void checkRandomStrategyNotEquals(){
        this.strategy = new RandomInitializatonStrategy(SIZE);
        Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> placement = this.strategy.place();
        Assertions.assertNotEquals(placement.getX(), placement.getY());
    }
    @Test
    void checkRandomStrategyOutOfBound(){
        this.strategy = new RandomInitializatonStrategy(SIZE);
        Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> placement = this.strategy.place();
        int value = placement.getX().getX();
        Assertions.assertFalse(value < 0 || value >= SIZE);
        value = placement.getX().getY();
        Assertions.assertFalse(value < 0 || value >= SIZE);
        value = placement.getY().getX();
        Assertions.assertFalse(value < 0 || value >= SIZE);
        value = placement.getY().getY();
        Assertions.assertFalse(value < 0 || value >= SIZE);

    }
}
