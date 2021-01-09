package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;

public class Princess extends Unplayer{

    public Princess (Game game, Position position){super(game, position);}

    @Override
    public String toString() {
        return "Princess";
    }
    }

