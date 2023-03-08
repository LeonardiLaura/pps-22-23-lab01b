package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private final PieceMovementStrategy movementStrategy;
	private final InitializationStrategy initializationStrategy;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
		this.movementStrategy = new KnightMovementStrategy();
		this.size = size;
		this.initializationStrategy = new RandomInitializatonStrategy(this.size);
		Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> placement = this.initializationStrategy.place();
		this.knight = placement.getX();
		this.pawn = placement.getY();
    }

	public LogicsImpl(int size, int knightRow, int knightColumn, int pawnRow, int pawnColumn, PieceMovementStrategy movementStrategy) {
		this.size = size;
		this.movementStrategy = movementStrategy;
		this.initializationStrategy = new DefinedInitializatonStrategy(this.size, knightRow, knightColumn, pawnRow, pawnColumn);
		Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> placement = this.initializationStrategy.place();
		this.knight = placement.getX();
		this.pawn = placement.getY();
	}

	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight

		if(this.movementStrategy.checkMovement(this.knight.getX(), this.knight.getY(), row,col)){
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
