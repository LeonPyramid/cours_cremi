package fr.ubx.poo.model.go;

import fr.ubx.poo.engine.GameEngine;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.game.World;
import fr.ubx.poo.view.sprite.SpriteFactory;

//TODO a faire complet
public  class Bomb extends Unplayer{
    private int numSprite;
    private long oldNow;

    public Bomb (Game game, Position position){
        super(game, position);
        this.numSprite = 0;
        this.oldNow = 0;
        bombuse();

    }


    public void bombuse(){
        loopSprite();
        explosion();
        
    }

    private void explosionDirection (World world,Direction direction, Position start){

        Position newPos = start;


        for (int range = 0; range<game.getPlayer().getBombRange(); range++){

            newPos = direction.nextPosition(newPos);
            if (!world.isEmpty(newPos)){
                break;
            }
            if (newPos.equals(game.getPlayer().getPosition())){
                game.getPlayer().setLives(game.getPlayer().getLives()-1);
            }

            GameObject mov = world.returnMovable(newPos);

            if (mov instanceof Key || mov instanceof Door_Next_Open || mov instanceof Door_Next_Closed || mov instanceof  Door_Prev_Open){
                break;
            }

            if (  mov != null ){
                world.RemoveMovable(mov);
                GameEngine.RemoveSprite(SpriteFactory.createMovables(GameEngine.getLayer(),newPos,mov));
                break;
            }



        }
    }
    private void explosion(){
        Position pos = this.getPosition();
        World world = this.game.getWorld();

        Direction dir = Direction.S;
        explosionDirection(world,dir,pos);
        dir = Direction.N;
        explosionDirection(world,dir,pos);
        dir = Direction.W;
        explosionDirection(world,dir,pos);
        dir = Direction.E;
        explosionDirection(world,dir,pos);






    }


    private void loopSprite(){
    }

    private void display(int x){

    }

    public void update(long now){
        //test si changement de sprite
        if (now - this.oldNow >= 1000 && this.numSprite < 4){
            this.numSprite ++;
            display(this.numSprite);


        }
    }
}
