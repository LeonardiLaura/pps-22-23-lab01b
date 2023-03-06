package e1;

public interface PieceMovementStrategy {
    boolean checkMovement(Object previousRow, Object previousColumn, Object newRow, Object newColumn);
}
