package e1;

import java.util.Optional;
import java.util.Random;

public class RandomInitializatonStrategy implements InitializationStrategy {
    private final int size;
    private final Random random = new Random();
    public RandomInitializatonStrategy(int size) {
        this.size=size;
    }

    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> place(Optional<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> positions) {

        Pair<Integer,Integer> pos1 = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        Pair<Integer,Integer> pos2;
        do {
             pos2 = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        }while (pos1.equals(pos2));
        // the recursive call below prevents clash with an existing pawn
        return new Pair<>(pos1,pos2);
    }
}
