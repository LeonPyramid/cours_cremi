/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.go.character;

import fr.ubx.poo.engine.GameEngine;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.*;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.view.image.ImageFactory;
import fr.ubx.poo.view.image.ImageResource;
import fr.ubx.poo.view.sprite.*;

import java.util.ArrayList;
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
    public final float invincTime;
    private float untilTime;//Le temps où le joueur sera de nouveau vulnérable, ==0 si vulnerable
    private boolean isTouched; //Permet de savoir quand le player a pris des degats
    private ArrayList<Bomb> bombs;

    public Player(Game game, Position position) {
        super(game, position);
        this.direction = Direction.S;
        this.lives = game.getInitPlayerLives();
        this.invincTime = game.invincTime*1000000000;//Afin de le convertir en nanosecondes
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
    		else if(mov instanceof Door_Prev_Open) {
    			this.changeLevel =-1;
    			return true;
    		}
    		else if (mov instanceof Key) {
                System.out.println("Key");
                this.key ++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    Key key = new Key(game, mov.getPosition());
                    GameEngine.RemoveSprite(new SpriteKey(GameEngine.getLayer(), ImageFactory.getInstance().get(ImageResource.KEY), key ));
                    return true;
                }
            }
            else if (mov instanceof Monster){
                System.out.println("Monster");
                if(isTouched == false) {
                	this.lives --;
                	isTouched = true;
                	if (this.lives == 0){
                		this.alive = false;
                	}                	
                }
                
            }
            else if (mov instanceof BombRangeInc){
                this.bombRange++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    BombRangeInc bomb = new BombRangeInc(game, mov.getPosition());
                    GameEngine.RemoveSprite(new SpriteBombRangInc(GameEngine.getLayer(), ImageFactory.getInstance().get(ImageResource.BOMB_R_INC), bomb ));
                    return true;
                }
            }
            else  if (mov instanceof BombRangeDec){
                boolean b = game.getWorld().RemoveMovable(mov);
                if (this.bombRange >1){
                    this.bombRange --;
                }
                if (b) {
                    BombRangeDec bomb = new BombRangeDec(game, mov.getPosition());
                    GameEngine.RemoveSprite(new SpriteBombRangeDec(GameEngine.getLayer(), ImageFactory.getInstance().get(ImageResource.BOMB_R_DEC), bomb ));

                    return true;
                }
            }
            else if (mov instanceof BombInc){
                this.numberBomb ++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    BombInc bomb = new BombInc(game, mov.getPosition());
                    GameEngine.RemoveSprite(new SpriteBombInc(GameEngine.getLayer(), ImageFactory.getInstance().get(ImageResource.BOMB_INC), bomb ));
                    return true;
                }
            }
            else if (mov instanceof BombDec){
                boolean b = game.getWorld().RemoveMovable(mov);
                if (this.numberBomb > 1){
                    this.numberBomb --;
                }
                if (b) {
                    BombDec bomb = new BombDec(game, mov.getPosition());
                    GameEngine.RemoveSprite(new SpriteBombDec(GameEngine.getLayer(), ImageFactory.getInstance().get(ImageResource.BOMB_DEC), bomb ));
                    return true;
                }
            }
            else if (mov instanceof  Heart){
                this.lives ++;
                boolean b = game.getWorld().RemoveMovable(mov);
                if (b) {
                    Heart heart = new Heart(game, mov.getPosition());
                    GameEngine.RemoveSprite(new SpriteHeart(GameEngine.getLayer(), ImageFactory.getInstance().get(ImageResource.HEART), heart ));
                    return true;
                }
            }
            else if (mov instanceof Princess){
                this.winner = true;
            }
            //TODO Debeug tant que sprites sont relous!
            else if (mov instanceof Bomb){
                System.out.println("Bomb");
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
        if(isTouched) {
        	if(untilTime == 0) {
        		System.out.println("Je suis touché et invincible!");
        		untilTime = now + invincTime;
        	}
        	else if(untilTime <= now) {
        		isTouched = false;
        		untilTime = 0;

        		System.out.println("Je ne suis plus invincible!");
        	}
        	
        }
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
    
    public boolean isTouched() {
    	return isTouched;
    }
    public int getKey(){return this.key;}
    public void setKey(int x){this.key = x;}
    public int getBombRange(){return this.bombRange;}
    public int getNumberBomb() { return numberBomb; }
    public void setNumberBomb(int x){this.numberBomb = x;}
    public void setLives(int x){ this.lives = x;}
}
