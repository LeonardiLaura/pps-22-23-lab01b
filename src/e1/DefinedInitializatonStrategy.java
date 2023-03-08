package e1;

import java.util.Optional;

public class DefinedInitializatonStrategy implements InitializationStrategy {

    private final int size;
    public DefinedInitializatonStrategy(int size) {
        this.size=size;
    }
    public Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> place(Optional<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> positions) {
        return positions.get();
    }

}
