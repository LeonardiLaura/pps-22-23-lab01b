package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class InitializationStrategyTest {


    private static final int PIECE_1_ROW = 1;
    private static final int PIECE_1_COLUMN = 1;
    private static final int PIECE_2_ROW = 4;
    private static final int PIECE_2_COLUMN = 2;
    private static final int SIZE = 5;
    private InitializationStrategy strategy;


    @Test
    void checkDefinedStrategyOk(){
        Pair<Integer, Integer> piece1 = new Pair<>(PIECE_1_ROW,PIECE_1_COLUMN);
        Pair<Integer, Integer> piece2 = new Pair<>(PIECE_2_ROW,PIECE_2_COLUMN);
        Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> placement = new Pair<>(piece1,piece2);
        this.strategy = new DefinedInitializatonStrategy(SIZE);
        Assertions.assertEquals(placement, this.strategy.place(Optional.of(placement)));
    }

}
