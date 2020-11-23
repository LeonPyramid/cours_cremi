/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.game;

import fr.ubx.poo.model.decor.Decor;
import fr.ubx.poo.model.go.*;
import fr.ubx.poo.model.go.character.Monster;
import javafx.geometry.Pos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.BiConsumer;



public class World {
	private final Game game;
    private final ArrayList<Map<Position, Decor>> grid ;
    private ArrayList<Map<Position, GameObject>> movables = new ArrayList<Map<Position, GameObject>>();
    private final ArrayList<WorldEntity[][]> raw;
    public final ArrayList<Dimension> dimension;
    public int actualLvl;
    
    public World(ArrayList<WorldEntity[][]> raw, Game game) {
    	this.game = game;
    	actualLvl = 0;
    	ArrayList<Map<Position, Decor>> tmpgrid = new ArrayList<Map<Position, Decor>>();
    	this.raw = raw;
        raw.forEach(wet -> tmpgrid.add(WorldBuilder.build(wet,new Dimension(wet.length,wet[0].length))));
        ArrayList<Dimension> lst = new ArrayList<Dimension>();
        raw.forEach(wet -> lst.add(new Dimension(wet.length,wet[0].length)));
        dimension = lst;
        grid = tmpgrid;
        CreateMovable(game);
    }

    public Position findPlayer() throws PositionNotFoundException {
        for (int x = 0; x < dimension.get(actualLvl).width; x++) {
            for (int y = 0; y < dimension.get(actualLvl).height; y++) {
            	System.out.print(raw.get(actualLvl)[y][x]);
                if (raw.get(actualLvl)[y][x] == WorldEntity.Player) {
                    return new Position(x, y);
                }
            }
            System.out.println();
        }
        throw new PositionNotFoundException("Player; Lvl =  ");
    }

    
    public Dimension actualDim() {
    	return dimension.get(actualLvl);
    }

    public void CreateMovable(Game game) {
    	for (int i = 0; i < game.levels; i ++) {
    		Map<Position,GameObject> ht = new Hashtable<>();	
    		for (int x = 0; x < dimension.get(i).width; x++) {
    			for (int y = 0; y < dimension.get(i).height; y++) {
    				switch (raw.get(i)[y][x]) {
    				case Box:
    					Position pos = new Position(x,y);
    					ht.put(pos,new Box(game,pos));
    					break;
    				case Key:
    					pos = new Position(x,y);
    					ht.put(pos,new Key(game,pos));
    					break;
    				case Heart:
    					pos =new Position(x,y);
    					ht.put(pos,new Heart(game,pos));
    					break;
    				case Monster:
    					pos = new Position(x,y);
    					ht.put(pos,new Monster(game,pos));
    					break;
    				case Princess:
    					pos = new Position(x,y);
    					ht.put(pos,new Princess(game,pos));
    					break;
    				case BombRangeInc:
    					pos = new Position(x,y);
    					ht.put(pos,new BombRangeInc(game,pos));
    					break;
    				case BombRangeDec:
    					pos = new Position(x,y);
    					ht.put(pos,new BombRangeDec(game,pos));
    					break;
    				case BombNumberInc:
    					pos= new Position(x,y);
    					ht.put(pos,new BombInc(game,pos));
    					break;
    				case DoorNextOpened:
    					pos =new Position(x,y);
    					ht.put(pos,new Door_Next_Open(game,pos));
    					break;
    				case DoorNextClosed:
    					pos =new Position(x,y);
    					ht.put(pos,new Door_Next_Closed(game,pos));
    					break;	
    				default:
    				}
    				movables.add(ht);
    			}
    		
    		}
        }
    }


    public Decor get(Position position) {
        return grid.get(actualLvl).get(position);
    }

    public void set(Position position, Decor decor) {
        grid.get(actualLvl).put(position, decor);
    }

    public void clear(Position position) {
        grid.get(actualLvl).remove(position);
    }

    public void forEach(BiConsumer<Position, Decor> fn) {
        grid.get(actualLvl).forEach(fn);
    }

    public void forEachMovables(BiConsumer<Position,GameObject> fn){movables.get(actualLvl).forEach(fn);}

    public Collection<Decor> values() {
        return grid.get(actualLvl).values();
    }

    public boolean isInside(Position position) {
        return true; // to update
    }

    public boolean isEmpty(Position position) {
        return grid.get(actualLvl).get(position) == null;
    }
    
    public void SetMovable(Position pos, GameObject go){
    	if(movables.get(actualLvl).get(pos)!=null) {
    		throw new PositionAlreadyTakenException("Can't put " +go+" at "+ pos + " ; taken by " + movables.get(actualLvl).get(pos));
    	}
    	else {
    		movables.get(actualLvl).put(pos,go);
    	}
    }
    
    public boolean RemoveMovable(GameObject go) {
    	if(movables.get(actualLvl).containsValue(go)) {
    		movables.get(actualLvl).remove(go.getPosition());
    		return true;
    	}
    	return false;
    }
    
    public GameObject returnMovable(Position position) {return movables.get(actualLvl).get(position);}
    
    public Map<Position,GameObject> getMovables(){return movables.get(actualLvl);}
}
