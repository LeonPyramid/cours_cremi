/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.game.Game;

public class Box extends GameObject implements Movable {

    Direction direction = null;
    private boolean moveRequested = false;

    public Box(Game game, Position position) {
            super(game,position);

    }


    @Override
    public String toString() {return "Box"; }

    public void requestMove(Direction direction) {
        if (direction != this.direction) {
            this.direction = direction;
        }
        moveRequested = true;
    }



    @Override
    public boolean canMove(Direction direction) {
        Position newPos = direction.nextPosition(this.getPosition());

        if (!newPos.inside(game.getWorld().dimension)) {
            return false;
        }

        if (!game.getWorld().isEmpty(newPos)) {
            return false;
        }

        if (game.getWorld().returnMovable(newPos) != null) {
            return false;
        }

        return true;

    }

    @Override
    public void doMove(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        setPosition(nextPos);
    }

    public void update(long now) {
        if (moveRequested) {
            if (canMove(direction)) {
                doMove(direction);
            }
        }
        moveRequested = false;
    }
}

