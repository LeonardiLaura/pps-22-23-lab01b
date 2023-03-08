package e1;

import java.util.Optional;

public class DefinedInitializatonStrategy implements InitializationStrategy {

    private final int size;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DefinedInitializatonStrategy(int size, int x1, int y1, int x2, int y2) {
        this.size=size;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    public Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> place() {
        if( this.isOutOfBound(x1) || this.isOutOfBound(y1) ||
                this.isOutOfBound(x2) || this.isOutOfBound(y2) ) {
            throw new IndexOutOfBoundsException();
        }
        return new Pair<>(new Pair<>(x1,y1), new Pair<>(x2, y2));
    }

    private boolean isOutOfBound(Integer val){
        return ( val < 0 || val >= this.size);
    }

}
