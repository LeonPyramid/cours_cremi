package fr.ubx.poo.game;


public class PositionAlreadyTakenException extends RuntimeException {
	public PositionAlreadyTakenException(String message) {
        super(message);
    }
}
