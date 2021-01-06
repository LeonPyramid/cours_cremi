/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.game;


import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;

import fr.ubx.poo.game.WorldEntity;
import fr.ubx.poo.model.go.character.Player;

public class Game {

    private final World world;
    private final Player player;
    private final String worldPath;
    public int initPlayerLives;
    public int levels;
    public float invincTime;

    public Game(String worldPath) {
        //world = new WorldStatic();
        this.worldPath = worldPath;
        loadConfig(worldPath);
        world = new World(LoadLevel(levels,worldPath),this);
        Position positionPlayer = null;
        try {
            positionPlayer = world.findPlayer();
            player = new Player(this, positionPlayer);
        } catch (PositionNotFoundException e) {
            System.err.println("Position not found : " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        //world.CreateMovable(this);
    }

    public int getInitPlayerLives() {
        return initPlayerLives;
    }

    private void loadConfig(String path) {
        try (InputStream input = new FileInputStream(new File(path, "config.properties"))) {
            Properties prop = new Properties();
            // load the configuration file
            prop.load(input);
            initPlayerLives = Integer.parseInt(prop.getProperty("lives", "3"));
            levels = Integer.parseInt(prop.getProperty("levels","3"));
            invincTime = Float.parseFloat(prop.getProperty("invincTime","1f"));
        } catch (IOException ex) {
            System.err.println("Error loading configuration"+ ex);
        }
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return this.player;
    }
   
    public ArrayList<WorldEntity[][]> LoadLevel(int lvl,String path) {
    	ArrayList<WorldEntity[][]> lst = new ArrayList<WorldEntity[][]>();
    	for(int i = 0; i < lvl; i++) {
    		try (BufferedReader input = new BufferedReader(new FileReader(new File(path, "level"+(i+1)+".txt")),1024)) {
    			//creating matrix
    			input.mark(1024);
    			int height = 1;
    			int width = input.readLine().length();
    			while(input.readLine()!=null) {
    				height++;
    			}
    			input.reset();
    			WorldEntity[][] tab = new WorldEntity[height][width];
    			for(int y = 0; y < height; y ++) {
    				String line = input.readLine();
    				for (int x = 0; x < width; x++) {
    					tab[y][x] = WorldEntity.fromCode(line.charAt(x)).get();
    				}
    			}
    			
    			input.close();
    			lst.add(i,tab);
    		} catch (IOException ex) {
    			System.err.println(ex + "\nError loading "+path+"/level"+i+".txt");
    			return null;
    		}    	
    	}
    	return lst;
    }
    
}

