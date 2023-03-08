package e1;

import java.util.Optional;

public class DefinedInitializatonStrategy implements InitializationStrategy {

    private final int size;
    public DefinedInitializatonStrategy(int size) {
        this.size=size;
    }
    public Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> place(Optional<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> positions) {
        int x1=positions.get().getX().getX();
        int y1=positions.get().getX().getY();
        int x2=positions.get().getY().getX();
        int y2=positions.get().getY().getY();
        if( this.isOutOfBound(x1) || this.isOutOfBound(y1) ||
                this.isOutOfBound(x2) || this.isOutOfBound(y2) ) {
            throw new IndexOutOfBoundsException();
        }
        return positions.get();
    }

    private boolean isOutOfBound(Integer val){
        return ( val < 0 || val >= this.size);
    }

}
