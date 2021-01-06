package fr.ubx.poo.model.go;
import fr.ubx.poo.engine.GameEngine;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.game.World;
import fr.ubx.poo.view.image.ImageFactory;
import fr.ubx.poo.view.image.ImageResource;
import fr.ubx.poo.view.sprite.Sprite;
import fr.ubx.poo.view.sprite.SpriteFactory;



//TODO  loop sprite
public  class Bomb extends Unplayer{
    private int numSprite;
    private long oldNow;

    public Bomb (Game game, Position position){
        super(game, position);
        this.numSprite = 0;
        this.oldNow = 0;
        game.getWorld().SetMovable(this.getPosition(),this);
        game.getPlayer().setNumberBomb(game.getPlayer().getNumberBomb()-1);
        bombuse();
        game.getPlayer().setNumberBomb(game.getPlayer().getNumberBomb()+1);
        game.getWorld().RemoveMovable(this);
    }


    public void bombuse(){
        lineSprite();
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
                game.getPlayer().takeDamage();
            }

            GameObject mov = world.returnMovable(newPos);

            if (mov instanceof Key || mov instanceof Door_Next_Open || mov instanceof Door_Next_Closed || mov instanceof  Door_Prev_Open){
                break;
            }

            if (mov instanceof Bomb){
                ((Bomb) mov).explosion();

            }

            if (  mov != null ){
                world.RemoveMovable(mov);
                GameEngine.RemoveSprite(SpriteFactory.createMovables(GameEngine.getLayer(),newPos,mov));
                break;
            }
        }
    }
    protected void explosion(){
        Position pos = this.getPosition();
        World world = this.game.getWorld();

        if (pos.equals(game.getPlayer().getPosition()))
            game.getPlayer().takeDamage();

        Direction dir = Direction.S;
        explosionDirection(world,dir,pos);
        dir = Direction.N;
        explosionDirection(world,dir,pos);
        dir = Direction.W;
        explosionDirection(world,dir,pos);
        dir = Direction.E;
        explosionDirection(world,dir,pos);
    }

    private void lineSprite(){
        Sprite spriteBomb = GameEngine.MovableSpriteAdder(this.getPosition(),this,GameEngine.getSprite());
        for (int i = 2; i < 7; i++){
            System.out.println("Normalement tempo");
            display(i, spriteBomb);
        }
    }

    private void display(int x, Sprite bomb){
        if (x==2){
            System.out.println("Sprite 2");
            bomb.setImage(ImageFactory.getInstance().get(ImageResource.BOMB3));
        }
        if (x==3){
            System.out.println("Sprite 3");
            bomb.setImage(ImageFactory.getInstance().get(ImageResource.BOMB2));
        }
        if (x==4){
            System.out.println("Sprite 4");
            bomb.setImage(ImageFactory.getInstance().get(ImageResource.BOMB1));
        }
        if (x==5){
            System.out.println("Sprite exwplosion");
            bomb.setImage(ImageFactory.getInstance().get(ImageResource.EXPLOSION));
        }
        if (x==6){
            System.out.println("Suppression sprite");
            GameEngine.RemoveSprite(bomb);
        }
    }

    public void update(long now){
        //test si changement de sprite
        if (now - this.oldNow >= 1000 && this.numSprite < 4){
            this.numSprite ++;
            //display(this.numSprite);
        }
    }
}
