package e2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LogicsImpl implements Logics {

    private final int size;
    private final Random random = new Random();
    private final Map<Pair<Integer, Integer>,Boolean> activeMines;

    public LogicsImpl(int size, int mines) {
        this.size = size;
        this.activeMines = new HashMap<>();
        this.placeMine(mines);
    }

    private void placeMine(int mines) {
        Pair<Integer, Integer> pos;
        do{
            pos = new Pair<>(random.nextInt(this.size), random.nextInt(this.size));
        }while(this.activeMines.containsKey(pos));
        this.activeMines.put(pos,Boolean.TRUE);
        if(mines>1){
            this.placeMine(mines-1);
        }
    }

    @Override
    public int getActiveMinesNumber() {
        return (int) this.activeMines.values().stream().filter(x -> x.equals(Boolean.TRUE)).count();
    }


}
