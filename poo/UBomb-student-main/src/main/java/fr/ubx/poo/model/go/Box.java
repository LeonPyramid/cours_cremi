/*
 * Copyright (c) 2020. Laurent Réveillère
 */
/*
*package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.game.Game;
import javafx.geometry.Pos;

public class Box extends GameObject implements Movable{

    private boolean moveRequested = false;

    public Box(Game game, Position position){

    }

    public void requestMove(Direction direction) {
        if (direction != this.direction) {
            this.direction = direction;
        }
        moveRequested = true;
    }


    @Override
    public String toString() { return "Box"};

    @Override
    public boolean canMove(Direction direction) {
        Position newPos = direction.nextPosition(this.getPosition());

        if(!newPos.inside(game.getWorld().dimension)) {
            return false;
        }

        if(!game.getWorld().isEmpty(newPos)) {
            return false;
        }

        if (!game.getWorld().)

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

 */
