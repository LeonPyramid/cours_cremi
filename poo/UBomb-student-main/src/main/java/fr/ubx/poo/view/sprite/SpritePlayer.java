/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.character.Player;
import fr.ubx.poo.view.image.ImageFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;

public class SpritePlayer extends SpriteGameObject {
    private final ColorAdjust effect;
    private float b = 0.7f;
    
    public SpritePlayer(Pane layer, Player player) {
        super(layer, null, player);
        effect  = new ColorAdjust();
        updateImage();
    }

    @Override
    public void updateImage() {
        Player player = (Player) go;
        setImage(ImageFactory.getInstance().getPlayer(player.getDirection()));
        if(player.isTouched()) {
        	effect.setBrightness(b);
        	setFX(effect);
        }
        else {
        	effect.setBrightness(0);
        	setFX(effect);
        }
    }
}
