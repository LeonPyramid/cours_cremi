package fr.ubx.poo.model.go;
import fr.ubx.poo.engine.GameEngine;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.game.World;
import fr.ubx.poo.view.sprite.SpriteFactory;



public  class Bomb extends Unplayer{
    private int state;
    private long start;
    private boolean exploded = false;
    private boolean hasexploded = false;
    final private int range;
    private final int lvl;


    public Bomb (Game game, Position position){
        super(game, position);
        this.state = 0;
        this.start = 0;
        this.range = game.getPlayer().getBombRange();
        this.lvl = game.getWorld().getActualLvl();
    }


    private void explosionDirection (World world,Direction direction, Position start){

        Position newPos = start;

        for (int rng = 0; rng<this.range; rng++){

            newPos = direction.nextPosition(newPos);
            if (!world.isEmpty(newPos,lvl)){
                break;
            }
            if (newPos.equals(game.getPlayer().getPosition())){
                game.getPlayer().takeDamage();
            }

            GameObject mov = world.returnMovable(newPos,lvl);

            if (mov instanceof Key || mov instanceof Door_Next_Open || mov instanceof Door_Next_Closed || mov instanceof  Door_Prev_Open || mov instanceof Princess){
                break;
            }

            if (mov instanceof Bomb){
                if (! ((Bomb) mov).getHasExploded())
                ((Bomb) mov).setState(3);

            }

            if (  mov != null ){
                world.RemoveMovable(mov,lvl);
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
        this.exploded = true;
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
                this.hasexploded = true;
                explosion();
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
    private boolean getHasExploded(){return this.hasexploded;}
}
