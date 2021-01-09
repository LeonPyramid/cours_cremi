package fr.ubx.poo.model.go.character;


import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.model.go.Unplayer;

public class Monster extends Unplayer implements Movable {
	Direction direction;
	private float timeMin = 0.7f;
	private float timeMax =1f;
	private long nextmve;
    public Monster (Game game, Position position){
    	super (game, position);
    	direction = Direction.S;
    	nextmve = 0;
    }

    @Override
    public String toString() { return "Monster"; }

    @Override
    public void doMove(Direction direction) {
    	Position nextPos = direction.nextPosition(getPosition());
    	game.getWorld().RemoveMovable(this);
        setPosition(nextPos);
        game.getWorld().SetMovable(nextPos, this);
        GameObject mov = game.getWorld().returnMovable(nextPos);
        //System.out.println("my pos" + nextPos + " player pos" + game.getPlayer().getPosition());
        if(nextPos.equals(game.getPlayer().getPosition())) {
        	game.getPlayer().takeDamage();
    	}
    }

    @Override
    public boolean canMove(Direction direction) {
    	Position newPos = direction.nextPosition(this.getPosition());

    	if(!game.getWorld().isInside(newPos)) {
    		return false;
    	}

    	if(!game.getWorld().isEmpty(newPos)) {
    		return false;
    	}

    	GameObject mov = game.getWorld().returnMovable(newPos);
    	if(mov!=null) {
    		return false;
    	}
    	return true;
    }
    
    public Direction getDirection() {
    	return direction;
    }
    
    public void update(long now) {
    	if(nextmve == 0) {
    		nextmve = now;
    		
    		nextmve += ((Math.random()*((timeMax-timeMin)+1))+timeMin)*1000000000/(game.getWorld().getActualLvl()+1);
    	}
    	if(now>=nextmve) {
    		boolean requestMove = true;
    		do {
    			direction = Direction.random();
    			if(canMove(direction)) {
    				doMove(direction);
    				requestMove = false;
    			}
    		}while(requestMove);
    		
    		nextmve = (long) (now + ((Math.random()*((timeMax-timeMin)+1))+timeMin)*1000000000);
    	}
    }
}

	