package fr.ubx.poo.model.go.character;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.Unplayer;

public class Monster extends Unplayer implements Movable {

    public Monster (Game game, Position position){super (game, position);}

    @Override
    public String toString() { return "Monster"; }

    @Override
    public void doMove(Direction direction) { }

    @Override
    public boolean canMove(Direction direction) { return false; }
}
