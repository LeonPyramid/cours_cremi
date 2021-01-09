package fr.ubx.poo.model.go.character;


import fr.ubx.poo.engine.GameEngine;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.BombDec;
import fr.ubx.poo.model.go.BombInc;
import fr.ubx.poo.model.go.BombRangeDec;
import fr.ubx.poo.model.go.BombRangeInc;
import fr.ubx.poo.model.go.Box;
import fr.ubx.poo.model.go.Door_Next_Open;
import fr.ubx.poo.model.go.Door_Prev_Open;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.model.go.Heart;
import fr.ubx.poo.model.go.Key;
import fr.ubx.poo.model.go.Princess;
import fr.ubx.poo.model.go.Unplayer;
import fr.ubx.poo.view.image.ImageFactory;
import fr.ubx.poo.view.image.ImageResource;
import fr.ubx.poo.view.sprite.SpriteBombDec;
import fr.ubx.poo.view.sprite.SpriteBombInc;
import fr.ubx.poo.view.sprite.SpriteBombRangInc;
import fr.ubx.poo.view.sprite.SpriteBombRangeDec;
import fr.ubx.poo.view.sprite.SpriteHeart;
import fr.ubx.poo.view.sprite.SpriteKey;

//TODO a faire complet
public class Monster extends Unplayer implements Movable {
	Direction direction;
	private float timeMin = 0.5f;
	private float timeMax =0.8f;
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
    		nextmve += ((Math.random()*((timeMax-timeMin)+1))+timeMin)*1000000000;
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

	