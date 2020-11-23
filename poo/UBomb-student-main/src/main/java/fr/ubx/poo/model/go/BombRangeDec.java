package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;

public class BombRangeDec extends Unplayer {

    public BombRangeDec(Game game, Position position){super(game,position);}

    @Override
    public String toString() {
        return "BombRangeDec";
    }

}
