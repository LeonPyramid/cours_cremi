/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.character.Player;
import fr.ubx.poo.view.image.ImageFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;

public class SpritePlayer extends SpriteGameObject {
    private final ColorAdjust effect = new ColorAdjust();
    private float c = 1f;
    
    public SpritePlayer(Pane layer, Player player) {
        super(layer, null, player);
        effect.setContrast(c);
        updateImage();
    }

    @Override
    public void updateImage() {
        Player player = (Player) go;
        setImage(ImageFactory.getInstance().getPlayer(player.getDirection()));
        try {
        	setFX(effect);	
        } catch (Exception e) {
        	System.out.println("ça marche pas" + e);
        }
        
    }
}
