package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.game.World;

//TODO a faire complet
public  class Bomb extends Unplayer{

    public Bomb (Game game, Position position){
        super(game, position);
        bombuse();

    }


    public void bombuse(){
        explosion();
        
    }

    private void explosion(){
        Position pos = this.getPosition();
        World world = this.game.getWorld();


    }

}
