package fr.ubx.poo.model.go;
import fr.ubx.poo.engine.GameEngine;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.game.World;
import fr.ubx.poo.view.sprite.SpriteFactory;



//TODO  loop sprite
public  class Bomb extends Unplayer{
    private int state;
    private long start;
    private boolean exploded = false;
    final private int range;


    public Bomb (Game game, Position position){
        super(game, position);
        this.state = 0;
        this.start = 0;
        this.range = game.getPlayer().getBombRange();
    }


    private void explosionDirection (World world,Direction direction, Position start){

        Position newPos = start;

        for (int rng = 0; rng<this.range; rng++){

            newPos = direction.nextPosition(newPos);
            if (!world.isEmpty(newPos)){
                break;
            }
            if (newPos.equals(game.getPlayer().getPosition())){
                game.getPlayer().takeDamage();
            }

            GameObject mov = world.returnMovable(newPos);

            if (mov instanceof Key || mov instanceof Door_Next_Open || mov instanceof Door_Next_Closed || mov instanceof  Door_Prev_Open || mov instanceof Princess){
                break;
            }

            if (mov instanceof Bomb){
                ((Bomb) mov).setState(3);

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

    public boolean update(long now){
        if (start == 0) {
            this.start = now;
        }

        if (now >= start + 1000000000){
            if (state == 6){
                return true;
            }
            if (state == 3){
                state ++;
                explosion();
                this.exploded = true;
            }else{
                state ++;
                start = start + 1000000000;
            }
        }
        return false;
    }

    public int getState(){return this.state;}
    public void setState(int x){state = x;}
    public boolean getExploded(){return this.exploded;}
    public void setExploded(boolean x){this.exploded = x;}
}
