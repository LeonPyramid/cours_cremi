package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;

public class BombInc  extends Unplayer{

    public BombInc (Game game, Position position) {super(game, position);}

    @Override
    public String toString() {
        return "BombNumberInc";
    }
}
