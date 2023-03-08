package e1;

public class KnightMovementStrategy implements PieceMovementStrategy {
    @Override
    public boolean checkMovement(int previousRow, int previousColumn, int newRow, int newColumn) {
        int x = newRow - previousRow;
        int y = newColumn - previousColumn;
        return (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3);
    }
}
