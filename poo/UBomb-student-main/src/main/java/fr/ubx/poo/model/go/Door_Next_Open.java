
package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;

    public class Door_Next_Open extends Unplayer implements Movable {

        public Door_Next_Open(Game game, Position position){super(game, position);}

        @Override
        public String toString() {
            return "DoorNextOpened";
        }

        @Override
        public boolean canMove(Direction direction) {
            return false;
        }

        @Override
        public void doMove(Direction direction) {

        }
    }


