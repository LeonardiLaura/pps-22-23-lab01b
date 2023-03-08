package e1;

public class KnightMovementStrategy implements PieceMovementStrategy {
    @Override
    public boolean checkMovement(int previousRow, int previousColumn, int newRow, int newColumn) {
        int x = newRow - previousRow;
        int y = newColumn - previousColumn;
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            return true;
            /*
            this.knight = new Pair<>(row,col);
            return this.pawn.equals(this.knight);
             */
        }
        return false;
    }
}
