package e1;

public interface PieceMovementStrategy {
    boolean checkMovement(int previousRow, int previousColumn, int newRow, int newColumn);
}
