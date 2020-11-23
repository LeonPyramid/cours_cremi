/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.game;

import fr.ubx.poo.model.decor.Decor;
import fr.ubx.poo.model.go.*;
import javafx.geometry.Pos;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.BiConsumer;

public class World {
    private final Map<Position, Decor> grid;
    private Map<Position, GameObject> movables = new Hashtable<>();
    private final WorldEntity[][] raw;
    public final Dimension dimension;

    public World(WorldEntity[][] raw) {
        this.raw = raw;
        dimension = new Dimension(raw.length, raw[0].length);
        grid = WorldBuilder.build(raw, dimension);
    }

    public Position findPlayer() throws PositionNotFoundException {
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.Player) {
                    return new Position(x, y);
                }
            }
        }
        throw new PositionNotFoundException("Player");
    }

    
    public void CreateMovable(Game game) {
    	for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
            		switch (raw[y][x]) {
            		case Box:
            			Position pos = new Position(x,y);
            			movables.put(pos,new Box(game,pos));
            			//System.out.println("j'ai mis une box");
            			break;
                    default:
                }
            }
        }
    }


    public Decor get(Position position) {
        return grid.get(position);
    }

    public void set(Position position, Decor decor) {
        grid.put(position, decor);
    }

    public void clear(Position position) {
        grid.remove(position);
    }

    public void forEach(BiConsumer<Position, Decor> fn) {
        grid.forEach(fn);
    }

    public void forEachMovables(BiConsumer<Position,GameObject> fn){movables.forEach(fn);}

    public Collection<Decor> values() {
        return grid.values();
    }

    public boolean isInside(Position position) {
        return true; // to update
    }

    public boolean isEmpty(Position position) {
        return grid.get(position) == null;
    }
    
    public void SetMovable(Position pos, GameObject go){
    	if(movables.get(pos)!=null) {
    		throw new PositionAlreadyTakenException("Can't put " +go+" at "+ pos + " ; taken by " + movables.get(pos));
    	}
    	else {
    		movables.put(pos,go);
    	}
    }
    
    public boolean RemoveMovable(GameObject go) {
    	if(movables.containsValue(go)) {
    		movables.remove(go.getPosition());
    		return true;
    	}
    	return false;
    }
    
    public GameObject returnMovable(Position position) {return movables.get(position);}
    
    public Map<Position,GameObject> getMovables(){return movables;}
}
