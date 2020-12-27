/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.go.character;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.*;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.view.sprite.Sprite;

import java.util.List;

public class Player extends GameObject implements Movable {

    private  boolean alive = true;
    Direction direction;
    private boolean moveRequested = false;
    private int lives = 1;
    private boolean winner;
    private int changeLevel;
    private int key = 0;
    private int bombRange = 1;
    private int numberBomb = 1;


    public Player(Game game, Position position) {
        super(game, position);
        this.direction = Direction.S;
        this.lives = game.getInitPlayerLives();
    }

    public int getLives() {
        return lives;
    }

    public Direction getDirection() {
        return direction;
    }

    public void requestMove(Direction direction) {
        if (direction != this.direction) {
            this.direction = direction;
        }
        moveRequested = true;
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
    		if(mov instanceof Box) {
    			if(!((Box) mov).canMove(direction)) {
    				return false;
    			}
    			else {
    				((Box) mov).doMove(direction);
    			}
    		}
    		else if(mov instanceof Door_Next_Open) {
    			this.changeLevel =1;
    			return true;
    		}
    		else if (mov instanceof Key) {
                System.out.println("Key");
                this.key ++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    //TODO enlever le sprite
                    return true;
                }
            }
            else if (mov instanceof Monster){
                System.out.println("Monster");
                this.lives --;
                if (this.lives == 0){
                      this.alive = false;
                }
            }
            else if (mov instanceof BombRangeInc){
                this.bombRange++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    //TODO enlever le sprite
                    return true;
                }
            }
            else  if (mov instanceof BombRangeDec){
                this.bombRange --;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    //TODO enlever le sprite
                    return true;
                }
            }
            else if (mov instanceof BombInc){
                this.numberBomb ++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    //TODO enlever le sprite
                    return true;
                }
            }
            else if (mov instanceof BombDec){
                this.numberBomb --;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    //TODO enlever le sprite
                    return true;
                }
            }
            else if (mov instanceof  Heart){
                this.lives ++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    //TODO enlever le sprite
                    return true;
                }
            }
            else if (mov instanceof Princess){
                this.winner = true;
            }
    	}

    	return true;
    }

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

    public int isChangingLevel() {
    	return changeLevel;
    }

    public void resetLvl() {
    	this.changeLevel = 0;
    }

    public boolean isWinner() {
        return winner;
    }

    public boolean isAlive() {
        return alive;
    }
    public int getKey(){return this.key;}
    public void setKey(int x){this.key = x;}
    public int getBombRange(){return this.bombRange;}
    public int getNumberBomb() { return numberBomb; }
}
