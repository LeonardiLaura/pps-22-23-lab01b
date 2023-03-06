package e1;

public class KnightMovementStrategy implements PieceMovementStrategy {
    @Override
    public boolean checkMovement(Object previousRow, Object previousColumn, Object newRow, Object newColumn) {
        return false;
    }
}
